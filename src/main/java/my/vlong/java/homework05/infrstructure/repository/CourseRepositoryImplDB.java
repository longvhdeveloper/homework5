package my.vlong.java.homework05.infrstructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import my.vlong.java.homework05.application.exception.AddException;
import my.vlong.java.homework05.application.exception.DeleteException;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.application.exception.UpdateException;
import my.vlong.java.homework05.domain.repository.ICourseRepository;
import my.vlong.java.homework05.infrstructure.entity.Course;
import my.vlong.java.homework05.infrstructure.entity.Student;

@Transactional
public class CourseRepositoryImplDB implements ICourseRepository {

    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public CourseRepositoryImplDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory("SchoolPU");
    }

    @Override
    public List<Student> getStudentsOfCourse(Optional<Course> course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> findByNameContaining(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Course> add(Course t) throws AddException {
        if (t == null) {
            throw new AddException("Can not add course");
        }
        
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new AddException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<Course> update(Course t) throws UpdateException {
        if (t == null) {
            throw new UpdateException("Can not update course");
        }

        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();            
            throw new UpdateException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(Integer k) throws DeleteException {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            Course course = entityManager.find(Course.class, k);
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DeleteException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return true;
    }

    @Override
    public Optional<Course> findByOne(Integer k) throws ResultNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        Course course = null;
        try {
            course = entityManager.find(Course.class, k);
        } catch (Exception e) {
            throw new ResultNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Optional.ofNullable(course);
    }

    @Override
    public List<Course> findAll() throws ResultNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        List<Course> courses = new ArrayList<>();

        try {
            CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
            criteriaQuery.select(criteriaQuery.from(Course.class));
            Query query = entityManager.createQuery(criteriaQuery);
            courses = query.getResultList();
        } catch (Exception e) {
            throw new ResultNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return courses;
    }

}
