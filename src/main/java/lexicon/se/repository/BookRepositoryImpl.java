package lexicon.se.repository;

import lexicon.se.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository{
    @Override
    public List<Book> findByIsbnIgnoreCase(String isbn) {
        return List.of();
    }

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String keyword) {
        return List.of();
    }

    @Override
    public List<Book> findBooksByMaxLoanDaysLessThan(int maxLoanDays) {
        return List.of();
    }

    @Override
    public <S extends Book> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Book> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Iterable<Book> findAllById(Iterable<Integer> integers) {
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
    public void delete(Book entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
