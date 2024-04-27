package com.von.user.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SubstringDemo {

    Calendar now = Calendar.getInstance();

    @Test
    public void 문자열_분할() throws Exception {

        var str = "a,b,c";
        var strBuilder = new StringBuilder().append(str).append(",d,e,f").toString();
        String[] arr = strBuilder.split(",");

        assertThat(arr.length).isEqualTo(6);
    }

    @Test
    public void 주민번호로_성별_구분() throws Exception {
        var human1 = "970301-1"; // 8글자 중 1,2, 8
        var human2 = "950101-2";
        var human3 = "020101-3";
        var human4 = "020101-4";
        var human5 = "730101-5";
        var human6 = "820101-6";
        var human7 = "120101-7";
        var human8 = "050101-8";

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int yearMonthDay = year*10000+month*100+day;

        String[] arr = {human1, human2, human3, human4, human5, human6, human7, human8};

        for (var i : arr) {
//            var old = getOld(i, yearMonthDay);
//            var gender = getGender(i);

//            System.out.printf("나이 : " + old + "  "+ gender+" // ");
        }
    }

//    private int getOld(String human, int yearMonthDay) {
//        int birthYear = Integer.parseInt(human.substring(0, 2));
//        int year = (now.get(Calendar.YEAR)%100<birthYear)?birthYear+1900:birthYear+2000;
//
//        int birth = Integer.parseInt(human.substring(0, 6));
//        int birthYear1 = (Integer.parseInt(human.substring(0,2))>(yearMonthDay/10000))?birth+1900:birth+2000;
//        return (yearMonthDay - birthYear < 0) ? yearMonthDay + (100 - birth) : yearMonthDay - birth;
//    }
//
//    private String getGender(String human) {
//        var l = Integer.parseInt(human.substring(7,8));
//        return switch (l) {
//            case 1, 3-> "성별 : 남성";
//            case 2, 4-> "성별 : 여성";
//            case 5, 7-> "외국인 남성";
//            case 6, 8-> "외국인 여성";
//            default-> "잘못 입력된 값입니다.";
//        };
//    }

    @Test
    public void birthYear(){
        String ssn = "970301-1";
        int birthYear = Integer.parseInt(ssn.substring(0, 2));

        int year = (now.get(Calendar.YEAR)%100<birthYear&&(ssn.substring(7,8)=="3"||ssn.substring(7,8)=="4"))?birthYear+1900:birthYear+2000;
        assertThat(year).isEqualTo(1997);
    }

    @Test
    public void getOldAge(){
        String ssn = "970301-1";

        int birthYear = Integer.parseInt(ssn.substring(0, 2));
        int year = now.get(Calendar.YEAR)%100;

        int age = switch(Integer.parseInt(ssn.substring(7, 8))){
            case 1, 5, 2, 6 -> year+(100-birthYear)+1;
            case 3, 4, 7, 8 -> (year<birthYear)?year+(100-birthYear)+1:birthYear+1;
            default -> 0;
        };

        int monthDay = now.get(Calendar.MONTH)*100+now.get(Calendar.DAY_OF_MONTH);
        int birthMonthDay = Integer.parseInt(ssn.substring(2, 6));
        age = (monthDay-birthMonthDay<=0)?age+1:age;

        assertThat(age).isEqualTo(28);
    }

    @Test
    public void getAgeUsingLamda(){
        String ssn = "970301-1";
        int age = Stream.of(ssn)
                .map(i->switch(Integer.parseInt(i.substring(7, 8))){
                    case 1, 5, 2, 6 -> (now.get(Calendar.YEAR)%100+(100-Integer.parseInt(i.substring(0, 2)))+1)*10000+Integer.parseInt(i.substring(2,6));
                    case 3, 4, 7, 8 -> (now.get(Calendar.YEAR)%100<Integer.parseInt(i.substring(0, 2)))?(now.get(Calendar.YEAR)%10000+(100-Integer.parseInt(ssn.substring(0, 2)))+1)*100+Integer.parseInt(i.substring(2,6)):(Integer.parseInt(ssn.substring(0, 2))+1)*100+Integer.parseInt(i.substring(2,6));
                    default -> (now.get(Calendar.YEAR)%100+(100-Integer.parseInt(i.substring(0, 2)))+1000001)*10000+Integer.parseInt(i.substring(2,6));
                })
                .map(i->((now.get(Calendar.MONTH)*100+now.get(Calendar.DAY_OF_MONTH))-i%10000<=0)?i+10000:i)
                .map(i->i/10000)
                .findFirst().get();

        assertThat(age).isEqualTo(28);
    }
}
