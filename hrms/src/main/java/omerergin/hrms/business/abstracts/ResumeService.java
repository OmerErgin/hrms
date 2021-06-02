package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add(Resume resume);
	DataResult<List<Resume>> getAll();
	DataResult<List<Resume>> findByJobSeekerId(int jobSeekerId);
}
