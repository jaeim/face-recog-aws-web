package controller.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.Setting;
import model.service.Manager;
import model.service.NotFoundException;
import model.service.PasswordMismatchException;

public class SiteLoginController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession existingSession = null;
		existingSession = request.getSession();
		// 설정 정보 수정후...이미 한번 로그인 했으므로 세션에 _id 속성 보유중임
		if (existingSession.getAttribute(UserSessionUtils.USER_SESSION_KEY) != null) {
			UserSessionUtils utils = new UserSessionUtils();
			if(utils.hasLogined(existingSession)) {
				Manager manager = Manager.getInstance();
				// 로그인한 멤버의 정보 가져오기
				Member member = manager.getOneMemberById(Integer.parseInt(existingSession.getAttribute(UserSessionUtils.USER_SESSION_KEY).toString()));
				request.setAttribute("member", member);
				// 프로그램 설정 정보 가져오기
				Setting stg = null;
				stg = manager.getSetting();
				request.setAttribute("stg", stg);
				// 모든 근무자 수 & 정보 가져오기
				int memberCnt = manager.countAllMember();
				request.setAttribute("memberCnt", memberCnt);
				
				ArrayList<Member> members = manager.getAllMember();
				request.setAttribute("members", members);
			}
			// 로그인 시 메인페이지로 이동
			return "/user/mainPage.jsp";			
			
		}
		// 첫 로그인 시
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		
		try {
			Manager manager = Manager.getInstance();
			Member member = manager.loginCheck(login_id, password);
			// 로그인한 멤버의 정보 가져오기
			request.setAttribute("member", member);

			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, member.get_id());
			
			UserSessionUtils utils = new UserSessionUtils();
			if(utils.hasLogined(session)) {
				// 프로그램 설정 정보 가져오기
				Setting stg = null;
				stg = manager.getSetting();
				request.setAttribute("stg", stg);
				// 모든 근무자 수 & 정보 가져오기
				int memberCnt = manager.countAllMember();
				request.setAttribute("memberCnt", memberCnt);
				
				ArrayList<Member> members = manager.getAllMember();
				request.setAttribute("members", members);
			}
			// 로그인 시 메인페이지로 이동
			return "/user/mainPage.jsp";			
		} catch (Exception e) {
			if(e instanceof NotFoundException) {request.setAttribute("notFound", true);}
			if(e instanceof PasswordMismatchException) {request.setAttribute("passwordMismatch", true);}
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/login.jsp";			
		}
	}
}
