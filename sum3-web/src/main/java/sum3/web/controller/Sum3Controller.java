package sum3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sum3.common.interfaces.IFind3SumService;
import sum3.common.model.HistoryResponse;
import sum3.common.model.Sum3Request;
import sum3.common.model.Sum3Response;

@RestController
@RequestMapping("/api")
public class Sum3Controller {

	@Autowired
	IFind3SumService find3Sum;

	@PostMapping(path = "/find3Sum")
	public @ResponseBody Sum3Response find3sum(@RequestBody Sum3Request request) {
		return find3Sum.find3NumbersSumEqualToGivenNumber(request);
	}

	@PostMapping(path = "/getHistoryById")
	public @ResponseBody HistoryResponse getHistoryById(@RequestParam Long id) {
		return find3Sum.getHistoryById(id);
	}

}
