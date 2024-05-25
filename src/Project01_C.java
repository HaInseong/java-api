import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        String src = "info.json";
        // 파일에서 데이터를 읽어오려면 InputStream이 필요
        // IO -> Stream
        InputStream is = Project01_C.class.getResourceAsStream(src); // src파일을 읽어온다.
        if(is==null) {
            throw new NullPointerException("Cannot find resource file");
        }
        JSONTokener tokener = new JSONTokener(is); // 문자열을 JSON형태로 토큰 변환해서 메모리에 올린다.
        // tokener에 들어있는 json 데이터를 객체로 만들어서 핸들링 하기 위해서 JSONObject 생성자의 매개변수로 전달한다.
        JSONObject object = new JSONObject(tokener); // 매개변수로 JSON 데이터 전달 후 JSON 객체 생성
        JSONArray students = object.getJSONArray("students"); // 생성된 객체들을 객체 배열에 담는다.
        System.out.println(students);

        for(int i=0; i<students.length(); i++) {
            JSONObject student = (JSONObject)students.get(i); // get은 반환타입이 Object라 다운캐스팅 해야 실제 객체에 접근 가능
            System.out.print(student.get("name") + "\t");
            System.out.print(student.get("address") + "\t");
            System.out.println(student.get("phone"));
        }

    }
}
