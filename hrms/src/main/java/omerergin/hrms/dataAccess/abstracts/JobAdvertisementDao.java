package omerergin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByIsActiveTrueOrderByCreateDateAsc();
	List<JobAdvertisement> getByIsActiveTrueAndEmployerId(int employerId);
}
