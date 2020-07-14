package com.simo.meitan.utils;

import cn.hutool.core.util.ZipUtil;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static String getfileAbsolutePath(String filePath){
       return ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/"+filePath;
    }

    public static String getStaticPath(){
        return ClassUtils.getDefaultClassLoader().getResource("static").getPath() ;
    }
    /**
     * 保存上传的文件
     *
     * @param file
     * @return 文件相对路径
     * @throws Exception
     */
    public static String unifiedFileUpload(MultipartFile file,String typeName) throws Exception {

        if (file.isEmpty()|| StringUtils.isEmpty(typeName)) {
            return "";
        }
        String filePathPrefix="file/"+typeName;
        String fileDirPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/"+filePathPrefix;
        return filePathPrefix+"/" + saveFile(fileDirPath, file);
    }

    /**
     *
     * @param filePath
     * @param typeName
     * @return file/typeName/unzip/xxxx
     * @throws Exception
     */
    public static String unifiedFileUnZip(String filePath,String typeName) throws Exception {
        String unZipPath="";
        if (filePath.isEmpty()|| StringUtils.isEmpty(typeName)) {
            return unZipPath;
        }
        String fileAbsolutePath=getfileAbsolutePath(filePath);
        String folderName=UUID.randomUUID().toString();
        unZipPath="file/"+typeName+"/unzip/"+folderName;
        String unZipAbsolutePath=getStaticPath()+"/"+unZipPath;
         ZipUtil.unzip(fileAbsolutePath, unZipAbsolutePath);
        return unZipPath;
    }


    public static String saveFile(String filePath, MultipartFile file) throws Exception{
        File fileDir = new File(filePath);
        System.out.println(fileDir.mkdirs());

        String filename = file.getOriginalFilename();

        System.out.println(fileDir.getAbsolutePath());

        String suffixName;
        suffixName= filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID() + suffixName;
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
        System.out.println(newFile.getAbsolutePath());
        // 上传文件到 -》 “绝对路径”
        file.transferTo(newFile);
        return filename;
    }

}
