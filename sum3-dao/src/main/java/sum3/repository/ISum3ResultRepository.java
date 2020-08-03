package sum3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sum3.dao.entity.ResultDataEntity;

public interface ISum3ResultRepository extends CrudRepository<ResultDataEntity, Long> {

	@Query("SELECT ide FROM ResultDataEntity se WHERE requestHistoryId=:requestHistoryId")
	ResultDataEntity getResultDataByRequestHistoryId(@Param("requestHistoryId") Long requestHistoryId);
}
