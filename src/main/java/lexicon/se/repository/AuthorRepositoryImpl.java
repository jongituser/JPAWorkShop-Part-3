package lexicon.se.repository;

import lexicon.se.entity.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthorRepositoryImpl implements AuthorRepository{
    @Override
    public List<Author> findByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<Author> findByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<Author> findByFirstNameContainingOrLastNameContaining(String keyword1, String keyword2) {
        return List.of();
    }

    @Override
    public List<Author> findAuthorsByBookId(Integer bookId) {
        return List.of();
    }

    @Override
    public void updateAuthorNameById(Integer authorId, String firstName, String lastName) {

    }

    @Override
    public void deleteById(Integer authorId) {

    }

    @Override
    public void delete(Author entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Author> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Author> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Author> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Author> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Author getOne(Integer integer) {
        return null;
    }

    @Override
    public Author getById(Integer integer) {
        return null;
    }

    @Override
    public Author getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Author> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Author> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Author> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Author> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Author> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Author> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Author, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Author> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Author> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Author> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public List<Author> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Author> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return null;
    }
}
