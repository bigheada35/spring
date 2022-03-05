package edu.kosmo.kbat.kakao;

import lombok.Data;

@Data
public class KakaoAccount {

	private boolean profile_needs_agreement;
	private Profile profile;

}
