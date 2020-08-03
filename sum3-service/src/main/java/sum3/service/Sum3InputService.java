package sum3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.entity.InputDataEntity;
import sum3.repository.ISum3InputDataRepository;
import sum3.service.interfaces.ISum3InputService;

@Service
public class Sum3InputService implements ISum3InputService{

	@Autowired
	ISum3InputDataRepository inputDataRepository;
	
	@Override
	public List<InputDataEntity> createInput(List<Long> numberList, Long requestHistoryId) {
		List<InputDataEntity> InputDataEntityList=MapRequestToEntity.mapRequestParamToInputResultMappingEntity(numberList, requestHistoryId);
	    return (List<InputDataEntity>) inputDataRepository.saveAll(InputDataEntityList);
		
	}

	@Override
	public List<InputDataEntity> getInputDataByRequestHistoryId(Long requestHistoryId) {
    return inputDataRepository.getInputDataByRequestHistoryId(requestHistoryId);
	}

}
