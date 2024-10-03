package lexicon.repository;
import lexicon.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //@Query("SELECT a FROM Author a WHERE a.firstName = :firstName")
    // List<Author> findByFirstName(@Param("firstName") String firstName);

    //@Query ("SELECT a FROM Author a WHERE a.firstName = :firstName")
    //List<Author> findByLastName(String lastName);

    //@Query ("SELECT a FROM Author ")
    //List<Author> findByFirstNameContainingOrLastNameContaining(String keyword1, String keyword2);

    // List<Author> findAuthorsById(Integer Id);

    //@Modifying
    //@Transactional
    //@Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    //void updateAuthorNameById(Integer id, String firstName, String lastName);

}