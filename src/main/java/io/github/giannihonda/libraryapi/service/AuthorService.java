package io.github.giannihonda.libraryapi.service;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }

    public Author save(Author author){
        return repository.save(author);
    }
}
