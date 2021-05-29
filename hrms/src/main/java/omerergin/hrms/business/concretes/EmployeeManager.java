package omerergin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.EmployeeService;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.EmployeeDao;
import omerergin.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("Employee added");
	}

}
