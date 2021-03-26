package com.file.fileupload.fileuploadproject.Controller;

import java.io.IOException;

import com.file.fileupload.fileuploadproject.dao.UploadFileDao;
import com.file.fileupload.fileuploadproject.pojo.FileDataPojo;
import com.mysql.cj.jdbc.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping
public class UploadController {

    @Autowired
    private UploadFileDao ufd;

    @PostMapping("/upload")
    public String uploadOnDb(@RequestParam("file") MultipartFile multipart)
    {
        FileDataPojo fdp = new FileDataPojo();

        fdp.setImgname(multipart.getOriginalFilename());
        fdp.setImgtype(multipart.getContentType());
        try {
            fdp.setImgdata(multipart.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ufd.saveInDb(fdp);

       
    }

    @GetMapping("/getimg{id}")
    public FileDataPojo getImageById(@PathVariable("id") int id)
    {
        System.out.println("in controller");

        return ufd.getImgFromDb(id);
    }

    

    
}
