package org.gitterdunn.quarkus.starting.repository;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.gitterdunn.quarkus.starting.domain.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practicing Quarkus", "Antonio", 2021, genre),
                new Book(3, "Effective Java", "Josh", 2002, genre),
                new Book(4, "Bible", "people", 1, genre));
    }

    public Optional<Book> getBook(final Integer id) {
        return getAllBooks()
                .stream()
                .filter(book -> Objects.equals(id, book.getId()))
                .findFirst();
    }
}
