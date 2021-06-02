package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer> {

}
