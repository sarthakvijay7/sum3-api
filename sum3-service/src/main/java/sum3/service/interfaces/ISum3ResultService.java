package sum3.service.interfaces;

import sum3.dao.entity.ResultDataEntity;

public interface ISum3ResultService {

	ResultDataEntity createResult(ResultDataEntity resultEntity);

	ResultDataEntity getResultDataByRequestHistoryId(Long requestHistoryId);

}
