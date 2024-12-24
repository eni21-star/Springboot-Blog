package com.coen.demo.services;


import com.coen.demo.HashPassword;
import com.coen.demo.dto.AuthDto;
import com.coen.demo.exceptions.ConflictException;
import com.coen.demo.mapper.AuthRegMapper;
import com.coen.demo.models.Author;
import com.coen.demo.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthSerives {

    private final HashPassword bcrypt;
    private final AuthRepo authRepo;
    public AuthSerives( AuthRepo authRepo, HashPassword bcrypt){
        this.authRepo = authRepo;
        this.bcrypt = bcrypt;
    }

    public AuthRegMapper reg(AuthDto authorData){
        var find = authRepo.findOneByEmailContaining(authorData.email());
        if(find != null ) throw new ConflictException("Author already exist");

        var password = bcrypt.hashPassword(authorData.password());
        Author newAuthor = new Author();
        newAuthor.setEmail(authorData.email());
        newAuthor.setPassword(password);
        newAuthor.setUsername(authorData.username());
        authRepo.save(newAuthor);

        return new AuthRegMapper(authorData.email(), authorData.username());

    }
}
