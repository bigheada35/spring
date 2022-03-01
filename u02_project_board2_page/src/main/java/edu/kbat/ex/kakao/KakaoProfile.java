package edu.kbat.ex.kakao;

import lombok.Data;

@Data
public class KakaoProfile {
	
	private int id;
	private  String connected_at;
	private Properties properties;
	private KakaoAccount kakao_account;

}
