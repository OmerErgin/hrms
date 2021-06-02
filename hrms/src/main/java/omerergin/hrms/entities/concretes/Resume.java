package omerergin.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	//private int id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_id")
	private int resumeId;
	
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	@Column(name="jobseeker_id")
	private int jobSeekerId;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="github")
	private String github;
	
	@Column(name="image")
	private String image;
	
	@OneToMany(mappedBy = "resume")
	private List<School> school;
	
	@OneToMany(mappedBy = "resume")
	private List<WorkExperience> workExperience;
	
	@OneToMany(mappedBy = "resume")
	private List<ForeignLanguage> foreignLanguage;
	
	@OneToMany(mappedBy = "resume")
	private List<Skill> skill;
	
	@OneToMany(mappedBy="jobseekers")
	private List<Resume> resume;

}
