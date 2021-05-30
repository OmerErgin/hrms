package omerergin.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="city_id")
	//private int cityId;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="is_active")
	private boolean isActive;
	

	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	
}
