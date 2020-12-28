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
@ToString
@Builder

@Entity
public class Youtube {
	@Id
	@Column(name="youtuber", length=20, nullable=false)
	private String youtuber;
	
	@Column(name="channel", length=50, nullable=false)
	private String channel;
}
