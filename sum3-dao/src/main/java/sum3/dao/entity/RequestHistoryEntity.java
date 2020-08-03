package sum3.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "request_history")
public class RequestHistoryEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long targetNumber;
	private Date createdOn;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTargetNumber() {
		return targetNumber;
	}
	public void setTargetNumber(Long targetNumber) {
		this.targetNumber = targetNumber;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "RequestHistoryEntity [id=" + id + ", targetNumber=" + targetNumber + ", createdOn=" + createdOn + "]";
	}
	
	
	
}
