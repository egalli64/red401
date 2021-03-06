package red01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlotDao {
	static private final Logger log = LoggerFactory.getLogger(SlotDao.class);

	public List<Slot> readAll() {
		EntityManager em = null;

		try {
			em = JpaUtil.createEntityManager();
			String jpql = "SELECT sl FROM Slots sl";
			return em.createQuery(jpql, Slot.class).getResultList();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public Slot read(Integer id , Integer sid) {
		EntityManager em = null;
		try {
			em = JpaUtil.createEntityManager();

			String jpql = "FROM Slot where slot_ID='" + sid + "'  and Room_ID='" + id + "'";
			return (Slot) em.createQuery(jpql).getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean update(Slot slot) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(slot);
			tx.commit();
			return true;
		} catch (Exception ex) {
			try {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} catch (Exception e) {
				log.error("Can't rollback transaction", e);
			}
			log.error("Can't merge entity", ex);
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	public List<Slot> getAll() {
        EntityManager em = null;

        try {
            em = JpaUtil.createEntityManager();
            String jpql = "FROM Slot sl";			
            TypedQuery<Slot> tq = em.createQuery(jpql, Slot.class);
            List<Slot> result = tq.getResultList();
            return result;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
