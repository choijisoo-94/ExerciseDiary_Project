package excerciseDiary.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
//@ToString

@Entity
@Table(name="purpose")
public class Purpose {
	@Id
	@Column(name="purpose", length=20, nullable=false)
	private String purpose;
	
	@OneToMany(mappedBy="purpose", fetch = FetchType.EAGER) //1:다 관계
	private List<Users> user;
	
	@OneToMany(mappedBy="purpose", fetch = FetchType.EAGER) //1:다 관계
	private List<Diary> diary;
	
	@OneToMany(mappedBy="purpose", fetch = FetchType.EAGER) //1:다 관계
	private List<Video> video;

	public Purpose(String purpose) {
		super();
		this.purpose = purpose;
	}
}
