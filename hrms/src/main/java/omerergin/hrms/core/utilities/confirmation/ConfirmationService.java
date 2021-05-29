package omerergin.hrms.core.utilities.confirmation;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Employee;

public interface ConfirmationService {
	Result confirmationToEmployer(Employee employee,String employerName);
}
