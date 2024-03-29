package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청 방식 POST -> 인코딩 first
		request.setCharacterEncoding("UTF-8");
		
		// 2) 전달받은 데이터 뽑아오기
	
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] interestList = request.getParameterValues("interest"); // 취미 | null
		
		// 가공처리 1) 문자열 배열 형태를 문자열 형태로 변환
		// String[] -> String
		// ["운동","요리] => "운동, 요리" ==> String.join("구분자", 배열명);
		String interest = "";
		if(interestList != null) {
			interest = String.join(",",interestList);
		}
		
		// 가공처리 2) 전달받은 데이터를 Member 객체로 생성
		// 			+ 생성자 => 1) 기본 생성자로 객체 생성 후 setter 메소드를 사용하여 하나하나 저장
		//					  2) 매개변수 생성자를 추가하여 해당 생성자로 객체를 생성하여 데이터 저장
		Member m = new Member(userId, userPwd, userName, phone,
								email, address, interest);

		// 서비스에게 해당 회원정보를 전달하여 DB에 추가하도록 요청(DML-insert : int)
		int result = new MemberService().insertMember(m);
		
		// 회원가입 성공 : result > 0
		if (result > 0) {
			// 회원가입 성공 메세지를 담아 전달
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입을 성공적으로 완료했습니다.");
			// 메인페이지로 응답: /jsp url 재요청 => index 페이지
			response.sendRedirect(request.getContextPath());
		} else {
			// 회원 가입 실패 => 에러 페이지 표시
			request.setAttribute("errorMsg", "회원가입을 실패했습니다.");
			// 에러페이지로 응답
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
