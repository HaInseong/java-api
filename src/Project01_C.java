import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        String file = "info.json";
        // 파일에서 데이터를 읽어오려면 InputStream이 필요
        InputStream is = Project01_C.class.getResourceAsStream(file); // 파일을 읽어온다.
        // Project01_C.class.getResourceAsStream(file) = 클래스가 만들어진 경로에서 스트림을 통해 얻어와라
        if(is==null) {
            throw new NullPointerException("Cannot find resource file");
        }
        // 토큰화란? 일반 문자열 Json 형태로 만드는 것
        JSONTokener tokener = new JSONTokener(is); // 스트림으로 읽어온 파일은 문자열 형태이므로, JSON문자열 형태로 토큰화한다(메모리에 올리기 위해).
        JSONObject object = new JSONObject(tokener); // tokener에 들어있는 json 데이터를 객체로 만들어서 핸들링하기위해 JSONObject 매개변수로 토큰을 전달한다.
        JSONArray students = object.getJSONArray("students"); // 핸들링 가능한 object객체로 key가 studnets인 Array 정보 가져오기.
        System.out.println(students);
        System.out.println(students.get(0));

        for(int i=0; i<students.length(); i++) {
            JSONObject student = (JSONObject)students.get(i); // ★ get은 반환타입이 Object라 다운캐스팅 해야 실제 객체에 접근 가능
            System.out.print(student.get("name") + "\t");
            System.out.print(student.get("address") + "\t");
            System.out.println(student.get("phone"));
        }

    }
}
