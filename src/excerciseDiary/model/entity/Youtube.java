package excerciseDiary.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
//@ToString
@Builder

@Entity
public class Youtube {

	@Id
	@Column(name="channel", length=50, nullable=false)
	private String channel;
	
	@Column(name="youtuber", length=20, nullable=false)
	private String youtuber;
	
	@OneToMany(mappedBy="channel", fetch = FetchType.EAGER) //1:다 관계
	private List<Video> video;

}
