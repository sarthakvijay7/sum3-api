package sum3.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sum3.common.interfaces.IFind3Sum;
import sum3.common.model.Sum3Request;
import sum3.dao.entity.ResultEntity;
import sum3.service.interfaces.IInputResultMappingService;
import sum3.service.interfaces.IResultService;

@Service
public class Find3Sum implements IFind3Sum{

	@Autowired
	IResultService resultService;
	
	@Autowired
	IInputResultMappingService inputResultMappingService;
	
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
		ResultEntity resultEntity=MapRequestToEntity.mapOutputToResultEntity(resultantNumber1, resultantNumber2, resultantNumber3, targetNumber);
	  
		ResultEntity resultEntityResponse=	resultService.createResult(resultEntity);
	   
		inputResultMappingService.createInputResultMapping(numberList, resultEntityResponse.getId());
	   
		return null;
	}

}
