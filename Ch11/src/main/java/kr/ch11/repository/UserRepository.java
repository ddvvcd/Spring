package kr.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ch11.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
