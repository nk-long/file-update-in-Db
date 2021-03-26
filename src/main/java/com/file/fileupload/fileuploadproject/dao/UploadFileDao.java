package com.file.fileupload.fileuploadproject.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.file.fileupload.fileuploadproject.pojo.FileDataPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UploadFileDao {

    String insetSql="insert into imagedata values(?,?,?,?)";
    String getimgSql="select * from imagedata where imgid=?"; 

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String saveInDb(FileDataPojo file)
    {
       System.out.println(file.getImgid());
       System.out.println(file.getImgname());
       System.out.println(file.getImgtype());
       System.out.println(file.getImgdata());

       int result = jdbcTemplate.update(insetSql, file.getImgid(), file.getImgname(),file.getImgtype(),file.getImgdata());
       if(result==1)
       {
        return "saved in db";
       }
       else{
           return "failed";
       }
    }

    public FileDataPojo getImgFromDb(int id)
    {
        FileDataPojo img = jdbcTemplate.queryForObject(getimgSql, new ImgPojo(), id);
        return img;
    }
    
}

 class ImgPojo implements RowMapper<FileDataPojo>
{

    @Override
    public FileDataPojo mapRow(ResultSet rs, int arg1) throws SQLException {
        // TODO Auto-generated method stub
        FileDataPojo fdatap= new FileDataPojo();

        fdatap.setImgid(rs.getInt("imgid"));
        fdatap.setImgname(rs.getString("imgname"));
        fdatap.setImgtype(rs.getString("imgtype"));
        fdatap.setImgdata(rs.getBytes("imgdata"));

        return fdatap;
    }
    
} 