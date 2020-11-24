package javatest;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


public class SmsSend {
	static void 문자전송(String phone, String message) {
		String api_key = "NCS8Y6RGQTUTOIGI";
	    String api_secret = "CPYMAWMWXXE3MBVZB0Z5OI0ZQIN3VUHU";
	    Message coolsms = new Message(api_key, api_secret);
	
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phone);
	    params.put("from", "01085312625");
	    params.put("type", "SMS");
	    params.put("text", message);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println("메시지가 전송되었습니다.");
	      System.out.println(obj.toString());
	      //1번 obj(문자열) -> 자바 오브젝트
	      //2번 error가 있는지 확인
	      //3번 DB insert
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
	
  public static void main(String[] args) {
	  
  }
}
