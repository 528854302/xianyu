package com.xianyu;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
@Service
public class UploadServiceImpl {
    public String upload(MultipartFile file, HttpServletRequest request){
        //String path = request.getSession().getServletContext().getRealPath("img");
        //String path= System.getProperty("user.dir")+"/xianyu_web_8080/src/main/resources/static/img";
        String path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath()).toString()+"/static/img/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String originalFileName = file.getOriginalFilename();
        String filePath = path+"/"+ UUID.randomUUID().toString().substring(0,5)
                +originalFileName.substring(originalFileName.lastIndexOf("."),originalFileName.length());
        File desFile = new File(filePath);
        if (!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost/portal/img/"+desFile.getName();
    }
}
