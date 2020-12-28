package excerciseDiary.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
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
	
	@Column(name="channer", length=100, nullable=false)
	private String channer;
	
	@Column(name="purpose", length=20, nullable=false)
	private String purpose;
}
