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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

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
	
	@Column(name="user_id",length=20, nullable= false)
	private String userId;
	
	@Column(name="purpose",length=20, nullable= false)
	private String purpose;
	
	@Column(name="program_no",length=20, nullable= false)
	private String programNo;

}
