package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.model.Book;
import io.github.giannihonda.libraryapi.model.BookGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void saveAuthorAndBookTest(){
        Book book = new Book();
        book.setIsbn("9887-84874");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGenre(BookGenre.FICTION);
        book.setTitle("Third Book");
        book.setPublicationDate(LocalDate.of(1980, 1, 2));

        Author author = new Author();
        author.setName("José");
        author.setNationality("Brasilian");
        author.setDateBirthDate(LocalDate.of(1951, 1, 31));

        authorRepository.save(author);

        book.setAuthor(author);

        repository.save(book);
    }

    @Test
    void saveCascadeTest(){
        Book book = new Book();
        book.setIsbn("9887-84874");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGenre(BookGenre.FICTION);
        book.setTitle("Other Book");
        book.setPublicationDate(LocalDate.of(1980, 1, 2));

        Author author = new Author();
        author.setName("João");
        author.setNationality("Brasilian");
        author.setDateBirthDate(LocalDate.of(1951, 1, 31));

        book.setAuthor(author);

        repository.save(book);
    }

}