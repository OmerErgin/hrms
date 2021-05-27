package omerergin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobseekers")
@PrimaryKeyJoinColumn(name="jobseeker_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_id")
	private String identityId;
	
	@Column(name="date_of_year")
	private Integer dateOfYear;
	
	@Column(name="is_verify",columnDefinition = "boolean default false")
	private boolean isVerify;
	
		
	
}
