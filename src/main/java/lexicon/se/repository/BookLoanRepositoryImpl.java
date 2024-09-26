package lexicon.se.repository;

import lexicon.se.entity.BookLoan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public class BookLoanRepositoryImpl implements BookLoanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookLoan> findByBorrower_Id(Integer borrowerId) {
        String jpql = "SELECT bl FROM BookLoan bl WHERE bl.borrower.id = :borrowerId";
        TypedQuery<BookLoan> query = entityManager.createQuery(jpql, BookLoan.class);
        query.setParameter("borrowerId", borrowerId);
        return query.getResultList();
    }

    @Override
    public List<BookLoan> findByBook_Id(Integer bookId) {
        String jpql = "SELECT bl FROM BookLoan bl WHERE bl.book.id = :bookId";
        TypedQuery<BookLoan> query = entityManager.createQuery(jpql, BookLoan.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    @Override
    public List<BookLoan> findByReturnedFalse() {
        String jpql = "SELECT bl FROM BookLoan bl WHERE bl.returned = false";
        TypedQuery<BookLoan> query = entityManager.createQuery(jpql, BookLoan.class);
        return query.getResultList();
    }

    @Override
    public List<BookLoan> findOverdueBookLoans(LocalDate currentDate) {
        String jpql = "SELECT bl FROM BookLoan bl WHERE bl.dueDate < :currentDate AND bl.returned = false";
        TypedQuery<BookLoan> query = entityManager.createQuery(jpql, BookLoan.class);
        query.setParameter("currentDate", currentDate);
        return query.getResultList();
    }

    @Override
    public List<BookLoan> findBookLoansBetweenDates(LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT bl FROM BookLoan bl WHERE bl.loanDate BETWEEN :startDate AND :endDate";
        TypedQuery<BookLoan> query = entityManager.createQuery(jpql, BookLoan.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void markBookLoanAsReturned(Integer loanId) {
        String jpql = "UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :loanId";
        entityManager.createQuery(jpql)
                .setParameter("loanId", loanId)
                .executeUpdate();
    }


}
