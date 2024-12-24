package com.coen.demo.repositories;

import com.coen.demo.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<BlogPost, Integer> {
    List<BlogPost> findAllByTitleContaining(String name);
}
