package lexicon.se.repository;

import lexicon.se.entity.Details;

import java.util.Optional;

public class DetailsDaoImpl implements DetailsDao {
    @Override
    public <S extends Details> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Details> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Details> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Details> findAll() {
        return null;
    }

    @Override
    public Iterable<Details> findAllById(Iterable<Integer> integers) {
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
    public void delete(Details entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Details> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
