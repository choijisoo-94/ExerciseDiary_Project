package excerciseDiary.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
public class Video {
	
	@Id
	@Column(name="program_no", length=20, nullable=false)
	private int prograNo;
	
	@Column(name="playlist", length=100, nullable=false)
	private String playlist;
	
	@Column(name="youtube_url", length=200, nullable=false)
	private String youtubeUrl;
	
	@Column(name="youtuber", length=50, nullable=false)
	private String youtuber;
	
	@ManyToOne
	@Column(name="channel", length=100, nullable=false)
	private Youtube channel;
	
	@ManyToOne
	@Column(length=20, nullable=false)
	private Purpose purpose;
	
	@OneToMany(mappedBy="programNo") //1:다 관계
	private List<Diary> diary;
}
