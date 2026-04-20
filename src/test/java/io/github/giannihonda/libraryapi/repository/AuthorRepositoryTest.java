package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.model.Book;
import io.github.giannihonda.libraryapi.model.BookGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository repository;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void saveTest(){
        Author author = new Author();
        author.setName("Maria");
        author.setNationality("Brasilian");
        author.setDateBirthDate(LocalDate.of(1951, 1, 31));

        var authorSave = repository.save(author);
        System.out.println("Author Save: " + authorSave);
    }

    @Test
    public void updateTest() {
        var id = UUID.fromString("643b2962-82e0-47fb-a00a-b6436441c3ab");

        Optional<Author> possibleAuthor = repository.findById(id);

        if (possibleAuthor.isPresent()) {

            Author authorFound = possibleAuthor.get();
            System.out.println("Author Data");
            System.out.println(authorFound);

            authorFound.setDateBirthDate(LocalDate.of(1960, 1, 30));

            repository.save(authorFound);
        }
    }

    @Test
    public void listTest(){
        List<Author> list = repository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Count authors: " + repository.count());
    }

    @Test
    public void deleteForIdTest(){
        var id = UUID.fromString("643b2962-82e0-47fb-a00a-b6436441c3ab");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest(){
        var id = UUID.fromString("888a79f6-643d-46cd-9289-bdfd737d793d");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void saveAuthorWithBooksTest(){
        Author author = new Author();
        author.setName("Antonio");
        author.setNationality("American");
        author.setDateBirthDate(LocalDate.of(1970, 8, 5));

        Book book = new Book();
        book.setIsbn("2847-84874");
        book.setPrice(BigDecimal.valueOf(204));
        book.setGenre(BookGenre.FANTASY);
        book.setTitle("The haunted house robbery");
        book.setPublicationDate(LocalDate.of(1999, 1, 2));
        book.setAuthor(author);

        Book book2 = new Book();
        book2.setIsbn("99999-84874");
        book2.setPrice(BigDecimal.valueOf(650));
        book2.setGenre(BookGenre.FANTASY);
        book2.setTitle("The haunted house robbery");
        book2.setPublicationDate(LocalDate.of(2000, 1, 2));
        book2.setAuthor(author);

        author.setBooks(new ArrayList<>());
        author.getBooks().add(book);
        author.getBooks().add(book2);

        repository.save(author);

       // bookRepository.saveAll(author.getBooks());
    }
}
