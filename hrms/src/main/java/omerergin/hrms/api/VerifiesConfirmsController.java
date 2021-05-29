package omerergin.hrms.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omerergin.hrms.core.utilities.confirmation.ConfirmationService;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.verification.VerificationService;
import omerergin.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/verifiesAndConfirms")
public class VerifiesConfirmsController {
	
	private ConfirmationService confirmationService;
	private VerificationService verificationService;

	public VerifiesConfirmsController(ConfirmationService confirmationService,VerificationService verificationService) {
		super();
		this.confirmationService = confirmationService;
		this.verificationService=verificationService;
	}
	
	@PostMapping("/confirmation/employers")
	public Result confirmationToEmployers(@RequestBody Employee employee,String email) {
		return this.confirmationService.confirmationToEmployer(employee, email);
	}
	
	@PostMapping("/fakeVerification")
	public Result fakeVerificationEmail(String email) {
		return this.verificationService.fakeVerifyAccount(email);
	}
	
}
