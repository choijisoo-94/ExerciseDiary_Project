package excerciseDiary.model;

import java.sql.SQLException;
import java.util.ArrayList;

import excerciseDiary.exception.MessageException;
import excerciseDiary.exception.NotExistException;
import excerciseDiary.model.entity.Diary;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.model.entity.Users;
import excerciseDiary.model.entity.Video;

public class EDService {

	/************************USERS************************/

	// id 존재 여부 확인
	public static void notExistUser(String userId) throws NotExistException, SQLException{
		Users user = UserDAO.getUser(userId);
		if(user == null){
			throw new NotExistException("존재하지 않는 id입니다.");
		}
	}
	
	// 로그인
	public static boolean checkUser(String userId, String password) throws NotExistException, SQLException{
		notExistUser(userId);
		boolean result = false;
		
		try {
			Users user = UserDAO.getUser(userId);
			try {
				if(user.getUserId().equals(userId) && user.getUserPassword().equals(password)) {
					result = true;
				}
			} catch (Exception e) {
				throw new NotExistException("비밀번호 입력 오류입니다.");
			}
		} catch (Exception e) {
			throw new NotExistException("로그인 실패");
		}
		return result;
	}

	// 회원가입
	public static boolean addUser(Users user) throws MessageException, SQLException {
		boolean result = false;
		try{
			result = UserDAO.addUser(user);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}

	// 목적 수정
	public static boolean updateUserPurpose(String userId, String purpose) throws NotExistException, SQLException{
		notExistUser(userId);
		boolean result = UserDAO.updateUserPurpose(userId, purpose);

		if(!result) {
			throw new NotExistException("운동 목적 수정 실패");
		}
		return result;
	}
	
	// user 반환
	public static Users getUser(String userId) throws NotExistException, SQLException{
		Users user = UserDAO.getUser(userId);
		if(user == null){
			throw new NotExistException("존재하지 않는 id입니다.");
		}
		return user;
	}

	// 회원 탈퇴
	public static boolean deleteUser(String userId) throws SQLException, NotExistException{
		notExistUser(userId);
		boolean result = UserDAO.deleteUser(userId);
		if(!result){
			throw new NotExistException("회원 탈퇴 실패");
		} 
		return result;
	}
	
	// purpose
	public static Purpose findPurpose(String purpose) throws Exception {
		return PurposeDAO.findPurpose(purpose);
	}

	/************************VIDEO************************/
	
	// 운동 목적별 영상 list 반환
	public static ArrayList<Video> getVideoList(String purpose) throws SQLException, NotExistException{
		ArrayList<Video> videoList = VideoDAO.getVideoList(purpose);
		if(videoList == null) {
			throw new NotExistException("해당 목적의 영상이 아직 존재하지 않습니다.");
		}
		return videoList;
	}
	
	// 모든 영상 list 반환
	public static ArrayList<Video> getAllVideoList() throws SQLException, NotExistException{
		ArrayList<Video> allList = VideoDAO.getAllVideoList();
		if(allList == null) {
			throw new NotExistException("존재하는 영상이 없습니다.");
		}
		return allList;
	}
	
	/************************DIARY************************/

	// 다이어리 존재 여부 확인
	public static void notExistDiary(String diaryNo) throws NotExistException, SQLException{
		Diary diary = DiaryDAO.getDiaryDetail(diaryNo);
		if(diary == null){
			throw new NotExistException("존재하지 않는 diary입니다.");
		}
	}

	// TODO:  재확인 및 수정 필요 (catch -> messageException)
	// 다이어리 작성
	public static boolean addDiary(Diary diary) throws MessageException, SQLException {
		boolean result = false;
		
		try{
			result = DiaryDAO.addDiary(diary);
		}catch(SQLException s){
			throw new MessageException("일기 작성에 실패했습니다. 다시 작성해주세요.");
		}
		return result;
	}

	// 다이어리 삭제
	public static boolean deleteDiary(String diaryNo) throws SQLException, NotExistException{
		notExistDiary(diaryNo);
		boolean result = DiaryDAO.deleteDiary(diaryNo);
		if(!result){
			throw new NotExistException("일기 삭제 실패");
		}
		return result;
	}

	// 다이어리 list 반환
	public static ArrayList<Diary> getDiaryList(String userId) throws SQLException, NotExistException{
		ArrayList<Diary> diaryList = DiaryDAO.getDiaryList(userId);
		if(diaryList == null) {
			throw new NotExistException("아직 존재하는 일기가 없습니다.");
		}
		return diaryList;
	}

	// 다이어리 상세보기
	public static Diary getDiaryDetail(String diaryNo) throws SQLException, NotExistException{
		Diary diary = DiaryDAO.getDiaryDetail(diaryNo);
		if(diary == null){
			throw new NotExistException("해당 일기는 존재하지 않습니다.");
		}
		return diary;
	}
}