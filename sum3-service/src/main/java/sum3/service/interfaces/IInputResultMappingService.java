package sum3.service.interfaces;

import java.util.List;

import sum3.dao.entity.InputResultMappingEntity;

public interface IInputResultMappingService {

	List<InputResultMappingEntity> createInputResultMapping(List<Long> numberList, Long id);
}
