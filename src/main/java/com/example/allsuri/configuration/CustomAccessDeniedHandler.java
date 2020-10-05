package com.example.allsuri.configuration;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * AccessDenied시 행동을 재정의하는 핸들러 클래스이다.(구현체가 아니라 인터페이스를 직접 구현해도된다.) Or Interface -
 * AccessDeniedHandler
 *
 * @author yun-yeoseong
 *
 */
@Slf4j
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {


	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		logger.debug("CustomAccessDeniedHandler.handle");
		this.makeExceptionResponse(request, response, accessDeniedException);
	}

	public void makeExceptionResponse(HttpServletRequest request, HttpServletResponse response, Exception exception)
			throws IOException {
		logger.debug("CustomAccessDeniedHandler.makeExceptionResponse :::: {}"+ exception.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
	}

}
