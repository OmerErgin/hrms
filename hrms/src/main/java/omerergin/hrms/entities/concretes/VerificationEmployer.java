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
@Table(name="verification_employers")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationEmployer {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employer_id;
	
	@Column(name="employee_id")
	private int employee_id;
	
	@Column(name="is_verified",columnDefinition = "boolean default false")
	private boolean isVerified;
	
	@Column(name="is_confirm",columnDefinition= "boolean default false")
	private boolean isConfirm;
	
	
	
}
