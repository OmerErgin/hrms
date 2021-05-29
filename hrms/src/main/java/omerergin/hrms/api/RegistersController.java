package omerergin.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.EmployerService;
import omerergin.hrms.business.abstracts.JobSeekerService;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Employer;
import omerergin.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/register")
public class RegistersController {
	
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	
	 @Autowired
	public RegistersController(JobSeekerService jobSeekerService,EmployerService employerService) {
		this.jobSeekerService=jobSeekerService;
		this.employerService=employerService;
	}
	
	@PostMapping("/jobseekers")
	public Result JobSeekerRegister(@RequestBody JobSeeker jobSeeker,String confirmPassword) {
		
		return this.jobSeekerService.add(jobSeeker, confirmPassword);
		
	}
	
	@PostMapping("/employers")
	public Result EmployerRegister(@RequestBody Employer employer,String confirmPassword) {
		
		return this.employerService.add(employer, confirmPassword);
		
	}
	
}
