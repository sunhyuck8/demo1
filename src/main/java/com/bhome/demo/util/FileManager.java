package com.bhome.demo.util;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Component
public class FileManager {

    String savePath = "/resources/data/";

    //multipartformdata를 filename 만들어 넣어주는 작업



    //파일의 확장자가져오기
    public String getExt(String filename) {
        int lastIndex = filename.lastIndexOf(".");
        return filename.substring(lastIndex+1, filename.length());
    }

    //파일 저장하기
    public void saveFile (ServletContext context, String fileName, MultipartFile multi) throws FileUploadException {
        System.out.println(context.getRealPath(savePath));

        try {
            multi.transferTo(new File(context.getRealPath(savePath)+fileName));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
////
//    //파일 삭제하기
//    public void deleteFile(ServletContext context, String fileName) throws FileHandlerException{
//        File file = new File(context.getRealPath(savePath+fileName));
//        boolean result =file.delete();
//        if(!result) {
//            throw new FileHandlerException(fileName+"삭제하지 못했습니다.");
//        }
//    }
}
