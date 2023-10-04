package kr.ch08.entity.board;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardArticle")
public class ArticleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String title;
	private String content;
	
	// 방향성을 고려해서 Article에서 User를 참조해야 Article을 조회할때 User가 동시에 참조 됨
	// @JoinColumn 선언으로 생성되는 컬럼명을 설정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="writer")
	private UserEntity user;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "article")
	private FileEntity file;
	
	// 방향성을 고려해서 Article에서 Comment를 참조해야 Article을 조회할 때 Comment가 동시에 참조 됨
	// 양방향 관계에서 외래키를 갖는 엔티티의 속성을 mappedBy 속성으로 연결 주인을 설정
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article") //mappedBy 속성 안 하면 에러 뜸 (참조 시킴?)
	private List<CommentEntity> comments;
	
	@CreationTimestamp
	private LocalDateTime rdate;
}
