package sum3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sum3.dao.entity.RequestHistoryEntity;

public interface ISum3RequestHistoryRepository extends CrudRepository<RequestHistoryEntity, Long>{

    @Query("SELECT rhe FROM RequestHistoryEntity se WHERE id=:id")
	RequestHistoryEntity getRequestHistoryById(@Param("id") Long id);
}
