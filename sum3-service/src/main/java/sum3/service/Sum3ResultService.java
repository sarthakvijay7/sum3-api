package sum3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.ISum3ResultRepository;
import sum3.dao.entity.ResultDataEntity;
import sum3.service.interfaces.ISum3ResultService;

@Service
public class Sum3ResultService implements ISum3ResultService {

	@Autowired
	private ISum3ResultRepository resultRepository;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ResultDataEntity createResult(ResultDataEntity resultEntity) {
		logger.debug("Inside Sum3ResultService -> createResult method");

		try {
			return resultRepository.save(resultEntity);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public ResultDataEntity getResultDataByRequestHistoryId(Long requestHistoryId) {
		logger.debug("Inside Sum3ResultService -> getResultDataByRequestHistoryId method");

		try {
			return resultRepository.getResultDataByRequestHistoryId(requestHistoryId);
		} catch (Exception e) {
			throw e;
		}
	}

}
