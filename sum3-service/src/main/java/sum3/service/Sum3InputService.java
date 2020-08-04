package sum3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.ISum3InputDataRepository;
import sum3.dao.entity.InputDataEntity;
import sum3.service.interfaces.ISum3InputService;

@Service
public class Sum3InputService implements ISum3InputService {

	@Autowired
	ISum3InputDataRepository inputDataRepository;

	@Override
	public List<InputDataEntity> createInput(List<Long> numberList, Long requestHistoryId) {
		List<InputDataEntity> InputDataEntityList = MapRequestToEntity
				.mapRequestParamToInputResultMappingEntity(numberList, requestHistoryId);
		try {
			return (List<InputDataEntity>) inputDataRepository.saveAll(InputDataEntityList);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<InputDataEntity> getInputDataByRequestHistoryId(Long requestHistoryId) {

		try {
			return inputDataRepository.getInputDataByRequestHistoryId(requestHistoryId);
		} catch (Exception e) {
			return null;
		}
	}

}
