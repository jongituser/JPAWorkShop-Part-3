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

    @Query("SELECT a FROM Author a WHERE a.firstName = :firstName")
     List<Author> findByFirstName(@Param("firstName") String firstName);

    @Query ("SELECT a FROM Author a WHERE a.firstName = :firstName")
    List<Author> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT a FROM Author a WHERE a.firstName LIKE %:keyword% OR a.lastName LIKE %:keyword%")
    List<Author> findByFirstNameContainingOrLastNameContaining(@Param("keyword") String keyword);

    @Query ("SELECT a FROM Author a WHERE a.id = :id")
    Author findAuthorById (@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    void updateAuthorNameById(Integer id, String firstName, String lastName);

}