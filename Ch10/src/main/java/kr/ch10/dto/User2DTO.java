package kr.ch10.dto;

import kr.ch10.entity.User2Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User2DTO {
	
	private String id;
	private String name;
	private String hp;
	private int age;
	
	//Entity 변환 메서드
	public User2Entity toEntity() {
		return User2Entity.builder()
						  .id(id)
						  .name(name)
						  .hp(hp)
						  .age(age)
						  .build();
	}
}
