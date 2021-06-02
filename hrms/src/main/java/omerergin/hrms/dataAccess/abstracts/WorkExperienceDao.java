package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {

}
