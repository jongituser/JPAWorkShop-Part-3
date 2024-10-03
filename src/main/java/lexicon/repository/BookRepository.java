package lexicon.repository;
import lexicon.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /*
    @Query("SELECT a FROM Book a WHERE a.isbn = a.isbn")
    List<Book> findByIsbnIgnoreCase(String isbn);

    // List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findBooksByMaxLoanDaysLessThan(int maxLoanDays);


     */

}