package sum3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sum3.dao.entity.ResultDataEntity;

public interface ISum3ResultRepository extends CrudRepository<ResultDataEntity, Long> {

	@Query("SELECT rde FROM ResultDataEntity rde WHERE requestHistoryId=:requestHistoryId")
	public ResultDataEntity getResultDataByRequestHistoryId(@Param("requestHistoryId") Long requestHistoryId);
}
