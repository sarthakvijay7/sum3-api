package sum3.service.interfaces;

import java.util.List;

import sum3.dao.entity.InputDataEntity;

public interface ISum3InputService {

	List<InputDataEntity> createInput(List<Long> numberList, Long id);
	
	List<InputDataEntity> getInputDataByRequestHistoryId(Long requestHistoryId);
}
