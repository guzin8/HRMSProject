package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "candidate_id")
	private JobSeeker jobSeeker;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@OneToMany(mappedBy = "resume")
	private List<School> schools;
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy= "resume")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy = "resume")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@Column(name = "githublink")
	private String githubLink;
	
	@Column(name = "linkedinlink")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;

}
