package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

}
