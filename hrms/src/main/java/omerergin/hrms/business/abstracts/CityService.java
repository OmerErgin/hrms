package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
