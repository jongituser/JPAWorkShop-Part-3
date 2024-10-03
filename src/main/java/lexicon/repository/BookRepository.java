package lexicon.repository;
import lexicon.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("SELECT b FROM Book b WHERE b.isbn = b.isbn")
    List<Book> findByIsbnIgnoreCase(String isbn);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.maxLoanDays < :maxLoanDays")
    List<Book> findBooksByMaxLoanDaysLessThan(@Param("maxLoanDays") int maxLoanDays);


}