package edu.kosmo.kbat.service.social;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.kosmo.kbat.kakao.KakaoAuth;
import edu.kosmo.kbat.kakao.KakaoProfile;



@Service
public class KakaoServiceImpl {
	
	private final static String K_CLIENT_ID = "7d7e07da71b0b9ac51f0fb3a6284d2ea";
	private final static String K_REDIRECT_URI = "http://localhost:8282/ex/auth/kakao/callback";

	public String getAuthorizationUrl() {
		String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" + K_CLIENT_ID + "&redirect_uri="
				+ K_REDIRECT_URI + "&response_type=code";
		return kakaoUrl;
	}
	
	// POST방식으로 key-value 데이터를 요청(카카오쪽으로)
	private final static String K_TOKEN_URI = "https://kauth.kakao.com/oauth/token";

	// 토큰 받기 설명
	// https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token
	public KakaoAuth getKakaoTokenInfo(String code) {
	// http 요청을 간단하게 해줄 수 있는 클래스
		RestTemplate restTemplate = new RestTemplate();
	      
	    // Set header : Content-type: application/x-www-form-urlencoded
	    HttpHeaders headers = new HttpHeaders();
	    // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	    // Set parameter
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("grant_type", "authorization_code");
	    params.add("client_id", K_CLIENT_ID);
	    params.add("redirect_uri", K_REDIRECT_URI);
	    params.add("code", code);

	    // Set http entity
	    HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);


	    // 실제로 요청하기
	    // Http 요청하기 - POST 방식으로 - 그리고 response 변수의 응답을 받음.
	    ResponseEntity<String> response = restTemplate.postForEntity(K_TOKEN_URI, kakaoTokenRequest,
	          String.class);

	    System.out.println(response.getBody());
	      
	    //Gson ,Json Simple, ObjectMapper 세가지 정도의 클래스가 있음
	    Gson gson = new Gson();
	   
	    if (response.getStatusCode() == HttpStatus.OK) {
	       return gson.fromJson(response.getBody(), KakaoAuth.class); 
	    }
	      
