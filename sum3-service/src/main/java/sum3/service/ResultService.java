package sum3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.entity.ResultEntity;
import sum3.repository.IResultRepository;
import sum3.service.interfaces.IResultService;

@Service
public class ResultService implements IResultService {

	@Autowired
	IResultRepository resultRepository;
	
	@Override
	public ResultEntity createResult(ResultEntity resultEntity) {
    
		return resultRepository.save(resultEntity);
		
	}

}
