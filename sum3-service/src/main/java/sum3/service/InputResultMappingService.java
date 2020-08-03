package sum3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.entity.InputResultMappingEntity;
import sum3.repository.IInputResultMappingRepository;
import sum3.service.interfaces.IInputResultMappingService;

@Service
public class InputResultMappingService implements IInputResultMappingService{

	@Autowired
	IInputResultMappingRepository inputResultMappingRepository;
	
	@Override
	public List<InputResultMappingEntity> createInputResultMapping(List<Long> numberList, Long id) {
		List<InputResultMappingEntity> inputResultMappingEntityList=MapRequestToEntity.mapRequestParamToInputResultMappingEntity(numberList, id);
	    return (List<InputResultMappingEntity>) inputResultMappingRepository.saveAll(inputResultMappingEntityList);
		
	}

}
