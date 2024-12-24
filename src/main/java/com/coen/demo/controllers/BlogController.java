package com.coen.demo.controllers;

import com.coen.demo.dto.UploadBlogDto;
import com.coen.demo.mapper.UploadBlogMapper;
import com.coen.demo.services.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



    @PostMapping("upload/blog")
    public UploadBlogMapper blogUpload(
            @RequestBody UploadBlogDto blogData
            ){
            return blogService.postBlog(blogData);
    }

    @GetMapping("blog/{id}")
    public UploadBlogMapper getBlogById(
            @PathVariable("id") int id
    ){
        return  blogService.getBlog(id);
    }

    @GetMapping("blog/search/{name}")
    public List<UploadBlogMapper> getBlogByTitle(
            @PathVariable("name") String name
    ){
        return  blogService.searchBlogByTitle(name);
    }
}
