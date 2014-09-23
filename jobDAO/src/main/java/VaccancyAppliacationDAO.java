import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mum.jobportal.Idao.IVaccancyApplicationDAO;
import com.mum.jobportal.domain.VaccancyApplication;

@Transactional(propagation=Propagation.MANDATORY)
public class VaccancyAppliacationDAO implements IVaccancyApplicationDAO{

	public void create(VaccancyApplication vaccancyApplication) {
		// TODO Auto-generated method stub
		
	}

	public void update(VaccancyApplication vaccancy) {
		// TODO Auto-generated method stub
		
	}

	public void delete(VaccancyApplication vaccancy) {
		// TODO Auto-generated method stub
		
	}

	public VaccancyApplication get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VaccancyApplication> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VaccancyApplication> getAllVacancyByEmployer(long employerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
