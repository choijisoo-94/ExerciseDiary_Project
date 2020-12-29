package excerciseDiary.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Diary {
	@Id
	@Column(name="diary_no",length=20, nullable= false)
	private String diaryNo;
	
	@Column(name="diary_title", length=50, nullable= false)
	private String diaryTitle;
	
	@Column(name="diary_content",length=200, nullable= false)
	private String diaryContent;
	
	@Column(name="write_date",length=200, nullable= false)
	private String writeDate;
	
	@Column(name="today_weight",length=20, nullable= false)
	private String todayWeight;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable= false)
	private Users userId;
	
	@ManyToOne
	@JoinColumn(name="purpose", nullable=false)
	private Purpose purpose;
	
	@ManyToOne
	@JoinColumn(name="program_no", nullable= false)
	private Video programNo;
}
