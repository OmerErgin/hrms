package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.VerificationJobSeeker;

public interface VerificationJobSeekerDao extends JpaRepository<VerificationJobSeeker,Integer> {

}
