package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
