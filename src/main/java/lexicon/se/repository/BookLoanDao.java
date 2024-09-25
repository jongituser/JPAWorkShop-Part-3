package lexicon.se.repository;
import jakarta.transaction.Transactional;
import lexicon.se.entity.BookLoan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookLoanDao extends CrudRepository<BookLoan, Integer>
{

    List<BookLoan> findByBorrower_Id(Integer borrowerId);

    List<BookLoan> findByBook_Id(Integer bookId);


    List<BookLoan> findByReturnedFalse();

    @Query("SELECT bl FROM BookLoan bl WHERE bl.dueDate < CURRENT_DATE AND bl.returned = false")
    List<BookLoan> findOverdueBookLoans();

    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    @Transactional
    @Modifying
    @Query("UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :loanId")
    void markAsReturned(Integer loanId);

}
