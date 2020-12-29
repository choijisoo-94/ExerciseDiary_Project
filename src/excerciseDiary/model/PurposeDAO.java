package excerciseDiary.model;

import javax.persistence.EntityManager;

import excerciseDiary.exception.NotExistException;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.util.PublicCommon;

public class PurposeDAO {
	public static Purpose findPurpose(String uPurpose) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		Purpose p = null;
		
		try {
			System.out.println("dddddddddddddddddddddddddd"+uPurpose);
			p = (Purpose) em.createNativeQuery("select * from purpose where purpose=?", Purpose.class)
					.setParameter(1, uPurpose).getSingleResult();
			
			if(p == null) {
				throw new NotExistException("select purpose 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return p;
	}
}
