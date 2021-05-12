package omerergin.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.JobPositionManagerService;
import omerergin.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobaositions")
public class JobPositionsController {

	private JobPositionManagerService jobPositionManagerService;
	
	@Autowired
	public JobPositionsController(JobPositionManagerService jobPositionManagerService) {
		
		this.jobPositionManagerService=jobPositionManagerService;

	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return this.jobPositionManagerService.getAll();
	}
	
	
	
	
}
