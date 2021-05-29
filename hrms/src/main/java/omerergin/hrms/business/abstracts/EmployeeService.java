package omerergin.hrms.business.abstracts;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);
}
