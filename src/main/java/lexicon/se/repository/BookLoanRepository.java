package lexicon.se.repository;

import lexicon.se.entity.BookLoan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {


    List<BookLoan> findByBorrower_Id(Integer borrowerId);


    List<BookLoan> findByBook_Id(Integer bookId);


    List<BookLoan> findByReturnedFalse();


    @Query("SELECT bl FROM BookLoan bl WHERE bl.dueDate < :currentDate AND bl.returned = false")
    List<BookLoan> findOverdueBookLoans(@Param("currentDate") LocalDate currentDate);


    @Query("SELECT bl FROM BookLoan bl WHERE bl.loanDate BETWEEN :startDate AND :endDate")
    List<BookLoan> findBookLoansBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Modifying
    @Query("UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :loanId")
    void markBookLoanAsReturned(@Param("loanId") Integer loanId);
}