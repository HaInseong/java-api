import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; // reflect = 역추적해서 데이터를 만들어내는데 주로 쓰임.
import kr.inflearn.BookDTO;

import java.util.ArrayList;
import java.util.List;

// Gson API 사용법
public class Project01_A {
    public static void main(String[] args) {
        // Object(BookDTO)를 -> JSON(String)으로 바꾸기
        BookDTO dto = new BookDTO("자바", 20000, "에이콘", 500);
        Gson g = new Gson();
        String json = g.toJson(dto); // 직렬화: dto 클래스 안에 있는 멤버변수 이름이 자동으로 key값이 된다.
        System.out.println(json); // {"title":"자바","price":20000,"company":"에이콘","page":500}

        // JSON(String)을 -> Object(BookDTO)으로 바꾸기
        BookDTO dto1 = g.fromJson(json, BookDTO.class); // 역직렬화: 들어온 json 정보 기반으로 자동으로 객체가 생성된다.
        System.out.println(dto1);
        System.out.println(dto1.getTitle() + " " + dto1.getCompany());


        System.out.println("\n" + "저장된 객체배열 JSON 문자열 형태로 바꾸기");
        // ObjectArray(List<BookDTO>)를 -> JSON(String) : [{   }, {   }, ...]으로 바꾸기
        List<BookDTO> list = new ArrayList<BookDTO>();
        list.add(new BookDTO("자바", 20000, "에이콘", 500));
        list.add(new BookDTO("스프링", 30000, "이지스", 700));
        list.add(new BookDTO("자바스크립트", 17000, "길벗", 400));
        System.out.println(list); // JSON 문자열 형태로 변경 전
        String listJson = g.toJson(list);
        System.out.println(listJson);


        System.out.println("\n" + "API로 들어온 객체들에 대한 JSON 문자열 데이터 -> 객체로 저장하기");
        // ★ JSON(String) : [{   }, {   }, ...]을 -> ObjectArray(List<BookDTO>)로 바꾸기
        List<BookDTO> list2 = g.fromJson(listJson, new TypeToken<List<BookDTO>>(){}.getType()); // 여기서 {} 구현부 만들어주는 이유는?
        // ★ TypeToken이 추상클래스라서 익명클래스의 객체를 생성하여 메소드 사용하는 것임.
        // TypeToken 구문은 리스트 안의 타입 정보를 알기 위해서 사용하는 것.
        for(BookDTO lst : list2) {
            System.out.println(lst); // toString 오버라이딩
        }

    }
}
