package sum3.common.model;

import java.io.Serializable;
import java.util.List;

public class HistoryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Long> requestNumberList;
	private Long targetNumber;
	private Long resultFirst;
	private Long resultSecond;
	private Long resultThird;
	private String historyResponseStatus;
	
	public String getHistoryResponseStatus() {
		return historyResponseStatus;
	}
	public void setHistoryResponseStatus(String historyResponseStatus) {
		this.historyResponseStatus = historyResponseStatus;
	}
	public List<Long> getRequestNumberList() {
		return requestNumberList;
	}
	public void setRequestNumberList(List<Long> requestNumberList) {
		this.requestNumberList = requestNumberList;
	}
	public Long getTargetNumber() {
		return targetNumber;
	}
	public void setTargetNumber(Long targetNumber) {
		this.targetNumber = targetNumber;
	}
	public Long getResultFirst() {
		return resultFirst;
	}
	public void setResultFirst(Long resultFirst) {
		this.resultFirst = resultFirst;
	}
	public Long getResultSecond() {
		return resultSecond;
	}
	public void setResultSecond(Long resultSecond) {
		this.resultSecond = resultSecond;
	}
	public Long getResultThird() {
		return resultThird;
	}
	public void setResultThird(Long resultThird) {
		this.resultThird = resultThird;
	}
	
	@Override
	public String toString() {
		return "HistoryResponse [requestNumberList=" + requestNumberList + ", targetNumber=" + targetNumber
				+ ", resultFirst=" + resultFirst + ", resultSecond=" + resultSecond + ", resultThird=" + resultThird
				+ ", historyResponseStatus=" + historyResponseStatus + "]";
	}

	
}
