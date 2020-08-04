package sum3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sum3.common.model.HistoryResponse;
import sum3.dao.entity.InputDataEntity;
import sum3.dao.entity.RequestHistoryEntity;
import sum3.dao.entity.ResultDataEntity;

public class MapRequestToEntity {

	public static ResultDataEntity mapOutputToResultEntity(Long resultantNumber1, Long resultantNumber2,
			Long resultantNumber3, Long requestHistoryId) {
		ResultDataEntity resultEntity = new ResultDataEntity();
		resultEntity.setResultNumber1(resultantNumber1);
		resultEntity.setResultNumber2(resultantNumber2);
		resultEntity.setResultNumber3(resultantNumber3);
		resultEntity.setRequestHistoryId(requestHistoryId);
		return resultEntity;

	}

	public static List<InputDataEntity> mapRequestParamToInputResultMappingEntity(List<Long> numberList,
			Long requestHistoryId) {
		List<InputDataEntity> inputDataEntityListt = new ArrayList<>();
		for (Long number : numberList) {
			InputDataEntity inputDataEntity = new InputDataEntity();
			inputDataEntity.setNumberLookFrom(number);
			inputDataEntity.setRequestHistoryId(requestHistoryId);
			inputDataEntityListt.add(inputDataEntity);
		}
		return inputDataEntityListt;
	}

	public static RequestHistoryEntity mapToRequestHistoryEntity(Long targetNumber) {
		RequestHistoryEntity requestHistoryEntity = new RequestHistoryEntity();
		requestHistoryEntity.setTargetNumber(targetNumber);
		requestHistoryEntity.setCreatedOn(new Date());
		return requestHistoryEntity;
	}

	public static HistoryResponse mapGetHistoryByIdEntityToHistoryResponse(RequestHistoryEntity requestHistoryEntity,
			List<InputDataEntity> inputDataEntityList, ResultDataEntity resultEntity, HistoryResponse response) {

		response.setTargetNumber(requestHistoryEntity.getTargetNumber());
		response.setResultFirst(resultEntity.getResultNumber1());
		response.setResultSecond(resultEntity.getResultNumber2());
		response.setResultThird(resultEntity.getResultNumber3());
		response.setHistoryResponseStatus("true");
		List<Long> requestNumberList = new ArrayList<>();
		for(InputDataEntity inputNumber : inputDataEntityList)
		{
			requestNumberList.add(inputNumber.getNumberLookFrom());
		}
		response.setRequestNumberList(requestNumberList);
		return response;
	}
}
