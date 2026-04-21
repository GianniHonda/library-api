package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @see BookRepositoryTest
 */

public interface BookRepository extends JpaRepository<Book, UUID> {

    //Query Method
    // select * from book where id_author = id
    List<Book> findByAuthor(Author author);

    // select * from book where title = title
    List<Book> findByTitle(String title);

    // select * from book where isbn = ?
    List<Book> findByIsbn(String isbn);

    // select * from book where title = ? and price = ?
    List<Book> findByTitleAndPrice(String title, BigDecimal price);

    // select * from book where title = ? or isbn = ?
    List<Book> findByTitleOrIsbnOrderByTitle(String title, String isbn);

    // select * from book where publication_date between ? and ?
    List<Book> findByPublicationDate(LocalDate start, LocalDate end);

    // JPQL -> reference entities and properties
    // select b.* from book as b order by b.title
    @Query(" select b from Book as b order by l.title, b.price ")
    List<Book> listAllOrderByTitleAndPrice();

    /**
     * select a.*
     * from book b
     * join author a on a.id = b.id_author
     */
    @Query("select a from Book b join b.author a")
    List<Author> listAuthorsOfTheBooks();

    // select distinct l.* from book b
    @Query("select distinct b.title from Book b")
    List<String> listDifferentBooksNames();

    @Query("""
        select l.genre
        from book b
        join b.author a
        where a.nationality = 'Brazilian'
        order by b.genre
""")
    List<String> listGenreBrazilianAuthors();
}
