package com.simo.meitan.epubparsing;

import nl.siegmann.epublib.domain.*;
import nl.siegmann.epublib.epub.EpubReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class EpubParseTest {
    public static void  printContentTitle(TOCReference tocReference,Integer deep){
        for(int i=0;i<deep;i++){
            System.out.print(">");
        }
        System.out.println(tocReference.getTitle()+" ");
        if(tocReference.getChildren().size()>0){
            for(TOCReference tocReference1 : tocReference.getChildren()){
                printContentTitle(tocReference1,deep+1);
            }
        }

    }
    @Test
    public void testParsing(){
        File file = new File("C:\\Users\\simo\\Desktop\\一本书看懂中国史-马件涛.epub");
        InputStream in = null;
        try {
            //从输入流当中读取epub格式文件
            EpubReader reader = new EpubReader();
            in = new FileInputStream(file);
            Book book = reader.readEpub(in);
            //获取到书本的头部信息
            Metadata metadata = book.getMetadata();
            System.out.println("FirstTitle为："+metadata.getFirstTitle());
            System.out.println("FirstTitle为："+metadata.getAuthors());
            //image
            System.out.println(book.getCoverImage().getHref());
            //opf
            System.out.println(book.getOpfResource().getHref());
            //获取到书本的全部资源
            Resources resources = book.getResources();
            System.out.println("所有资源数量为："+resources.size());
            //获取所有的资源数据
            Collection<String> allHrefs = resources.getAllHrefs();
            for (String href : allHrefs) {
                Resource resource = resources.getByHref(href);
                //data就是资源的内容数据，可能是css,html,图片等等
                byte[] data = resource.getData();
                // 获取到内容的类型  css,html,还是图片
                MediaType mediaType = resource.getMediaType();
            }
            //获取到书本的内容资源
            List<Resource> contents = book.getContents();
            System.out.println("内容资源数量为："+contents.size());
            //获取到书本的spine资源 线性排序
            Spine spine = book.getSpine();
            System.out.println("spine资源数量为："+spine.size());
            //通过spine获取所有的数据
            List<SpineReference> spineReferences = spine.getSpineReferences();
            for (SpineReference spineReference : spineReferences) {
                Resource resource = spineReference.getResource();
                //data就是资源的内容数据，可能是css,html,图片等等
                byte[] data = resource.getData();
                // 获取到内容的类型  css,html,还是图片
                MediaType mediaType = resource.getMediaType();
            }
            //获取到书本的目录资源
            TableOfContents tableOfContents = book.getTableOfContents();
            System.out.println("目录资源数量为："+tableOfContents.size());
            List<TOCReference> allReferences=tableOfContents.getTocReferences();
            for(TOCReference reference : allReferences){
                Resource resource=reference.getResource();
                System.out.println(reference.getTitle()+" "+resource.getHref());
            }
            //获取到目录对应的资源数据
            List<TOCReference> tocReferences = tableOfContents.getTocReferences();
            for (TOCReference tocReference : tocReferences) {
                printContentTitle(tocReference,0);
//                Resource resource = tocReference.getResource();
//                //目录标题
//                System.out.println(tocReference.getTitle());
//                //data就是资源的内容数据，可能是css,html,图片等等
//                byte[] data = resource.getData();
//                // 获取到内容的类型  css,html,还是图片
//                MediaType mediaType = resource.getMediaType();
//                if(tocReference.getChildren().size()>0){
//                    //获取子目录的内容
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //一定要关闭资源
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
