package com.yena.shop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter{
	static Logger logger = LoggerFactory.getLogger(SessionCheckInterceptor.class);
	
	//@Autowired
	//private EntityManager entityManager;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

		LoginManager loginManager = LoginManager.getInstance();
		
		try{
			logger.debug("session intercepter");
			HttpSession session = request.getSession(false);
			
			if(session == null){
			// session non exist
			    System.out.println("세션 null");
				response.sendRedirect(request.getContextPath()+"/account/login.do");
				return false;
			}else{
				Object userId = session.getAttribute("loginUser");
				System.out.println("세션 not null");
				//session exist
				if(userId != null){
					System.out.println("사용자 not null");
					//사용자 아이디가 세션에 존재할경우 loginManager에 담아둔다.
					loginManager.setSession(request.getSession(), userId.toString());
			    }else{
			    	System.out.println("사용자 null");
			    	//session non exist
			    	//session은 존재하나 사용자 아이디가 없을 경우
			    	//해당 아이디를 loginManager에서 제거.
			    	//loginManager는 싱글톤이므로 제때제떄 제거해줘야함.
			    	loginManager.removeSession((String) userId);
			    	response.sendRedirect(request.getContextPath()+"/account/login.do");
			    	return false;
			    }
			}
		}catch(Exception e){
			logger.error("Session Interceptor Error [{}]", e.getMessage());
	
		}
		
		
		return true;
	}
}