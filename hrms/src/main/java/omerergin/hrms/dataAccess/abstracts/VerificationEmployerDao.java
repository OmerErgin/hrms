package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.VerificationEmployer;

public interface VerificationEmployerDao extends JpaRepository<VerificationEmployer,Integer> {

}
