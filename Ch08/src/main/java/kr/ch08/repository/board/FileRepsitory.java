package kr.ch08.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.FileEntity;

@Repository
public interface FileRepsitory extends JpaRepository<FileEntity, Integer>{ //id의 타입
	
	
	
	
}
