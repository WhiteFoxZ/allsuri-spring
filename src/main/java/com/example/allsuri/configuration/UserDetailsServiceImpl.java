package com.example.allsuri.configuration;
import java.util.HashMap;
import java.util.Map;

/*
 * UserDetailsService : AuthenticationProvider 구현체에서 인증에 사용할 사용자 인증정보를 DB에서 가져오는 역할을 하는 클래스이다.
 * UserDetailsService를 구현한 UserDetailsServiceImpl를 사용한다.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.allsuri.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.debug("UserDetailsServiceImpl.loadUserByUsername :::: {}",username);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("username", username);

        Map<String, String> userDto = userService.retrieveUser(params);

        if(ObjectUtils.isEmpty(userDto)) {
            throw new UsernameNotFoundException("Invalid username");
        }

        userDto.setAuthorities(AuthorityUtils.createAuthorityList(userDto));

        return null; //UserDetails;


    }

}
