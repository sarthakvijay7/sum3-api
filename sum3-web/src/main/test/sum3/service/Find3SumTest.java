package sum3.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sum3.common.interfaces.IFind3SumService;
import sum3.common.model.Sum3Request;
import sum3.common.model.Sum3Response;

public class Find3SumTest {

@Autowired
IFind3SumService find3SumService;
	
	@Test
	void test3Sum()
	{
		List<Long> numberList = new ArrayList<>(Arrays.asList(3l,4l,9l,2l));
		Long targerNumber = 16l;
		List<Long> resultList = new ArrayList<Long>(Arrays.asList(3l,4l,9l));
		Sum3Request request= new Sum3Request();
		Sum3Response response=find3SumService.find3NumbersSumEqualToGivenNumber(request);
		assertEquals(numberList, response.getResultNumberList());
	}
}
