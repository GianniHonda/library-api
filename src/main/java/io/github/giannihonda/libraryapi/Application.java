package io.github.giannihonda.libraryapi;

import io.github.giannihonda.libraryapi.model.Author;
import io.github.giannihonda.libraryapi.repository.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
		AuthorRepository repository = context.getBean(AuthorRepository.class);

		//exampleSaveRegistry(repository);
	}

	public static void exampleSaveRegistry(AuthorRepository authorRepository){
		Author author = new Author();
		author.setName("José");
		author.setNationality("Brasilian");
		author.setDateBirthDate(LocalDate.of(1950, 1, 31));

		var authorSave = authorRepository.save(author);
		System.out.println("Author Save: " + authorSave);
	}
}
