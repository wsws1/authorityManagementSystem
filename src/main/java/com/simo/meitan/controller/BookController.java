package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.BookDTO;
import com.simo.meitan.dto.ContentDTO;
import com.simo.meitan.model.Category;
import com.simo.meitan.model.Contents;
import com.simo.meitan.service.BookService;
import com.simo.meitan.service.CategoryService;
import com.simo.meitan.service.ContentsService;
import com.simo.meitan.utils.EpubUtil;
import com.simo.meitan.utils.FileUtil;
import com.simo.meitan.utils.RestResponse;
import com.simo.meitan.vo.BookVO;
import com.simo.meitan.vo.CategoryVO;
import com.simo.meitan.vo.ContentVO;
import nl.siegmann.epublib.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/book")
public class BookController {
    public static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @Autowired
    ContentsService contentsService;

    @Autowired
    CategoryService categoryService;
    @PostMapping("/upload")
    public RestResponse uploadImg(MultipartFile file) throws Exception {
        String typeName="book";
        if(!(file==null|| Objects.equals(file.getOriginalFilename(), ""))){
            String fileOriginalName=file.getOriginalFilename();
            //获取图书存储相对路径
            String saveUrl= FileUtil.unifiedFileUpload(file,typeName);
            //解析图书
            Book book=null;

            try{
                book=EpubUtil.getEupbBook(saveUrl);
            }catch (Exception e){
                return RestResponse.fail("图书解析失败");
            }
            // 封装book 基本信息
            BookVO bookVO=new BookVO();
            Metadata metadata=book.getMetadata();
            bookVO.setTitle(book.getTitle());
            bookVO.setOriginalName(fileOriginalName);
            List<Author> authors=metadata.getAuthors();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=0;i<authors.size();i++){
                Author curAuthor=authors.get(i);
                stringBuilder.append(curAuthor.getFirstname()+" "+curAuthor.getLastname());
                if(i<authors.size()-1){
                    stringBuilder.append(",");
                }
            }
            bookVO.setAuthor(stringBuilder.toString());

            bookVO.setCategory(45);
            bookVO.setCategoryText("测试分类");

            bookVO.setLanguage(metadata.getLanguage());
            List<String> publishers=metadata.getPublishers();
            StringBuilder publishersNameBuilder=new StringBuilder();
            for (int i=0;i<publishers.size();i++){
                publishersNameBuilder.append(publishers.get(i));
                if(i<authors.size()-1){
                    stringBuilder.append(",");
                }
            }
            bookVO.setPublisher(publishersNameBuilder.toString());

            bookVO.setPath(saveUrl);

            bookVO.setFileName(saveUrl.substring(saveUrl.lastIndexOf('/')+1,saveUrl.lastIndexOf('.')));

            //解压文件
            String unzipPath=FileUtil.unifiedFileUnZip(saveUrl,typeName);
            System.out.println(unzipPath);
            bookVO.setUnzipPath(unzipPath);
            // 根文件目录前缀
            String folderPrefix="";
            String opfPath=book.getOpfResource().getHref();
            if (opfPath.indexOf('/')>-1){
                folderPrefix=opfPath.substring(0,opfPath.indexOf('/'));
                folderPrefix+='/';
            }
            if(book.getCoverImage()!=null){
                bookVO.setCover(unzipPath+"/"+folderPrefix+book.getCoverImage().getHref());
            }

            bookVO.setRootFile(unzipPath+"/"+opfPath);

            //生成目录
            List<ContentVO> contentVOList=new ArrayList<>();
            List<TOCReference> topTocRefrenceList=book.getTableOfContents().getTocReferences();

            for(TOCReference tocReference : topTocRefrenceList){
                ContentVO contentVO=new ContentVO();
                contentVO.setText(unzipPath+"/"+folderPrefix+tocReference.getCompleteHref());

                contentVO.setLabel(fileOriginalName);
                contentVO.setLabel(tocReference.getTitle());
                contentVO.setFileName(bookVO.getFileName());
                List<ContentVO> chidrenContentList=new ArrayList<>();

                if (tocReference.getChildren().size()>0){
                    generateContentsTree(tocReference.getChildren(),
                            chidrenContentList,
                            unzipPath,
                            folderPrefix,
                            bookVO.getFileName()
                            );
                }
                contentVO.setChildren(chidrenContentList);
                contentVOList.add(contentVO);
            }

            bookVO.setContentsTree(contentVOList);
            return  RestResponse.succuess(bookVO,"上传图书成功");
        }
        return RestResponse.fail("上传失败");
    }

    @PostMapping("/update")
    public RestResponse updateBook(@RequestBody  BookDTO bookDTO) {
        com.simo.meitan.model.Book book = new com.simo.meitan.model.Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setLanguage(bookDTO.getLanguage());
        book.setUpdatetype(1);
        book.setId(bookDTO.getBookId());
        bookService.updateByPrimaryKeySelective(book);

        return RestResponse.succuess(null,"更新图书成功");
    }
    @PostMapping("/create")
    public RestResponse createBook(@RequestBody  BookDTO bookDTO) throws Exception {
        com.simo.meitan.model.Book book=new com.simo.meitan.model.Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setCategory(bookDTO.getCategory());
        book.setCategorytext(bookDTO.getCategoryText());
        book.setCover(bookDTO.getCover());
        book.setCover(bookDTO.getCover());
        book.setFilepath(bookDTO.getPath());
        book.setRootfile(bookDTO.getRootFile());
        book.setUnzippath(bookDTO.getUnzipPath());
        book.setLanguage(bookDTO.getLanguage());
        book.setFilename(bookDTO.getFileName());
        book.setOriginalname(bookDTO.getOriginalName());
        book.setUpdatetype(0);
        book.setCreatedt(System.currentTimeMillis());
        int recode=0;
        try {
            recode= bookService.insert(book);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new Exception("不要重复添加图书哟╮（╯＿╰）╭");
        }

        if(recode>0){
            for (ContentDTO contentDTO :bookDTO.getContentsTree()){
                insertTreeContent(contentDTO,book.getId(),-1);
            }
            return RestResponse.succuess(null,"创建图书成功");
        }
        return RestResponse.fail("图书添加失败");
    }
    public  void insertTreeContent(ContentDTO contentDTO,Integer bookId ,Integer parentId){
        Contents contents=new Contents();
        contents.setBookid(bookId);
        contents.setLabel(contentDTO.getLabel());
        contents.setText(contentDTO.getText());
        contents.setBookid(bookId);
        contents.setFilename(contentDTO.getFileName());
        contents.setPid(parentId);
        contentsService.insert(contents);
        if(contentDTO.getChildren().size()>0){
            for(ContentDTO childrenContenDto :contentDTO.getChildren()){
                insertTreeContent(childrenContenDto,bookId,contents.getId());
            }
        }
    }

    public  void generateContentsTree(List<TOCReference> tocReferences,
                                                       List<ContentVO> contentVOList,
                                                       String unzipPath,
                                                        String folderPrefix,
                                                        String fileName){

        for(TOCReference tocReference :tocReferences){
            ContentVO contentVO=new ContentVO();
            List<ContentVO> childrenContentList=new ArrayList<>();
            contentVO.setLabel(tocReference.getTitle());
            contentVO.setText(unzipPath+"/"+folderPrefix+tocReference.getCompleteHref());
            contentVO.setFileName(fileName);
            if (tocReference.getChildren().size()>0){
                generateContentsTree(tocReference.getChildren(),
                        childrenContentList,
                        unzipPath,
                        folderPrefix,
                        fileName);
            }
            contentVO.setChildren(childrenContentList);
            contentVOList.add(contentVO);

        }
    }

    @GetMapping("/get")
    public RestResponse getBook(@RequestParam("bookId") Integer  bookId){
        if(bookId!=null){
            return RestResponse.succuess(buildContentsVOFromDataBase(bookId));
        }else{
            return RestResponse.fail("bookId error");
        }

    }

    private BookVO buildContentsVOFromDataBase(Integer bookId) {

        com.simo.meitan.model.Book book=bookService.selectByPrimaryKey(bookId);
        BookVO bookVO=new BookVO();
        bookVO.setOriginalName(book.getOriginalname());
        bookVO.setFileName(book.getFilename());
        bookVO.setRootFile(book.getRootfile());
        bookVO.setCategoryText(book.getCategorytext());
        bookVO.setCategory(book.getCategory());
        bookVO.setCover(book.getCover());
        bookVO.setUnzipPath(book.getUnzippath());
        bookVO.setPath(book.getFilepath());
        bookVO.setLanguage(book.getLanguage());
        bookVO.setTitle(book.getTitle());
        bookVO.setOriginalName(book.getOriginalname());
        bookVO.setPublisher(book.getPublisher());
        bookVO.setAuthor(book.getAuthor());
        List<Contents> contentsList=contentsService.selectAllByBookid(bookId);

        //目标List
        List<ContentVO> contentVOList=new ArrayList<>();
        // 辅助队列 1
        Queue<ContentVO> contentVOQueue=new ArrayDeque<>();
        //辅助队列 2
        Queue<Contents> contentsQueue=new ArrayDeque<>();
        //顶级目录入队
        for(int i=0;i<contentsList.size();i++){
            Contents contents=contentsList.get(i);
            if(contents.getPid()==-1){
                contentsQueue.add(contents);
                contentVOQueue.add(new ContentVO());
            }
        }
        while (contentsQueue.size()>0){
//            System.out.println("asd");
             Contents top=contentsQueue.remove();
             ContentVO contentVO=contentVOQueue.remove();
             contentVO.setFileName(top.getFilename());
             contentVO.setLabel(top.getLabel());
             contentVO.setText(top.getText());
             contentVO.setPid(top.getPid());
             List<ContentVO> childrenContentsVoList=new ArrayList<>();
             boolean haschild=false;
             for(Contents contents : contentsList) {
//                 System.out.println(contents.getPid() +"  :  "+top.getId());
                 if(contents.getPid().equals(top.getId())) {
                     haschild=true;
                     ContentVO contentVO1=new ContentVO();
                     List<ContentVO> fakeList=new ArrayList<>();
                     contentVO1.setChildren(fakeList);
                     childrenContentsVoList.add(contentVO1);
                     contentsQueue.add(contents);
                     contentVOQueue.add(contentVO1);

                 }
             }
             if(haschild||top.getPid().equals(-1)){
                 contentVO.setChildren(childrenContentsVoList);
                 contentVOList.add(contentVO);
             }
        }
        bookVO.setContentsTree(contentVOList);
        return bookVO;
    }

    @GetMapping("/category")
    public RestResponse getBookCategory(){
        List<Category> categorieList=categoryService.selectAllOrderByCategory();
        List<CategoryVO> categoryVOList=new ArrayList<>();
        for(Category category:categorieList){
            CategoryVO categoryVO=new CategoryVO();
            categoryVO.setLabel(category.getCategorytext());
            categoryVO.setNum(category.getNum());
            categoryVO.setValue(category.getCategory());
            categoryVOList.add(categoryVO);
        }
        return RestResponse.succuess(categoryVOList,"查询分类成功");
    }

    @GetMapping("/list")
    public RestResponse queryBook(@RequestParam(value = "title",required = false) String title,
                     @RequestParam(value ="author",required = false) String author,
                     @RequestParam(value="category",required = false) Integer category,
                     @RequestParam(value="sort",required = false) String sort,
                     @RequestParam("page") Integer page,
                     @RequestParam("size") Integer size){
        System.out.println(sort);
        PageInfo<com.simo.meitan.model.Book>
        pageInfo =bookService.selectAllByTitleLikeAndAuthorLikeAndCategory(
                title,
                author,
                category,
                page,
                size,
                sort
        );
        return RestResponse.succuess(pageInfo,"查询成功");
    }

    @GetMapping("/delete")
    public RestResponse deleteBook(@RequestParam("id") Integer id){

        if(id!=null){
            int recode=bookService.deleteByPrimaryKey(id);
            //todo
            //删除目录
            //删除文件
            //删除文件夹
            if(recode>0){
                return RestResponse.succuess(recode,"删除成功");
            }else{
                return RestResponse.succuess(recode,"电子书不存在");
            }
        }
        return  RestResponse.fail("图书id错误");
    }
}

