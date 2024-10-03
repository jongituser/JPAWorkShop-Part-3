import lexicon.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    // Find all loans for a specific borrower by borrower ID
    @Query("SELECT b FROM BookLoan b WHERE b.borrower.id = :borrowerId")
    List<BookLoan> findByBorrower_Id(Integer borrowerId);

    // Find all loans for a specific book by book ID
    @Query("SELECT b FROM BookLoan b WHERE b.book.id = :bookId")
    List<BookLoan> findByBook_Id(Integer bookId);

    // Find all loans that have not been returned
    @Query("SELECT b FROM BookLoan b WHERE b.returned = false")
    List<BookLoan> findByReturnedFalse();

    // Find overdue book loans where the due date has passed and the book hasn't been returned
    @Query("SELECT b FROM BookLoan b WHERE b.dueDate < :currentDate AND b.returned = false")
    List<BookLoan> findOverdueBookLoans(LocalDate currentDate);

    // Mark a book loan as returned based on its ID
    @Modifying
    @Transactional
    @Query("UPDATE BookLoan b SET b.returned = true WHERE b.id = :id")
    void markBookLoanAsReturned(Integer id);

    // Optional: Add more methods for further specific queries if needed
}