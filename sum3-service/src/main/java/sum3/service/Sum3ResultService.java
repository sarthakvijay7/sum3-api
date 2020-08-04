package sum3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.ISum3ResultRepository;
import sum3.dao.entity.ResultDataEntity;
import sum3.service.interfaces.ISum3ResultService;

@Service
public class Sum3ResultService implements ISum3ResultService {

	@Autowired
	private ISum3ResultRepository resultRepository;
	
	// Logger logger = Logger.getLogger(getClass());


	@Override
	public ResultDataEntity createResult(ResultDataEntity resultEntity) {
		//	logger.debug("Inside Sum3ResultService -> createResult method);

		try {
			return resultRepository.save(resultEntity);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public ResultDataEntity getResultDataByRequestHistoryId(Long requestHistoryId) {
		//	logger.debug("Inside Sum3ResultService -> getResultDataByRequestHistoryId method);

		try {
			return resultRepository.getResultDataByRequestHistoryId(requestHistoryId);
		} catch (Exception e) {
			return null;
		}
	}

}
