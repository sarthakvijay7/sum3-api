package sum3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.entity.ResultDataEntity;
import sum3.repository.ISum3ResultRepository;
import sum3.service.interfaces.ISum3ResultService;

@Service
public class Sum3ResultService implements ISum3ResultService {

	@Autowired
	ISum3ResultRepository resultRepository;

	@Override
	public ResultDataEntity createResult(ResultDataEntity resultEntity) {

		return resultRepository.save(resultEntity);

	}

	@Override
	public ResultDataEntity getResultDataByRequestHistoryId(Long requestHistoryId) {

		return resultRepository.getResultDataByRequestHistoryId(requestHistoryId);
	}

}
