package lexicon.repository;

import lexicon.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {


    @Query("SELECT b FROM BookLoan b WHERE b.borrower.id = :borrowerId")
    List<BookLoan> findByBorrower_Id(@Param("borrowerId") Integer borrowerId);


    @Query("SELECT b FROM BookLoan b WHERE b.book.id = :bookId")
    List<BookLoan> findByBook_Id(@Param("bookId") Integer bookId);


    @Query("SELECT b FROM BookLoan b WHERE b.returned = false")
    List<BookLoan> findByReturnedFalse();


    @Query("SELECT b FROM BookLoan b WHERE b.dueDate < :currentDate AND b.returned = false")
    List<BookLoan> findOverdueBookLoans(LocalDate currentDate);

    @Modifying
    @Transactional
    @Query("UPDATE BookLoan b SET b.returned = true WHERE b.id = :id")
    void markBookLoanAsReturned(Integer id);

}

