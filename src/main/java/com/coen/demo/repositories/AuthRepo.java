package com.coen.demo.repositories;

import com.coen.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Author, Integer> {
    Author findOneByEmailContaining(String emaail);
}
