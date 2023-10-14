package com.bhome.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Slf4j
@Component
public class FileManager {
    @Value("${file.dir}")
    String staticFileDir;
    String savePath = "/resources/data/";

    //multipartformdata를 filename 만들어 넣어주는 작업



    //파일의 확장자가져오기
    public String getExt(String filename) {
        int lastIndex = filename.lastIndexOf(".");
        return filename.substring(lastIndex+1, filename.length());
    }

    //파일 저장하기
    public void saveFile ( MultipartFile file) throws IOException {

        String fileName = System.currentTimeMillis()+"."+getExt(file.getOriginalFilename());
        Path path = Paths.get(staticFileDir, fileName);
        file.transferTo(path.toFile());
    }

    //파일들 저장하기
    public void saveFills(List<MultipartFile> files) throws IOException {
        int index = 0;
        for(MultipartFile file : files){
            String fileName = System.currentTimeMillis()+"."+getExt(file.getOriginalFilename()+index);
            Path path = Paths.get(staticFileDir, fileName);
            file.transferTo(path.toFile());
            index++;
        }
    }



    //테스트 메서드
    public String saveFileAndReturnFileName ( MultipartFile file) throws IOException {

        String fileName = System.currentTimeMillis()+"."+getExt(file.getOriginalFilename());
        Path path = Paths.get(staticFileDir, fileName);
        log.info("fileManager saveFileAndReturnFileName = {}, path= {}",path.toFile(), path);
        file.transferTo(path.toFile());
        return fileName;
    }
    //파일 list 저장하기
    public void saveFiles (List<MultipartFile> files) throws IOException {



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
