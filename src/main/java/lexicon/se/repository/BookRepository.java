package lexicon.se.repository;

import lexicon.se.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {


    List<Book> findByIsbnIgnoreCase(String isbn);

    List<Book> findByTitleContainingIgnoreCase(String keyword);

    @Query("SELECT b FROM Book b WHERE b.maxLoanDays < :maxLoanDays")
    List<Book> findBooksByMaxLoanDaysLessThan(@Param("maxLoanDays") int maxLoanDays);
}