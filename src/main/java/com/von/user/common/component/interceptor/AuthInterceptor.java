package com.von.user.common.component.interceptor;

import com.von.user.common.component.security.JwtProvider;
import com.von.user.user.model.User;
import com.von.user.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final UserRepository repository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String token = jwtProvider.extractTokenFromHeader(request);
//        log.info("1-인터셉터 토큰 로그 Bearer 포함 : {}", token);
//
//        if (token.equals("undefined")) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//            log.info("빈 토큰");
//            return false;
//        }
//        Long id = jwtProvider.getPayload(token).get("userId", Long.class);
//        log.info("2- 인터셉터 사용자 id : {}", id);
//        Optional<User> user = repository.findById(1L);
//        log.info("3- 인터셉터 사용자 정보 {} ", user);
//
//        if(!user.isPresent()){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }

        //log.info("4- 인터셉터 최종 여부 {} ", true);

        return Stream.of(request)//i->System.out.printIn(i) = System.out::printIn
                .map(jwtProvider::extractTokenFromHeader)//메서드 참조 (i)->a.b(i) = a::b
                .filter(token->!token.equals("undefined"))
                .peek(token->log.info("1-인터셉터 토큰 로그 Bearer 포함 : {}", token))
                .map(token->jwtProvider.getPayload(token).get("userId", Long.class))
                .map(repository::findById)
                .filter(i->i.isPresent())
                .peek(user->log.info("2- 인터셉터 사용자 정보 : {}", user))
                .findFirst()
                .isPresent();
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


}
