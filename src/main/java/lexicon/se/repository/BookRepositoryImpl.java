package lexicon.se.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lexicon.se.entity.Book;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findByIsbnIgnoreCase(String isbn) {
        String jpql = "SELECT b FROM Book b WHERE LOWER(b.isbn) = LOWER(:isbn)";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("isbn", isbn);
        return query.getResultList();
    }

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String keyword) {
        String jpql = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }

    @Override
    public List<Book> findBooksByMaxLoanDaysLessThan(int maxLoanDays) {
        String jpql = "SELECT b FROM Book b WHERE b.maxLoanDays < :maxLoanDays";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("maxLoanDays", maxLoanDays);
        return query.getResultList();
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