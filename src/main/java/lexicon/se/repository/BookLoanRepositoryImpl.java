package lexicon.se.repository;

import lexicon.se.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookLoanRepositoryImpl implements BookLoanRepository{
    @Override
    public List<BookLoan> findByBorrower_Id(Integer borrowerId) {
        return List.of();
    }

    @Override
    public List<BookLoan> findByBook_Id(Integer bookId) {
        return List.of();
    }

    @Override
    public List<BookLoan> findByReturnedFalse() {
        return List.of();
    }

    @Override
    public List<BookLoan> findOverdueBookLoans(LocalDate currentDate) {
        return List.of();
    }

    @Override
    public List<BookLoan> findBookLoansBetweenDates(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    @Override
    public void markBookLoanAsReturned(Integer loanId) {

    }

    @Override
    public <S extends BookLoan> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BookLoan> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BookLoan> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<BookLoan> findAll() {
        return null;
    }

    @Override
    public Iterable<BookLoan> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(BookLoan entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends BookLoan> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
