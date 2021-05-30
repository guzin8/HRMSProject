package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	//private int employerId;
	//private int jobPositionId;
	
	@Column(name = "job_definition")
	private String jobDefinition;
	
	@Column(name = "min_salary")
	private float minSalary;
	
	@Column(name = "max_salary")
	private float maxSalary;
	
	@Column(name = "number_of_hires")
	private int numberOfHires;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
		
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
