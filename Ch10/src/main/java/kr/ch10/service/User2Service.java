package kr.ch10.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.dto.User2DTO;
import kr.ch10.entity.User2Entity;
import kr.ch10.repository.User2Repository;

@Service
public class User2Service {

	@Autowired
	private User2Repository repo;
	
	public void insertUser2(User2DTO dto) {
		// DTO를 Entity로 변환
		User2Entity entity = dto.toEntity();
		repo.save(entity);
	}
	public User2DTO selectUser2(String id) {
		
		Optional<User2Entity> result = repo.findById(id);
		
		// Entity를 DTO로 변환
		User2DTO dto = result.get().toDTO();
		
		return dto;
	}
	public List<User2DTO> selectUser2s() {
		// List<Entity>를 List<DTO>로 변환해서 리턴
		return repo.findAll()
				  .stream()
				  .map(entity -> User2DTO.builder()
						  .id(entity.getId())
						  .name(entity.getName())
						  .hp(entity.getHp())
						  .age(entity.getAge())
						  .build())
				  .collect(Collectors.toList());
	}
	
	public void updateUser2(User2DTO dto) {
		// DTO를 Entity로 변환
		User2Entity entity = dto.toEntity();
		repo.save(entity);
	}
	public void deleteUser2(String id) {
		repo.deleteById(id);
	}
}