package io.github.giannihonda.libraryapi.service;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.model.Book;
import io.github.giannihonda.libraryapi.model.BookGenre;
import io.github.giannihonda.libraryapi.repository.AuthorRepository;
import io.github.giannihonda.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransactionService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void execute(){
        //save author
        Author author = new Author();
        author.setName("Francisca");
        author.setNationality("Brasilian");
        author.setDateBirthDate(LocalDate.of(1951, 1, 31));

        authorRepository.save(author);

        //save book
        Book book = new Book();
        book.setIsbn("9887-84874");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGenre(BookGenre.SCIENCE);
        book.setTitle("Francisca's Book");
        book.setPublicationDate(LocalDate.of(1980, 1, 2));

        book.setAuthor(author);

        bookRepository.save(book);

        if(author.getName().equals("José")){
            throw new RuntimeException("Rollback!");
        }
    }
}
