package com.coen.demo.services;

import com.coen.demo.dto.UploadBlogDto;
import com.coen.demo.exceptions.NotFoundExeption;
import com.coen.demo.mapper.UploadBlogMapper;
import com.coen.demo.models.Author;
import com.coen.demo.models.BlogPost;
import com.coen.demo.repositories.AuthRepo;
import com.coen.demo.repositories.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private final BlogRepo blogRepo;
    private final AuthRepo authRepo;
    public BlogService(BlogRepo blogRepo, AuthRepo authRepo){
        this.blogRepo = blogRepo;
        this.authRepo = authRepo;
    }

    public UploadBlogMapper postBlog(UploadBlogDto blogDto){
        Author findAuthor =  authRepo.findById(blogDto.authorId())
                .orElseThrow(() -> new NotFoundExeption("Author does not exist"));
        BlogPost newBlog = new BlogPost();
        newBlog.setTitle(blogDto.title());
        newBlog.setBody(blogDto.body());
        newBlog.setAuthorId(findAuthor);
        blogRepo.save(newBlog);
        return new UploadBlogMapper(blogDto.title(), blogDto.body(), blogDto.authorId());
    }

    public UploadBlogMapper getBlog(int id){
        BlogPost findBlog = blogRepo.findById(id)
                .orElseThrow(() -> new NotFoundExeption("blog post does not exist"));
        return new UploadBlogMapper(findBlog.getTitle(), findBlog.getBody(), findBlog.getId());
    }

    public List<UploadBlogMapper> searchBlogByTitle(String name){
        var findBlog = blogRepo.findAllByTitleContaining(name)
                .stream()
                .map(blog ->
                        new UploadBlogMapper(blog.getTitle(), blog.getBody(), blog.getAuthorId().getId()))
                .collect(Collectors.toList());

        if(findBlog.isEmpty()) throw new NotFoundExeption("no blog with that name found");
        return findBlog;
    }
}
