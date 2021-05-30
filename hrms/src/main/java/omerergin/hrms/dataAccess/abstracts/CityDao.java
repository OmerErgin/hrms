package omerergin.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import omerergin.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer> {
	List<City> findByCityName(String name);
}
