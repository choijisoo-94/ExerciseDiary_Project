package excerciseDiary.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import excerciseDiary.model.entity.Video;
import excerciseDiary.util.PublicCommon;

public class VideoDAO {
	
	// 모든 영상 반환
	public static ArrayList<Video> getAllVideoList() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<Video> videoList = null;
		
		try {
			videoList = (ArrayList)em.createNativeQuery("select * from video", Video.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}
		
		return videoList;
	}
	
	
	public static ArrayList<Video> getVideoList(String purpose) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<Video> videoList = null;
		
		try {
			videoList = (ArrayList)em.createNativeQuery("select * from video where purpose=?", Video.class)
					.setParameter(1, purpose).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}
		
		return videoList;

	}
}
