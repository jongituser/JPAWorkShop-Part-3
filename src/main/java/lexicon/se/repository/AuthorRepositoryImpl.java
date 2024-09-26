package lexicon.se.repository;

import lexicon.se.entity.Author;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findByFirstName(String firstName) {
        String jpql = "SELECT a FROM Author a WHERE a.firstName = :firstName";
        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Override
    public List<Author> findByLastName(String lastName) {
        String jpql = "SELECT a FROM Author a WHERE a.lastName = :lastName";
        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Author> findByFirstNameContainingOrLastNameContaining(String keyword1, String keyword2) {
        String jpql = "SELECT a FROM Author a WHERE a.firstName LIKE CONCAT('%', :keyword1, '%') OR a.lastName LIKE CONCAT('%', :keyword2, '%')";
        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
        query.setParameter("keyword1", keyword1);
        query.setParameter("keyword2", keyword2);
        return query.getResultList();
    }

    @Override
    public List<Author> findAuthorsByBookId(Integer bookId) {
        String jpql = "SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id = :bookId";
        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateAuthorNameById(Integer authorId, String firstName, String lastName) {
        String jpql = "UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.authorId = :authorId";
        entityManager.createQuery(jpql)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("authorId", authorId)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Integer authorId) {
        Author author = entityManager.find(Author.class, authorId);
        if (author != null) {
            entityManager.remove(author);
        }
    }
}
