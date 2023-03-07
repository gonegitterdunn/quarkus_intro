package org.gitterdunn.quarkus.starting.repository;

import org.gitterdunn.quarkus.starting.domain.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Practicing Quarkus", "Antonio", 2021, "IT"),
                new Book(3, "Effective Java", "Josh", 2002, "IT"),
                new Book(4, "Bible", "people", 1, "IT"));
    }

    public Optional<Book> getBook(final Integer id) {
        return getAllBooks()
                .stream()
                .filter(book -> Objects.equals(id, book.getId()))
                .findFirst();
    }
}
