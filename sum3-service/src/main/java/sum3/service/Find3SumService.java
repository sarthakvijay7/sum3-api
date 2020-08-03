package sum3.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.common.interfaces.IFind3Sum;
import sum3.common.model.Sum3Request;
import sum3.dao.entity.InputDataEntity;
import sum3.dao.entity.RequestHistoryEntity;
import sum3.dao.entity.ResultDataEntity;
import sum3.service.interfaces.ISum3InputService;
import sum3.service.interfaces.ISum3RequestHistoryService;
import sum3.service.interfaces.ISum3ResultService;

@Service
public class Find3SumService implements IFind3Sum{

	@Autowired
	ISum3ResultService resultService;
	
	@Autowired
	ISum3InputService sum3InputService;
	
	@Autowired
	ISum3RequestHistoryService sum3requestHistoryService;
	
	@Override
	public List<Long> find3NumbersSumEqualToGivenNumber(Sum3Request request) {
		
		Long resultantNumber1=0l;
		Long resultantNumber2=0l;
		Long resultantNumber3=0l;
		List<Long> numberList = request.getNumbersList();
        Long targetNumber=request.getTargetNumber();
		for (int i = 0; i < numberList.size() - 2; i++) { 
			  
            // Find pair in subarray A[i+1..n-1] 
            // with sum equal to sum - A[i] 
            HashSet<Long> s = new HashSet<>(); 
            Long curr_sum = targetNumber - numberList.get(i); 
            for (int j = i + 1; j < numberList.size(); j++) { 
                if (s.contains(curr_sum - numberList.get(j))) { 
                	resultantNumber1=numberList.get(i);
                	resultantNumber2=numberList.get(j);
                	resultantNumber3=curr_sum-numberList.get(j);
                } 
                s.add(numberList.get(j)); 
            } 
        } 
		Long requestHistoryId = sum3requestHistoryService.createRequestHistory(targetNumber);
		
		sum3InputService.createInput(numberList, requestHistoryId);
		
		ResultDataEntity resultEntity=MapRequestToEntity.mapOutputToResultEntity(resultantNumber1, resultantNumber2, resultantNumber3, requestHistoryId);
	  
		ResultDataEntity resultEntityResponse=	resultService.createResult(resultEntity);
	   	   
		return null;
	}

	@Override
	public void getHistoryById(Long id)
	{
		RequestHistoryEntity requestHistoryEntity=sum3requestHistoryService.getRequestHistoryById(id);
		
		List<InputDataEntity> inputDataEntityList=sum3InputService.getInputDataByRequestHistoryId(requestHistoryEntity.getId());
		
		ResultDataEntity resultEntity=resultService.getResultDataByRequestHistoryId(requestHistoryEntity.getId());
	}
	
}
