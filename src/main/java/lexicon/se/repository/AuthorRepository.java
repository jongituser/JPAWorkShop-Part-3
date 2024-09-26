package lexicon.se.repository;

import lexicon.se.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameContainingOrLastNameContaining(String keyword1, String keyword2);


    @Query("SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id = :bookId")
    List<Author> findAuthorsByBookId(@Param("bookId") Integer bookId);


    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.authorId = :authorId")
    void updateAuthorNameById(@Param("authorId") Integer authorId, @Param("firstName") String firstName, @Param("lastName") String lastName);

    void deleteById(Integer authorId);
}