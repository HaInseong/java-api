import org.json.*;

// JSON API 사용법 = 객체 배열 데이터 직렬화, 역직렬화 과정에서 Gson과의 차이 살펴볼 것.
// 객체 타입을 만들지 않더라도 사용 가능한 별도의 데이터 타입(JSONObject)을 제공해준다는 차이가 있다.
// 객체를 여러개 저장하려면 JSONArray에 JSONObject를 넣어서 배열화 한다.
// JSONArray도 결국에는 JSONObject 안에 들어간다.
// JSON을 직접 만드는 것 보다도 다른 서버에서 받아오는 경우가 대부분이다. ex) OpenAPI, 공공 API
// 그러므로 JSON 분석툴을 활용하자. https://jsoneditoronline.org

public class Project01_B {
    public static void main(String[] args) {
        // JSON-Java(org.json)
        // Object() -> JSON(String)
        JSONArray students = new JSONArray(); // 객체 배열 생성
        JSONObject student = new JSONObject(); // 객체 생성
        student.put("name", "고길동"); // 객체 필드 초기화
        student.put("phone", "010-0020-0402");
        student.put("address", "강남");
        students.put(student); // 객체 배열에 객체 할당 = 0번 인덱스

        student = new JSONObject(); // 메모리 낭비하지 않고 student 그대로 활용
        student.put("name", "둘리");
        student.put("phone", "010-1122-1232");
        student.put("address", "판교");
        students.put(student); // 객체 배열에 객체 할당 = 1번 인덱스

        student = new JSONObject();
        student.put("name", "도우너");
        student.put("phone", "010-3332-4456");
        student.put("address", "일산");
        students.put(student); // 객체 배열에 객체 할당 = 2번 인덱스

        student = new JSONObject();
        student.put("name", "또치");
        student.put("phone", "010-8884-1961");
        student.put("address", "왕십리");
        students.put(student); // 객체 배열에 객체 할당 = 3번 인덱스
        System.out.println(students.toString(1));

        JSONObject object = new JSONObject(); // 객체배열을 담을 객체 생성 => 한번 더 담는 이유가 뭐야?
        object.put("students", students); // object 참조변수 안에 students: students라는 키와 밸류 할당
        System.out.println(students);
        System.out.println(object);
        System.out.println(object.toString(2));
    }
}
