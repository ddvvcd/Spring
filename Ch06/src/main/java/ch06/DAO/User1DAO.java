package ch06.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch06.DTO.User1DTO;

@Repository
public class User1DAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser1(User1DTO dto) {
		mybatis.insert("user1.insertUser1", dto);
	}
	
	public User1DTO selectUser1(String uid) {
		return null;
	}
	
	public List<User1DTO> selectUser1s() {
		return null;
	}
	
	public void updateUser1(User1DTO dto) {
		
	}
	
	public void deleteUser1(String uid) {}
}