	    return null;

	 }
	
	private final static String K_PROFILE_URI = "https://kapi.kakao.com/v2/user/me";
	   //https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info
	   public KakaoProfile getKakaoProfile(String accessToken) {
	      
	      RestTemplate restTemplate = new RestTemplate();
	        
	      // Set header : Content-type: application/x-www-form-urlencoded
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        headers.set("Authorization", "Bearer " + accessToken);
	        
	        // Set http entity
	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
	      
	        Gson gson = new Gson();
	        try {
	            // Request profile
	            ResponseEntity<String> response = restTemplate.postForEntity(K_PROFILE_URI, request, String.class);
	            
	            if (response.getStatusCode() == HttpStatus.OK)
	               System.out.println(response.getBody());
	            
	               KakaoProfile profile = gson.fromJson(response.getBody(), KakaoProfile.class);
	               System.out.println(profile);
	           
	               return gson.fromJson(response.getBody(), KakaoProfile.class);
	            
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return null;
	    }
	   /*
	   private final static String K_LOGOUT_URI = "https://kapi.kakao.com/v1/user/logout";
		public String kakaoLogout(String accessToken) {
			
			RestTemplate restTemplate = new RestTemplate();// http ��û�� �����ϰ� ���� �� �ִ� Ŭ����
	        
			// Set header : Content-type: application/x-www-form-urlencoded
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        headers.set("Authorization", "Bearer " + accessToken);
	        
	        //Post ����
	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
			Gson gson = new Gson();
	        try {
	            // Request profile
	            ResponseEntity<String> response = restTemplate.postForEntity(K_LOGOUT_URI, request, String.class);
	            
	            if (response.getStatusCode() == HttpStatus.OK)
	            	System.out.println(response.getBody());

	            	return "SUCESS";
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return null;
	    }*/
		
		//īī�������� �Բ� �α׾ƿ�
		//https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
		private final static String K_LOGOUT_WITH_ID_URI = "https://kauth.kakao.com/oauth/logout";
		private final static String K_LOGOUT_CALLBACK_URI = "http://localhost:8282/ex/kakao/logout";
			
		public String kakaoLogoutWithID(String code) {
			RestTemplate restTemplate = new RestTemplate();// http ��û�� �����ϰ� ���� �� �ִ� Ŭ����
			// Set header : Content-type: application/x-www-form-urlencoded
			HttpHeaders headers = new HttpHeaders();
			// headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			// Set parameter
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", "authorization_code");
			params.add("client_id", K_CLIENT_ID);
			params.add("logout_redirect_uri", K_LOGOUT_CALLBACK_URI);
			params.add("code", code);

			// Set http entity
			HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

			// ������ ��û�ϱ�
			// Http ��û�ϱ� - POST ������� - �׸��� response ������ ������ ����.
			ResponseEntity<String> response = restTemplate.postForEntity(K_LOGOUT_WITH_ID_URI, kakaoTokenRequest,
					String.class);

			System.out.println(response.getBody());
			Gson gson = new Gson();
			//Gson ,Json Simple, ObjectMapper ������ ������ Ŭ������ ����
			if (response.getStatusCode() == HttpStatus.OK) {
				return gson.fromJson(response.getBody(), String.class); 
			}
			
			return null;			
		}
		
		public String getAccessToken (String authorize_code) {
	        String access_Token = "";
	        String refresh_Token = "";
	        String reqURL = "https://kauth.kakao.com/oauth/token";
	        
	        try {
	            URL url = new URL(reqURL);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            
	            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	            StringBuilder sb = new StringBuilder();
	            sb.append("grant_type=authorization_code");
	            sb.append("&client_id=b5f85af25d1bdf961d4f2016bafe3c6e");
	            sb.append("&redirect_uri=http://localhost:8000/login");
	            sb.append("&code=" + authorize_code);
	            bw.write(sb.toString());
	            bw.flush();
	            
	            //    결과 코드가 200이라면 성공
	            int responseCode = conn.getResponseCode();
	            System.out.println("responseCode : " + responseCode);
	 
	            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line = "";
	            String result = "";
	            
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("response body : " + result);
	            
	            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
	            JsonParser parser = new JsonParser();
	            JsonElement element = parser.parse(result);
	            
	            access_Token = element.getAsJsonObject().get("access_token").getAsString();
	            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
	            
	            System.out.println("access_token : " + access_Token);
	            System.out.println("refresh_token : " + refresh_Token);
	            
	            br.close();
	            bw.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	        
	        return access_Token;
	    }
	
		
		public HashMap<String, Object> getUserInfo (String access_Token) {
		    
		    //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		    HashMap<String, Object> userInfo = new HashMap<>();
		    String reqURL = "https://kapi.kakao.com/v2/user/me";
		    try {
		        URL url = new URL(reqURL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        
		        //    요청에 필요한 Header에 포함될 내용
		        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
		        
		        int responseCode = conn.getResponseCode();
		        System.out.println("responseCode : " + responseCode);
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println("response body : " + result);
		        
		        JsonParser parser = new JsonParser();
		        JsonElement element = parser.parse(result);
		        
		        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
		        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
		        
		        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
		        String email = kakao_account.getAsJsonObject().get("email").getAsString();
		        
		        userInfo.put("nickname", nickname);
		        userInfo.put("email", email);
		        
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    
		    return userInfo;
		}

		public void kakaoLogout(String access_Token) {
		    String reqURL = "https://kapi.kakao.com/v1/user/logout";
		    try {
		        URL url = new URL(reqURL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
		        
		        int responseCode = conn.getResponseCode();
		        System.out.println("responseCode : " + responseCode);
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        
		        String result = "";
		        String line = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println(result);
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}

		
}
