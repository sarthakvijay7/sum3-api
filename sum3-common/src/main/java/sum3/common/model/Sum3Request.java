package sum3.common.model;

import java.io.Serializable;
import java.util.List;

public class Sum3Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Long> numbersList;
	private Long targetNumber;
	
	public List<Long> getNumbersList() {
		return numbersList;
	}
	public void setNumbersList(List<Long> numbersList) {
		this.numbersList = numbersList;
	}
	public Long getTargetNumber() {
		return targetNumber;
	}
	public void setTargetNumber(Long targetNumber) {
		this.targetNumber = targetNumber;
	}
	@Override
	public String toString() {
		return "Sum3Request [numbersList=" + numbersList + ", targetNumber=" + targetNumber + "]";
	}
	
	
	
}
