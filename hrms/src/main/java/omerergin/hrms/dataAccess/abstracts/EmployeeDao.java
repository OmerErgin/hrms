package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
