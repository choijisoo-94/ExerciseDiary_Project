package excerciseDiary.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excerciseDiary.model.EDService;
import excerciseDiary.model.UserDAO;
import excerciseDiary.model.entity.Diary;
import excerciseDiary.model.entity.Purpose;
import excerciseDiary.model.entity.Users;
import excerciseDiary.model.entity.Video;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/excerciseDiary")
public class EDController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");
		if(command == null) {
			response.sendRedirect("index.html");
			return;
		}

		try {
			// command 값에 따른 메소드 호출
			if(command.equals("signUp")){ // 회원가입
				addUser(request, response);
			} else if(command.equals("logIn")){ // 로그인
				checkUser(request, response);
			} else if(command.equals("getUser")){ // 마이페이지
				getUser(request, response);
			} else if(command.equals("purpose")){ // 목적별 영상
				getVideoList (request, response);
			} else if(command.equals("updateUserReq")) { // 회원 목적 수정
				updateUserReq(request, response);
			} else if(command.equals("updateUser")) { // 회원 목적 수정
				updateUserPurpose(request, response);
			} else if(command.equals("userDelete")) {
				deleteUser(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			log.info("에러 메세지" + e.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	/************************USERS************************/
	// 회원가입 addUser(Users user)
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		// 입력 값
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		Purpose userPurpose = null;

		if(id != null && id.length() !=0 && name != null) {
			try{
				userPurpose = EDService.findPurpose(request.getParameter("purpose"));
				Users user = new Users(id, pw, name, gender, age, height, weight, userPurpose);
				boolean result = EDService.addUser(user);

				if(result){
					request.getSession().setAttribute("user", user);

					request.setAttribute("successMsg", "가입 완료");
					log.info("user 가입 완료");
					url = "userLogin.html";

				}else{
					request.setAttribute("errorMsg", "다시 시도하세요");
					log.info("회원 가입 오류");
				}
			} catch(Exception s){
				log.info("회원가입 중 에러 발생");
				request.setAttribute("errorMsg", s.getMessage());
			} 
		} else {
			request.setAttribute("errorMsg", "회원님의 정보가 제대로 입력되지 않았습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 로그인 checkUser(String userId, String password)
	public void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			boolean result = EDService.checkUser(id, pw);

			if(result) {
				Users usersAll = UserDAO.getUser(id);
				request.getSession().setAttribute("usersAll", usersAll);
				request.getSession().setAttribute("id", id);
				System.out.println("로그인 성공");
				try {
					ArrayList<Video> vList = EDService.getAllVideoList();
					request.getSession().setAttribute("vList", vList);

					request.getSession().setAttribute("successMsg","모든 영상 list 반환 성공");
					url = "vList.jsp";
				}catch(Exception s){
					log.info("모든영상 list 반환 에러 발생");
					request.getSession().setAttribute("errorMsg", s.getMessage());
					s.printStackTrace();
				}
			}
		} catch (Exception e) {
			log.info("로그인 중 에러 발생");
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// myPage 해당 유저 정보 불러오기
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");

			request.getSession().setAttribute("id", EDService.getUser(id));
			request.getSession().setAttribute("successMsg", "list 출력 성공");

			url = "myPage.jsp";
		} catch(Exception s){
			
			log.info("회원정보 출력 중 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// user update 요구
	public void updateUserReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		try {
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("usersAll");

			request.getSession().setAttribute("id", EDService.getUser(user.getUserId()));

			url = "updateUser.jsp";
		}catch(Exception s){
			log.info("User update 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원정보(운동 목적)수정 updateUserPurpose(String userId, String purpose)
	public void updateUserPurpose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("userId");
		String purpose = request.getParameter("purpose");

		try{
			boolean result = EDService.updateUserPurpose(id,purpose);
			if(result){
				request.getSession().setAttribute("id", EDService.getUser(id));
				request.getSession().setAttribute("successMsg", "수정 완료");
				log.info("운동목적 수정이 완료되었습니다.");

				url = "myPage.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("운동목적 수정  다시 시도해주세요.");
			}
		} catch(Exception s){
			log.info("운동목적 수정 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원 탈퇴 deleteUser(String userId)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = EDService.deleteUser(request.getParameter("userId"));
			
			if(result){
				request.getSession().setAttribute("id", result);
				request.getSession().setAttribute("successMsg", "삭제 완료");
				log.info("회원탈퇴가 완료되었습니다.");
				
				url = "userLogin.html";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("회원 탈퇴 오류");
			}
		} catch(Exception s){
			log.info("회원 탈퇴 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/************************VIDEO************************/
	// 운동 목적별 영상 list 반환 ArrayList<Video> getVideoList(String purpose)
	public void getVideoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			ArrayList<Video> vListPurpose = EDService.getVideoList(request.getParameter("purpose"));
			
			request.getSession().setAttribute("vListPurpose", vListPurpose);
			request.getSession().setAttribute("successMsg","목적별 영상 list 반환 성공");
			
			url = "vListPurpose.jsp";
		} catch(Exception s){
			log.info("목적별 영상 list 반환 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 영상 list 반환 ArrayList<Video> getAllVideoList()
	public void getAllVideoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			ArrayList<Video> vList = EDService.getAllVideoList();
			
			request.getSession().setAttribute("vList", vList);
			request.getSession().setAttribute("successMsg","모든 영상 list 반환 성공");
			
		}catch(Exception s){
			log.info("모든영상 list 반환 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/************************DIARY************************/
	// 다이어리 작성 boolean addDiary(Diary diary)
	public void addDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		// 입력 값
		String diaryNo = request.getParameter("diaryNo");
		String diaryTitle = request.getParameter("diaryTitle");
		String diaryContent = request.getParameter("diaryContent");
		String writeDate = request.getParameter("writeDate");
		String todayWeight = request.getParameter("todayWeight");
		String userId = request.getParameter("userId");
		String purpose = request.getParameter("purpose");
		String programNo = request.getParameter("programNo");

		Diary diary = new Diary(diaryNo, diaryTitle, diaryContent, writeDate, todayWeight, new Users(userId), new Purpose(purpose), new Video(programNo));
		try{
			boolean result = EDService.addDiary(diary);
			if(result){
				request.getSession().setAttribute("diary", diary);
				request.setAttribute("successMsg", "작성 완료");
				log.info("다이어리 작성 완료");
				//  url = "activistDetail.jsp";

			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("다이어리 작성 실패");
			}
		} catch(Exception s){
			log.info("다이어리 작성 중 에러 발생");
			request.setAttribute("errorMsg", s.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	} 


	// 다이어리 삭제 boolean deleteDiary(String diaryNo)
	public void deleteDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			boolean result = EDService.deleteDiary(request.getParameter("diaryNo"));
			if(result){
				request.getSession().setAttribute("diary", result);
				request.getSession().setAttribute("successMsg", "삭제 완료");
				log.info("해당 다이어리 삭제 완료");
				//				url = "index.html";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
				log.info("다이어리 삭제 오류");
			}
		}catch(Exception s){
			log.info("다이어리 삭제 중 에러 발생 : " + s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 다이어리 list 반환 ArrayList<Diary> getDiaryList(String userId)
	public void getDiaryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		//		String userId = request.getParameter("userId");

		try {
			request.getSession().setAttribute("diaryList", EDService.getDiaryList("userId"));
			request.getSession().setAttribute("successMsg", "list 출력 성공");

			//			url = "activistList.jsp";
		} catch(Exception s){
			log.info("다이어리 list 출력 중 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 다이어리 상세보기 Diary getDiaryDetail(String diaryNo)
	public void getDiaryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			request.getSession().setAttribute("diaryDetail", EDService.getDiaryDetail(request.getParameter("diaryNo")));
			request.getSession().setAttribute("successMsg","다이어리 상세보기 성공");
			//			url = "activistDetail.jsp";
		} catch(Exception s){
			log.info("다이어리 상세보기 에러 발생");
			request.getSession().setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
