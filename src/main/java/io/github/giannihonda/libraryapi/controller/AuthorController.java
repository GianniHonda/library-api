package io.github.giannihonda.libraryapi.controller;

import io.github.giannihonda.libraryapi.controller.dto.AuthorDTO;
import io.github.giannihonda.libraryapi.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
// http://localhost:8080/authors
public class AuthorController {

    @PostMapping
    public ResponseEntity save(@RequestBody AuthorDTO author){
        return new ResponseEntity("Author saved with success!" + author, HttpStatus.CREATED);
    }
}
