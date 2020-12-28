package excerciseDiary.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class User {
	
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
	
	@Column(length=20, nullable=false)
	private String purpose;
	
	
	
	/*@Id
	@Column(name="activist_id", length=20, nullable=false)
	private String activistId;
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length=20, nullable=false)
	private String password;
	
	@Column(length=50, nullable=false)
	private String major;
	
	@OneToMany(mappedBy="activistId") //1:다 관계
	private List<Probono_project> project;*/

}
