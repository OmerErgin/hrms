package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.CityService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.CityDao;
import omerergin.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities.");
	}

	@Override
	public Result add(City city) {
		if(cityDao.findById(city.getId()).isEmpty()&&cityDao.findByCityName(city.getCityName()).isEmpty()) {	
		cityDao.save(city);
		return new SuccessResult("City added"); }
		else {
			return new ErrorResult("Can not add.");
		}
	}

}
