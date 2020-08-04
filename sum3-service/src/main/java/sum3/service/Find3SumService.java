package sum3.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Sum3Response find3NumbersSumEqualToGivenNumber(Sum3Request request) {
		logger.debug("Inside Find3SumService -> find3NumbersSumEqualToGivenNumber method, importing for Sum3Request: "
				+ request);

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
		try {
			Long requestHistoryId = sum3requestHistoryService.createRequestHistory(targetNumber);

			sum3InputService.createInput(numberList, requestHistoryId);

			ResultDataEntity resultEntity = MapRequestToEntity.mapOutputToResultEntity(resultNumberList.get(0),
					resultNumberList.get(1), resultNumberList.get(2), requestHistoryId);

			resultService.createResult(resultEntity);
		} catch (Exception e) {
			logger.error("Error occured in Find3SumService -> find3NumbersSumEqualToGivenNumber method", e);
			response.setStatusResponse(e.getMessage());
			return response;
		}

		response.setResultNumberList(resultNumberList);
		response.setStatusResponse("true");
		return response;
	}

	@Override
	public HistoryResponse getHistoryById(Long id) {
		logger.debug("Inside Find3SumService -> getHistoryById method, importing for Sum3Request: id"+ id);

		HistoryResponse response = new HistoryResponse();
		RequestHistoryEntity requestHistoryEntity = new RequestHistoryEntity();
		List<InputDataEntity> inputDataEntityList = new ArrayList<InputDataEntity>();
		ResultDataEntity resultEntity = new ResultDataEntity();

		try {
			requestHistoryEntity = sum3requestHistoryService.getRequestHistoryById(id);

			inputDataEntityList = sum3InputService.getInputDataByRequestHistoryId(requestHistoryEntity.getId());

			resultEntity = resultService.getResultDataByRequestHistoryId(requestHistoryEntity.getId());
		} catch (Exception e) {
			logger.error("Error occured in Find3SumService -> getHistoryById method", e);
			response.setHistoryResponseStatus("Error while fetching details from the db");
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
			if (numbersFound)
				break;
		}

		return numbersFound;

	}

}
