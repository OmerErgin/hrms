package omerergin.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.JobSeekerService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/job_seeker")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		
		super();
		this.jobSeekerService=jobSeekerService;
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	

}
