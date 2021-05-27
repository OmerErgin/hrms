package omerergin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name="employer_id")
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	@Column(name="name")
	private String name;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_verify",columnDefinition = "boolean default false")
	private boolean isVerify;
	
	@Column(name="is_confirm",columnDefinition= "boolean default false")
	private boolean isConfirm;
	
}
