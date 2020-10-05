package com.example.allsuri.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


import com.example.allsuri.domain.UserDto;

import lombok.extern.slf4j.Slf4j;

/*
 * AuthenticationProvider : 실제 인증이 일어나는 클래스이다.
 * AuthenticationManager(ProviderManager)는 실제로 많은 AuthenticationProvider 구현체들을 가질 수 있다고 이야기 했듯
 * 저 AuthenticationProvider를 가지고 ProviderManager는 인증 로직을 태우게된다.
 * AuthenticationProvider를 구현한 CustomAuthenticationProvider를 사용한다. 해당 클래스 내부적으로는 UserDetailsService에게
 * 입력받은 사용자 아이디를 넘겨 DB에서 사용자 인증 정보를 받고 암호화된 패스워드를 비교하기 위하여 PasswordEncoder에게 사용자가 입력한
 * 평문 패스워드를 전달해 암호화된 형태로 받아서 암호화<->암호화 형태로 비밀번호를 비교한다(평문<->평문 아님).
 * 만약 인증이 완료되면 Authentication객체를 구현한 UsernamePasswordAuthenticationToken객체를 반환한다.
 */

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    private UserDetailsService userDetailsService;
    private PasswordEncoder encoder;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService,PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        logger.debug("CustomUserAuthenticationProvider.authenticate :::: {}" + authentication.toString());

        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;

        String userId = token.getName();

        UserDto user = null;

        if(!StringUtils.isEmpty(userId)) {
            user = (UserDto) userDetailsService.loadUserByUsername(userId);
        }

        if(ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("Invalid username");
        }

        String password = user.getPassword();

        if(!StringUtils.equals(password, encoder.encode(String.valueOf(token.getCredentials())))) {
            throw new BadCredentialsException("Invalid password");
        }

        return null;// new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
//        logger.debug("CustomUserAuthenticationProvider.supports ::::");
        return UsernamePasswordAuthenticationToken
                .class.equals(authentication);
    }



}

