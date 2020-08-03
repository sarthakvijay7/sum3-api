package sum3.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sum3.common.interfaces.IFind3Sum;
import sum3.common.model.Sum3Request;

@RestController
@RequestMapping("/api")
public class Sum3Controller {
 
	@Autowired
	IFind3Sum find3Sum;
	
	  @PostMapping(path = "/find3Sum")
	public @ResponseBody List<Long> find3sum(
		      @RequestBody Sum3Request request){
		    return find3Sum.find3NumbersSumEqualToGivenNumber(request);
		  }

}
