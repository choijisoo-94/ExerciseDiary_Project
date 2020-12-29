package excerciseDiary.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@ToString

@Entity
public class Users {
	
	@Id
	@Column(name="user_id", length=20, nullable=false)
	private String userId;
	
	@Column(name="user_password", length=0, nullable=false)
	private String userPassword;

	@Column(name="user_name", length=50, nullable=false)
	private String userName;
	
	@Column(name="user_gender", length=20, nullable=false)
	private String userGender;
	
	@Column(name="user_age", length=20, nullable=false)
	private String userAge;
	
	@Column(name="user_height", length=20, nullable=false)
	private String userHeight;
	
	@Column(name="user_weight", length=20, nullable=false)
	private String userWeight;
	
	@ManyToOne
	@JoinColumn(name="purpose", nullable=false)
	private Purpose purpose;
	
	@OneToMany(mappedBy="userId", fetch = FetchType.EAGER) //1:다 관계
	private List<Diary> diary;

	public Users(String userId, String userPassword, String userName, String userGender, String userAge,
			String userHeight, String userWeight, Purpose purpose) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.purpose = purpose;
	}
	
	public Users(String userId) {
		super();
		this.userId = userId;
	}
}
