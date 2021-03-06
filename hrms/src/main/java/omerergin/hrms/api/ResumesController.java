package omerergin.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.ResumeService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resume")
public class ResumesController {
	
	private ResumeService resumeService;
	
	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll() {
		return this.resumeService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<Resume>> findByJobSeekerId(int jobSeekerId){
		return this.resumeService.findByJobSeekerId(jobSeekerId);
	}
	
	
}
