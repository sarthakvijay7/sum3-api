package sum3.service.interfaces;

import sum3.dao.entity.RequestHistoryEntity;

public interface ISum3RequestHistoryService {

	Long createRequestHistory(Long targetNumber);

	RequestHistoryEntity getRequestHistoryById(Long id);
}
