package excerciseDiary.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
public class Purpose {
	@Id
	@Column(name="purpose", length=20, nullable=false)
	private String purpose;
	
	@OneToMany(mappedBy="purpose") //1:다 관계
	private List<Users> user;
	
	@OneToMany(mappedBy="purpose") //1:다 관계
	private List<Diary> diary;
	
	@OneToMany(mappedBy="purpose") //1:다 관계
	private List<Video> video;
}
