package sum3.common.interfaces;

import sum3.common.model.HistoryResponse;
import sum3.common.model.Sum3Request;
import sum3.common.model.Sum3Response;

public interface IFind3SumService {

	Sum3Response find3NumbersSumEqualToGivenNumber(Sum3Request request);

	HistoryResponse getHistoryById(Long id);

}
