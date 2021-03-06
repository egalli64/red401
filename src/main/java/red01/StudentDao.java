package red01;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentDao {
	static private final Logger log = LoggerFactory.getLogger(StudentDao.class);

	public List<Student> readAll() {
		EntityManager em = null;

		try {
			em = JpaUtil.createEntityManager();
			String jpql = "SELECT s FROM Student s";
			return em.createQuery(jpql, Student.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Student read(String email, String password) {
		EntityManager em = null;

		try {
			em = JpaUtil.createEntityManager();
			String jpql = "FROM Student where email='" + email + "'  and password='" + password + "'";
			return (Student) em.createQuery(jpql).getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	

	public boolean create(Student student) {
		log.trace("enter");
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(student);
			tx.commit();
			return true;
		} catch (Exception ex) {
			log.warn("Can't persist entity", ex);
			try {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} catch (Exception e) {
				log.warn("Can't rollback transaction", e);
			}

			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	public List<Student> getAll() {
        EntityManager em = null;

        try {
            em = JpaUtil.createEntityManager();
            String jpql = "FROM Student s";			
            TypedQuery<Student> tq = em.createQuery(jpql, Student.class);
            List<Student> result = tq.getResultList();
            return result;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
