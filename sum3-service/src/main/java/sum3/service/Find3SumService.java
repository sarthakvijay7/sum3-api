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
public class Find3SumService implements IFind3SumService{

	@Autowired
	ISum3ResultService resultService;
	
	@Autowired
	ISum3InputService sum3InputService;
	
	@Autowired
	ISum3RequestHistoryService sum3requestHistoryService;
	
	@Override
	@Transactional
	public Sum3Response find3NumbersSumEqualToGivenNumber(Sum3Request request) {
		
		
		Sum3Response response = new Sum3Response();
		
		if(request.getNumbersList().size()<3)
		{
		response.setStatusResponse("The size of the input list of number is not sufficient");
		return response;
		}
		
		List<Long> resultNumberList = new ArrayList<>();
		List<Long> numberList = request.getNumbersList();
        Long targetNumber=request.getTargetNumber();
        Boolean numbersFound = false;
		for (int i = 0; i < numberList.size() - 2; i++) { 
			  
            // Find pair in subarray A[i+1..n-1] 
            // with sum equal to sum - A[i] 
            HashSet<Long> s = new HashSet<>(); 
            Long curr_sum = targetNumber - numberList.get(i); 
            for (int j = i + 1; j < numberList.size(); j++) { 
                if (s.contains(curr_sum - numberList.get(j))) { 
                resultNumberList.add(numberList.get(i));
                resultNumberList.add(numberList.get(j));
                resultNumberList.add(curr_sum-numberList.get(j));
                numbersFound=true;
                } 
                s.add(numberList.get(j)); 
            } 
        } 
		if(!numbersFound)
		{
			response.setStatusResponse("There dont exist any combination which sums up equal to a target number");
			return response;
		}
		Long requestHistoryId = sum3requestHistoryService.createRequestHistory(targetNumber);
		
		sum3InputService.createInput(numberList, requestHistoryId);
		
		ResultDataEntity resultEntity=MapRequestToEntity.mapOutputToResultEntity(resultNumberList.get(0),resultNumberList.get(1), resultNumberList.get(2),requestHistoryId);
	  
		ResultDataEntity resultEntityResponse=	resultService.createResult(resultEntity);
		
	   	   response.setResultNumberList(resultNumberList);
	   	   response.setStatusResponse("true");
		return response;
	}

	@Override
	public HistoryResponse getHistoryById(Long id)
	{
		RequestHistoryEntity requestHistoryEntity=sum3requestHistoryService.getRequestHistoryById(id);
		
		List<InputDataEntity> inputDataEntityList=sum3InputService.getInputDataByRequestHistoryId(requestHistoryEntity.getId());
		
		ResultDataEntity resultEntity=resultService.getResultDataByRequestHistoryId(requestHistoryEntity.getId());
		
		return MapRequestToEntity.mapGetHistoryByIdEntityToHistoryResponse(requestHistoryEntity, inputDataEntityList, resultEntity);
	}
	
}
