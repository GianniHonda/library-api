package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    List<Author> findByName(String name);
    List<Author> findByNationality(String nationality);
    List<Author> findByNameAndNationality(String name, String nationality);

}
