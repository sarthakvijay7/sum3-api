package sum3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sum3.dao.entity.InputDataEntity;

public interface ISum3InputDataRepository extends CrudRepository<InputDataEntity, Long>{

    @Query("SELECT ide FROM InputDataEntity ide WHERE requestHistoryId=:requestHistoryId")
	List<InputDataEntity> getInputDataByRequestHistoryId(@Param("requestHistoryId") Long requestHistoryId);
}
