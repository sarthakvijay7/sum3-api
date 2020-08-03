package sum3.repository;

import org.springframework.data.repository.CrudRepository;

import sum3.dao.entity.ResultEntity;

public interface IResultRepository extends CrudRepository<ResultEntity, Long>{
	

}
