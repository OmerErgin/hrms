package omerergin.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.business.abstracts.UserService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	 @GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		
		return this.userService.getAll();
		 
	}
	

}
