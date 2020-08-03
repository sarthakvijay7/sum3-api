package sum3.common.model;

import java.io.Serializable;
import java.util.List;

public class Sum3Response implements Serializable{

	private List<Long> resultNumberList;
	private String statusResponse;
	public List<Long> getResultNumberList() {
		return resultNumberList;
	}
	public void setResultNumberList(List<Long> resultNumberList) {
		this.resultNumberList = resultNumberList;
	}
	public String getStatusResponse() {
		return statusResponse;
	}
	public void setStatusResponse(String statusResponse) {
		this.statusResponse = statusResponse;
	}
	@Override
	public String toString() {
		return "Sum3Response [resultNumberList=" + resultNumberList + ", statusResponse=" + statusResponse + "]";
	}
	
}
