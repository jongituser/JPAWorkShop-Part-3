package lexicon.se.repository;

import lexicon.se.entity.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameContainingOrLastNameContaining(String keyword1, String keyword2);

    List<Author> findAuthorsByBookId(Integer bookId);

    void updateAuthorNameById(Integer authorId, String firstName, String lastName);

    void deleteById(Integer authorId);
}