package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer,String confirmPassword);
}
