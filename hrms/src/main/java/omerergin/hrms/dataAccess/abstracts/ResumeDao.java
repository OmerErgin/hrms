package omerergin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume,Integer> {
	List<Resume> findByJobSeekerId(int jobSeekerId);
}
