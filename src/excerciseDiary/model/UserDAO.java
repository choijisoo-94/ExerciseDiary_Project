package excerciseDiary.model;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import excerciseDiary.model.entity.Users;
import excerciseDiary.util.PublicCommon;

public class UserDAO {

	// 회원가입
	public static boolean addUser(Users user) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Users newUser = Users.builder().userId(user.getUserId()).userPassword(user.getUserPassword()).
					userName(user.getUserName()).userGender(user.getUserGender()).userAge(user.getUserAge()).
					userHeight(user.getUserHeight()).userWeight(user.getUserWeight()).purpose(user.getPurpose()).build();
			System.out.println("=========================" + user.getPurpose());
			em.persist(newUser);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}
		return true;
	}
	
	/*// 로그인
	public static boolean checkUser(String userId, String password) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Users user = null;
		
		try {
			user = (Users) em.createNativeQuery("select * from users where user_id=?", Users.class)
					.setParameter(1, userId).getSingleResult();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}*/
	
	// 회원의 운동목적 수정
	public static boolean updateUserPurpose(String userId, String newPurpose) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			int result = em.createNativeQuery("update users set purpose=? where user_id=?")
					.setParameter(1, newPurpose).setParameter(2, userId).executeUpdate();
			tx.commit();
			if(result==1) {
				return true;
			}
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}
		return false;
	}
	
	// 회원 탈퇴
	public static boolean deleteUser(String userId) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		try {
			int result = em.createNativeQuery("delete from users where user_id=?")
					.setParameter(1, userId).executeUpdate();
			tx.commit();
			if(result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}
		return false;
	}
	
	// 회원 검색
	public static Users getUser(String userId) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Users user = null;
		
		try {
			user = (Users) em.createNativeQuery("select * from users where user_id=?", Users.class)
					.setParameter(1, userId).getSingleResult();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		return user;
	}
}
