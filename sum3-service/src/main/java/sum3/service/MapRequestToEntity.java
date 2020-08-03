package sum3.service;

import java.util.ArrayList;
import java.util.List;

import sum3.dao.entity.InputResultMappingEntity;
import sum3.dao.entity.ResultEntity;

public class  MapRequestToEntity {

	public static ResultEntity mapOutputToResultEntity(Long resultantNumber1, Long resultantNumber2, Long resultantNumber3, Long sum)
	{
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultNumber1(resultantNumber1);
         resultEntity.setResultNumber2(resultantNumber2);
         resultEntity.setResultNumber3(resultantNumber3);
         resultEntity.setSumNumber(sum);
		return resultEntity;
		
	}

	public static List<InputResultMappingEntity> mapRequestParamToInputResultMappingEntity(List<Long> numberList, Long id) {
       List<InputResultMappingEntity> inputResultMappingEntityList = new ArrayList<>();
		for(Long number : numberList)
		{
		InputResultMappingEntity inputResultMappintEntity = new InputResultMappingEntity();
		inputResultMappintEntity.setNumberLookFrom(number);
		inputResultMappintEntity.setResultDataLogId(id);
		inputResultMappingEntityList.add(inputResultMappintEntity);
		}
		return inputResultMappingEntityList;
	}
}
