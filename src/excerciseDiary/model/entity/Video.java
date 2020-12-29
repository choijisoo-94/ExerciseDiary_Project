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

@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Getter
@Setter
@Builder
@Entity
public class Video {
	
	@Id
	@Column(name="program_no", length=20, nullable=false)
	private String programNo;
	
	@Column(name="playlist", length=100, nullable=false)
	private String playlist;
	
	@Column(name="youtube_url", length=200, nullable=false)
	private String youtubeUrl;
	
	@ManyToOne
	@JoinColumn(name="channel", nullable=false)
	private Youtube channel;
	
	/*@Column(name="youtuber", length=50, nullable=false)
	private String youtuber;*/
	
	@ManyToOne
	@JoinColumn(name="purpose", nullable=false)
	private Purpose purpose;
	
	@OneToMany(mappedBy="programNo", fetch = FetchType.EAGER) //1:다 관계
	private List<Diary> diary;
	
	public Video(String programNo) {
		super();
		this.programNo = programNo;
	}
}
