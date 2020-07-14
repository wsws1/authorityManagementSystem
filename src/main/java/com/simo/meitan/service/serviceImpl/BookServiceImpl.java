package com.simo.meitan.service.serviceImpl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.model.Book;
import com.simo.meitan.mapper.BookMapper;
import com.simo.meitan.service.BookService;
import org.springframework.util.StringUtils;

@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book record)  {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

	@Override
    public  PageInfo<Book> selectAllByTitleLikeAndAuthorLikeAndCategory(
            String likeTitle,
            String likeAuthor,
            Integer category,
            Integer page,
            Integer size,
            String sort){
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<Book> bookList=null;
        if(StringUtils.isEmpty(sort)||sort.indexOf('+')>=0) {
            bookList= bookMapper.selectAllByTitleLikeAndAuthorLikeAndCategoryOrderById(likeTitle, likeAuthor, category);
        }else{
            bookList= bookMapper.selectAllByTitleLikeAndAuthorLikeAndCategoryOrderByIdDesc(likeTitle, likeAuthor, category);
        }
		 return new PageInfo<>(bookList);
	}


}
