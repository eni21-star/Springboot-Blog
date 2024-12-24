package com.coen.demo.mapper;

import org.springframework.stereotype.Service;


public class UploadBlogMapper {
    public String title;
    public String body;
    public int authorId;

    public UploadBlogMapper(String title, String body, int authorId) {
        this.title = title;
        this.body = body;
        this.authorId = authorId;
    }
}
