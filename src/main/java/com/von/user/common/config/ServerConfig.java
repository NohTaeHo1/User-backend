package com.von.user.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import javax.swing.text.DateFormatter;
import java.util.Date;

//@Configuration
//public class ServerConfig { //외부 자료를 이용하기 위해 필요한 클래스
//
//    @Bean
//    public String datePattern(){
//        return "yyyy-MM-dd'T'HH:mm:ss.XXX"; // MM은 Month, mm은 minute
//    }//  Java에서 SimpleDateFormat 클래스 또는 DateTimeFormatter 클래스를 사용하여 날짜와 시간을 포맷할 때, 이 문자열은 특정 패턴을 나타내는 코드로 해석
//
//    @Bean
//    public DateFormatter defaultDateFormatter(){
//        return new DateFormatter(datePattern());
//    }
//}
