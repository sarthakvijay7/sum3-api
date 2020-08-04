package sum3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.dao.ISum3RequestHistoryRepository;
import sum3.dao.entity.RequestHistoryEntity;
import sum3.service.interfaces.ISum3RequestHistoryService;

@Service
public class Sum3RequestHistoryService implements ISum3RequestHistoryService {

	@Autowired
	ISum3RequestHistoryRepository sum3requestHistoryRepository;

	@Override
	public Long createRequestHistory(Long targetNumber) {
		try {
			RequestHistoryEntity requestHistoryEntity = sum3requestHistoryRepository
					.save(MapRequestToEntity.mapToRequestHistoryEntity(targetNumber));
			return requestHistoryEntity.getId();
		} catch (Exception e) {
			return -1l;

		}
	}

	@Override
	public RequestHistoryEntity getRequestHistoryById(Long id) {
		try {
			return sum3requestHistoryRepository.getRequestHistoryById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
