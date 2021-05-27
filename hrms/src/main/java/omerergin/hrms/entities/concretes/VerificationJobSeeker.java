package omerergin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_jobseekers")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationJobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="jobseeker_id")
	private int jobseekerId;
	
	@Column(name="is_verified",columnDefinition = "boolean default false")
	private boolean isVerified;
	

}
