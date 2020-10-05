package com.example.allsuri.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 실패시 행동을 재정의할 클래스(추상 클래스가 아닌 인터페이스를 구현해도 된다.)
 * Or Interface - AuthenticationSuccessHandler
 * @author yun-yeoseong
 *
 */


@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
//        log.debug("CustomAuthenticationSuccessHandler.onAuthenticationSuccess ::::");
        /*
         * 쿠키에 인증 토큰을 넣어준다.
         */
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
