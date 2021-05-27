package omerergin.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.JobSeekerService;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/register")
public class RegistersController {
	
	private JobSeekerService jobSeekerService;
	
	 @Autowired
	public RegistersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService=jobSeekerService;
	}
	
	@PostMapping("/jobseekers")
	public Result JobSeekerRegister(@RequestBody JobSeeker jobSeeker,String confirmPassword) {
		
		return this.jobSeekerService.add(jobSeeker, confirmPassword);
		
	}
	
}
