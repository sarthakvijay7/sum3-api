package sum3.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_data_log")
public class InputDataEntity implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long requestHistoryId;
	private Long numberLookFrom;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRequestHistoryId() {
		return requestHistoryId;
	}
	public void setRequestHistoryId(Long requestHistoryId) {
		this.requestHistoryId = requestHistoryId;
	}
	public Long getNumberLookFrom() {
		return numberLookFrom;
	}
	public void setNumberLookFrom(Long numberLookFrom) {
		this.numberLookFrom = numberLookFrom;
	}
	@Override
	public String toString() {
		return "InputResultMappingEntity [id=" + id + ", requestHistoryId=" + requestHistoryId + ", numberLookFrom="
				+ numberLookFrom + "]";
	}
	
	
}
