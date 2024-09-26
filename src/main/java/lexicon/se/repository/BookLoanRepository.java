package lexicon.se.repository;

import lexicon.se.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

public interface BookLoanRepository {

    List<BookLoan> findByBorrower_Id(Integer borrowerId);

    List<BookLoan> findByBook_Id(Integer bookId);

    List<BookLoan> findByReturnedFalse();

    List<BookLoan> findOverdueBookLoans(LocalDate currentDate);

    List<BookLoan> findBookLoansBetweenDates(LocalDate startDate, LocalDate endDate);

    void markBookLoanAsReturned(Integer loanId);
}