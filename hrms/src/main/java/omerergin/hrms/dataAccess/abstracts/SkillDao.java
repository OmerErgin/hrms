package omerergin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer> {

}
