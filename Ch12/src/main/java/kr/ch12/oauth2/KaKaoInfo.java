package kr.ch12.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KaKaoInfo  {
	
	private Map<String, Object> attributes;
	
	public String getId() {
		return attributes.get("id").toString();
	}
	
	public String getProvider() {
		return "kakao";
	}
	
	public String getEmail() {
		return (String) ((Map<?,?>) attributes.get("kakao_account")).get("email");
	}
	
	public String getNickname() {
		return (String) ((Map<?,?>) attributes.get("properties")).get("nickname");
	}
}
