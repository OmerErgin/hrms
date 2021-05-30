package omerergin.hrms.api;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.JobAdvertisementService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_advertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	@GetMapping("/getByIsActiveTrueOrderByCreateDateAsc")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreateDateAsc() {
		return this.jobAdvertisementService.getByIsActiveTrueOrderByCreateDateAsc();
	}
	
	@GetMapping("/getByIsActiveAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(int employerId){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployerId(employerId);
	}
	
	@GetMapping("/changeJobAdvertisementStatus")
	public Result changeJobAdvertisementStatus(int employerId, int jobAdvertisementId, boolean status) {
		return this.jobAdvertisementService.changeJobAdvertisementStatus(employerId, jobAdvertisementId, status);
	}
	
	
}
