package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

@Controller		// Controller의 어노테이션 작성 시 빈 스캐닝을 통해 자동 Bean 등록이 됨
public class MemberController {

	// private MemberService mService = new MemberServiceImpl();
	@Autowired		// DI(의존성 주입)
	private MemberService mService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
//	// 로그인 관련 메소드
//	@RequestMapping(value="login.me")	// RequestMapping타입의 어노테이션 작성 HandlerMapping 등록 
//	public void loginMember() {	
//		
//	}
//	// 회원 가입 관련 메소드
//	@RequestMapping(value="insert.me")
//	public void insertMember() {
//		
//	}
//	
//	// 회원 수정 관련 메소드
//	@RequestMapping(value="update.me")
//	public void updateMember() {
//		
//	}
	/*
	 * * 요청 시 전달되는 데이터에 대한 처리 방법
	 * 
	 * 1) HttpServletRequest 이용 (기존 jsp/servlet 방식)
	 * 		: 해당 메소드의 매개변수로 HttpservletRequest 작성 시
	 * 		 스프링 컨테이너가 해당 메소드 호출 시 자동으로 해당 객체를 생성해서 전달 해 줌
	 */
	// 로그인 관련 메소드
	/*
	@RequestMapping(value="login.me")	 
	public String loginMember(HttpServletRequest request) {
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		
		System.out.println("ID--->"+userId);
		System.out.println("PWD--->"+userPwd);
		
		return "main";
	}
	*/
	/*
	 * 2) @RequestParam 어노테이션 이용
	 * 		=> request.getParameter("키값") : 밸류 // 이 작업을 대체
	 */
	/*
	@RequestMapping("login.me")		// value 생략 가능 (url mapping 값만 작성 시)
	public String loginMember(@RequestParam(value="id", defaultValue="xx") String userId,
							  @RequestParam("pwd") String userPwd) {
		
		System.out.println("ID--->"+userId);
		System.out.println("PWD--->"+userPwd);
		
		return "main";
	}
	*/
	/*
	 * 3) @RequestParam 어노테이션 생략
	 * 		=> 주의!! 매개변수명을 name값(요청 시 데이터의 키값)과 동이랗게 작성해야 자동으로 값이 주입됨
	 */
	/*
	@RequestMapping("login.me")
	public String loginMember(String id, String pwd) {
		
		System.out.println("ID--->"+id);
		System.out.println("PWD--->"+pwd);
		
		return "main";
	}
	*/
	/*
	 * 4) 커맨드 객체 방식
	 * 	  요청 시 전달되는 데이터를 vo클래스로 받고자 하는 경우
	 * 	  매개변수로 해당 vo클래스 타입을 작성한 후
	 * 	  전달되는 데이터 키값을(name 속성) 받고자하는 vo객체의 필드명과 일치해줘야 함
	 * 
	 * 	  스프링 컨테이너가 해당 객체를 기본생성자로 생성 후 setter 메소드를 사용하여
	 *    요청 시 전달되는 값을 해당 필드에 저장
	 *    
	 *    주의!! 반드시 name속성(키값)과 필드명이 동일해야 함!
	 */
	
	
	/*
	 * * 요청 처리 후 응답 페이지 포워딩 or url 재요청, 응답 데이터 담는 방법
	 * 
	 * 1) 스프링 제공 Model 객체
	 *    포워딩할 페이지로 전달하고자 하는 데이터를 맵 형식(key/value) 담을 수 있는 영역
	 *    Model 객체 => requestScope
	 *    * setAttribute (X) => addAttribute 이용
	 */
	/*
	@RequestMapping("login.me")
	public String loginMember(Member m, Model model, HttpSession session) {
		
//		System.out.println(m.getUserId()); 
//		System.out.println(m.getUserPwd());
		
		Member loginUser = mService.loginMember(m);

		if(loginUser == null) { // 로그인 실패 => 에러메세지 담아(request) 에러페이지 응답
			model.addAttribute("errorMsg", "로그인 실패");
			// WEB-INF/views/common/errorPage.jsp
			return "common/errorPage"; // servlet-context.xml에 저장 중
		} else { // 로그인 성공 => 로그인 정보 담아(session) 메인페이지 이동
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
	}
	*/
	/*
	 * 2) Spring에서 제공하는 ModelAndView 객체 이용
	 * 		Model : 데이터를 key/value형태로 담을 수 있는 공간(단독 사용 가능)
	 * 		View : 응답 뷰에 대한 정보를 담을 수 있는 공간(단독 사용 X) => ModelAndView 사용 
	 */
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, HttpSession session, ModelAndView mv) {
		/** 암호화 처리 전 방식
		Member loginUser = mService.loginMember(m);

		if(loginUser == null) { // 로그인 실패 => 에러메세지 담아(request) 에러페이지 응답
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		} else { // 로그인 성공 => 로그인 정보 담아(session) 메인페이지 이동
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		return mv;
		**/
		
		// 암호화 처리 후 방식
		// - Member m 객체 userId : 사용자가 입력한 id
		//				  userPwd: 사용자가 입력한 비밀번호(평문)
		Member loginUser = mService.loginMember(m);
		// - Member loginUser(아이디로 조회한 정보)
		//			userPwd : DB로 저장된 비밀번호(암호문)
		
		if(loginUser != null 
				&& bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) { // 로그인 성공 => 로그인 정보 담아(session) 메인페이지 이동
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
			
		} else { // 로그인 실패 => 에러메세지 담아(request) 에러페이지 응답 
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
			
		}
		return mv;
	}
	
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m, Model model, HttpSession session) {
		
//		System.out.println(m);
		// * 발생 문제
		// 1) 한글 깨짐 => encoding filter 등록(web.xml)
		// 2) 나이(int) 입력하지 않았을 경우 ""(null String) 전달되어
		//	  int형 필드에 담을 수 없음 => 400 에러 (Member의 age 타입 변경: int -> String)
		// 3) 비밀번호 값이 사용자가 입력한 값 그대로(평문)
		//	  => Bcrypt 방식의 암호화-> 암호문으로 변경
		//		[1] Spring security module에서 제공(pom.xml 라이브러리 등록 필요)   
		//		[2] BcryptPassWordEncoder 클래스 Bean으로 등록하기 (xml파일 (webapp/WEB-INF/spring/Spring Bean Configuration file 만들기))
		//		[3] web.xml에 spring-security.xml 파일을 프리로딩(pre-loading)할 수 있도록 설정
//		System.out.println("비밀번호 평문 ---> " + m.getUserPwd());
		
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
//		System.out.println("암호문 ---> " + encPwd);
		
		m.setUserPwd(encPwd);	// Member객체의 userPwd 필드의 값을 암호문으로 변경
		
		int result = mService.insertMember(m);
		
		if(result >0) {	// 회원 가입 성공
			session.setAttribute("alertMsg", "회원가입에 성공했습니다. 반갑습니다");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("mypage.me")
	public String myPage() {
		
		
		return "member/mypage";
	}
	
	
	@RequestMapping("update.me")
	public ModelAndView updateMember(Member m, HttpSession session, ModelAndView mv) {
		
		int result = mService.updateMember(m);
		
		if(result >0) {
			// 수정된 정보를 세션에 반영
			session.setAttribute("alertMsg", "회원정보 갱신에 성공했습니다.");
			session.setAttribute("loginUser", mService.loginMember(m));
			mv.setViewName("redirect:mypage.me");

		} else {
			mv.addObject("errorMsg", "회원정보 수정 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(String userId, String userPwd, HttpSession session, Model model) {
		
		// 입력된 비밀번호와 DB에 저장된 비밀번호가 일치 하는지
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(bcryptPasswordEncoder.matches(userPwd, loginUser.getUserPwd())) { 
			// - 일치하면 DB 작업 진행(update, status'N')
			int result = mService.deleteMember(userId);
			
			if(result >0) { // 회원 탈퇴 성공 => session 영역에 저장한 로그인 정보 제거
				// alert("탈퇴 성공, 감사합니다");
				// 메인 페이지 url 재요청
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "회원탈퇴에 성공했습니다. 감사합니다.");
				return "redirect:/";
				
			} else {	// 회원 탈퇴 실패 => "에러메세지", 포워딩
				model.addAttribute("errorMsg", "탈퇴에 실패했습니다.");
				return "common/errorPage";
			}
			
		} else { 		// - 미일치시 alert("잘못된 비밀번호입니다. 다시 입력해주세요")
			// mypage url 재요청
			session.setAttribute("alertMsg", "잘못된 비밀번호입니다. 다시 입력해주세요");
			return "redirect:mypage.me";
		}	
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck.me", produces="text/html;charset=UTF-8")
	public String checkUserId(String id) {
		int count = mService.checkUserId(id);
		System.out.println(id);
		/*
		if(count > 0) {	// 사용 불가능 -> 해당 아이디 저장되어있음(중복)
			return "NNN";
		} else { 	// 사용 가능
			return "YYY";
		}
		*/
		System.out.println(count);
		return count > 0 ? "NNN" : "YYY";
	}
}
