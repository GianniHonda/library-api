package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository repository;

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
}
