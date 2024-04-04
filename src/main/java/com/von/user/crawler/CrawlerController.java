package com.von.user.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

public class CrawlerController {
        public Map<String,?> findBugsMusic(@RequestBody Map<String,?> map) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오");
        Map<String, String> paramMap =new HashMap<>();
        paramMap.put("URL", null);
        return null;
    }

    public Map<String,String> findMelonMusic(@RequestBody Map<String,String> map) throws IOException{
        System.out.println("크롤링할 주소를 입력하시오");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("URL", null);
        return null;
    }
}
