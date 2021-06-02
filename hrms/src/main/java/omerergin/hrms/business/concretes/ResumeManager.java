package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.ResumeService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.ForeignLanguageDao;
import omerergin.hrms.dataAccess.abstracts.ResumeDao;
import omerergin.hrms.dataAccess.abstracts.SchoolDao;
import omerergin.hrms.dataAccess.abstracts.SkillDao;
import omerergin.hrms.dataAccess.abstracts.WorkExperienceDao;
import omerergin.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {
	
	private ResumeDao resumeDao;
	private ForeignLanguageDao foreignLanguageDao;
	private SkillDao skillDao;
	private SchoolDao schoolDao;
	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,ForeignLanguageDao foreignLanguageDao,SchoolDao schoolDao,SkillDao skillDao,WorkExperienceDao workExperienceDao) {
		super();
		this.resumeDao = resumeDao;
		this.foreignLanguageDao=foreignLanguageDao;
		this.schoolDao=schoolDao;
		this.skillDao=skillDao;
		this.workExperienceDao=workExperienceDao;
	}



	@Override
	public Result add(Resume resume) {
		foreignLanguageDao.saveAll(resume.getForeignLanguage());
		schoolDao.saveAll(resume.getSchool());
		skillDao.saveAll(resume.getSkill());
		workExperienceDao.saveAll(resume.getWorkExperience());
		resumeDao.save(resume);
		return new SuccessResult();
	}



	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}



	@Override
	public DataResult<List<Resume>> findByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findByJobSeekerId(jobSeekerId));
		
	}

}
