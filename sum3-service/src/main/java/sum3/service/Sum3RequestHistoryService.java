package sum3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.ISum3RequestHistoryRepository;
import sum3.dao.entity.RequestHistoryEntity;
import sum3.service.interfaces.ISum3RequestHistoryService;

@Service
public class Sum3RequestHistoryService implements ISum3RequestHistoryService {

	@Autowired
	ISum3RequestHistoryRepository sum3requestHistoryRepository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public Long createRequestHistory(Long targetNumber) {
			logger.debug("Inside Sum3RequestHistoryService -> createRequestHistory method");
		try {
			RequestHistoryEntity requestHistoryEntity = sum3requestHistoryRepository
					.save(MapRequestToEntity.mapToRequestHistoryEntity(targetNumber));
			return requestHistoryEntity.getId();
		} catch (Exception e) {
          throw e;
		}
	}

	@Override
	public RequestHistoryEntity getRequestHistoryById(Long id) {
			logger.debug("Inside Sum3RequestHistoryService -> getRequestHistoryById method");
		try {
			return sum3requestHistoryRepository.getRequestHistoryById(id);
		} catch (Exception e) {
           throw e;
		}
	}
}
