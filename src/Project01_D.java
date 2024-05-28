import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// 게시글 리스트 JSONArray, 게시글 내용 JSONObject
public class Project01_D {
    public static void main(String[] args) {
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        String clinetId = "NaverId";
        String clinetSecret = "password";
        try {
            System.out.print("주소를 입력하세요: ");
            String address = io.readLine();
            String addr = URLEncoder.encode(address, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clinetId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clinetSecret);

            int responseCode = con.getResponseCode(); // 200
            BufferedReader br;
            if(responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer(); // 문자열 추가 변경시 사용
            while((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONTokener tokener = new JSONTokener(response.toString());
            JSONObject object = new JSONObject(tokener);
            // System.out.println(object);
            JSONArray arr = object.getJSONArray("addresses");
            for(int i=0; i<arr.length(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                System.out.println("addres: " + temp.get("roadAddress"));
                System.out.println("jibunAddress: " + temp.get("jibunAddress"));
                System.out.println("경도: " + temp.get("x"));
                System.out.println("위도: " + temp.get("y"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
