package io.github.giannihonda.libraryapi.controller.dto;

import io.github.giannihonda.libraryapi.model.Author;

import java.time.LocalDate;

public record AuthorDTO(String name, LocalDate birthDate, String nationality) {

  public Author mappingForAuthor(){
      Author author = new Author();
      author.setName(this.name);
      author.setDateBirthDate(this.birthDate);
      author.setNationality(this.nationality);
      return author;
  }
}
