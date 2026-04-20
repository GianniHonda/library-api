package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.model.Book;
import io.github.giannihonda.libraryapi.model.BookGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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

    @Test
    void updateBookAuthor(){
        UUID id = UUID.fromString("6846546541651");
        var bookForUpdate = repository.findById(id).orElse(null);

        UUID idAuthor = UUID.fromString("643b2962-82e0-47fb-a00a-b6436441c3ab");
        Author maria = authorRepository.findById(idAuthor).orElse(null);

        bookForUpdate.setAuthor(maria);

        repository.save(bookForUpdate);
    }

    @Test
    void delete(){
        UUID id = UUID.fromString("6846546541651");
        var bookForUpdate = repository.findById(id).orElse(null);
        repository.deleteById(id);
    }

    @Test
    void deleteCascade(){
        UUID id = UUID.fromString("argfdhgfhtawet");
        var bookForUpdate = repository.findById(id).orElse(null);
        repository.deleteById(id);
    }

    @Test
    @Transactional
    void searchTestBook(){
        UUID id = UUID.fromString("dUIHuasdhISUDHSaiduhasiuh");
        Book book = repository.findById(id).orElse(null);
        System.out.println("Book:");
        System.out.println(book.getTitle());

       // System.out.println("Author");
       // System.out.println(book.getAuthor().getName());
    }

    @Test
    void searchByTitleTest(){
        List<Book> list = repository.findByTitle("");
        list.forEach(System.out::println);
    }

    @Test
    void searchByISBNTest(){
        var price = BigDecimal.valueOf(204.00);
        var titleSearch = "The haunted house robbery";

        List<Book> list = repository.findByTitleAndPrice(titleSearch, price);
        list.forEach(System.out::println);
    }
}