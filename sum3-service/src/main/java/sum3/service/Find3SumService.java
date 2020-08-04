package sum3.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.common.interfaces.IFind3SumService;
import sum3.common.model.HistoryResponse;
import sum3.common.model.Sum3Request;
import sum3.common.model.Sum3Response;
import sum3.dao.entity.InputDataEntity;
import sum3.dao.entity.RequestHistoryEntity;
import sum3.dao.entity.ResultDataEntity;
import sum3.service.interfaces.ISum3InputService;
import sum3.service.interfaces.ISum3RequestHistoryService;
import sum3.service.interfaces.ISum3ResultService;

@Service
@Transactional
public class Find3SumService implements IFind3SumService {

	@Autowired
	ISum3ResultService resultService;

	@Autowired
	ISum3InputService sum3InputService;

	@Autowired
	ISum3RequestHistoryService sum3requestHistoryService;

	// Logger logger = Logger.getLogger(getClass());

	@Override
	public Sum3Response find3NumbersSumEqualToGivenNumber(Sum3Request request) {
//		logger.debug("Inside Find3SumService -> find3NumbersSumEqualToGivenNumber method, importing for Sum3Request: "
//				+ request);

		Sum3Response response = new Sum3Response();

		if (request.getTargetNumber() == null) {
			response.setStatusResponse("target number is not valid");
			return response;
		}
		if (request.getNumbersList().size() < 3) {
			response.setStatusResponse("The size of the input list of number is not sufficient");
			return response;
		}

		List<Long> resultNumberList = new ArrayList<>();
		List<Long> numberList = request.getNumbersList();
		Long targetNumber = request.getTargetNumber();
		Boolean numbersFound = calculateNumbersHavingSumEqualToTarger(resultNumberList, numberList, targetNumber);

		if (!numbersFound) {
			response.setStatusResponse("There dont exist any combination which sums up equal to a target number");
			return response;
		}
		Long requestHistoryId = sum3requestHistoryService.createRequestHistory(targetNumber);

		if (requestHistoryId.equals(-1l)) {
			response.setStatusResponse("Error while saving details in request history db");
			return response;
		}

		List<InputDataEntity> inputDataEntityList = sum3InputService.createInput(numberList, requestHistoryId);
		if (inputDataEntityList == null || inputDataEntityList.size() < 1) {
			response.setStatusResponse("Error while saving input details in input_data_log db");
			return response;
		}

		ResultDataEntity resultEntity = MapRequestToEntity.mapOutputToResultEntity(resultNumberList.get(0),
				resultNumberList.get(1), resultNumberList.get(2), requestHistoryId);

		ResultDataEntity resultEntityResponse = resultService.createResult(resultEntity);
		if (resultEntityResponse == null) {
			response.setStatusResponse("Error while saving result details in result_data_log db");
			return response;
		}

		response.setResultNumberList(resultNumberList);
		response.setStatusResponse("true");
		return response;
	}

	@Override
	public HistoryResponse getHistoryById(Long id) {
		RequestHistoryEntity requestHistoryEntity = sum3requestHistoryService.getRequestHistoryById(id);
		HistoryResponse response = new HistoryResponse();

		if (requestHistoryEntity == null) {
			response.setHistoryResponseStatus("Error while fetching request details");
			return response;
		}

		List<InputDataEntity> inputDataEntityList = sum3InputService
				.getInputDataByRequestHistoryId(requestHistoryEntity.getId());
		if (inputDataEntityList == null) {

			response.setHistoryResponseStatus("Error while fetching input details");
			return response;
		}

		ResultDataEntity resultEntity = resultService.getResultDataByRequestHistoryId(requestHistoryEntity.getId());
		if (resultEntity == null) {
			response.setHistoryResponseStatus("Error while fetching result details");
			return response;
		}
		return MapRequestToEntity.mapGetHistoryByIdEntityToHistoryResponse(requestHistoryEntity, inputDataEntityList,
				resultEntity, response);
	}

	public boolean calculateNumbersHavingSumEqualToTarger(List<Long> resultNumberList, List<Long> numberList,
			Long targetNumber) {
		Boolean numbersFound = false;
		for (int i = 0; i < numberList.size() - 2; i++) {

			HashSet<Long> s = new HashSet<>();
			Long present_sum = targetNumber - numberList.get(i);
			for (int j = i + 1; j < numberList.size(); j++) {
				if (s.contains(present_sum - numberList.get(j))) {
					resultNumberList.add(numberList.get(i));
					resultNumberList.add(numberList.get(j));
					resultNumberList.add(present_sum - numberList.get(j));
					numbersFound = true;
					break;
				}
				s.add(numberList.get(j));
			}
			if(numbersFound)
				break;
		}

		return numbersFound;

	}

}
