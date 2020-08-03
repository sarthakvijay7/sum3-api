package sum3.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "result_data_log")
public class ResultEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long resultNumber1;
	private Long resultNumber2;
	private Long resultNumber3;
	private Long sumNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getResultNumber1() {
		return resultNumber1;
	}
	public void setResultNumber1(Long resultNumber1) {
		this.resultNumber1 = resultNumber1;
	}
	public Long getResultNumber2() {
		return resultNumber2;
	}
	public void setResultNumber2(Long resultNumber2) {
		this.resultNumber2 = resultNumber2;
	}
	public Long getResultNumber3() {
		return resultNumber3;
	}
	public void setResultNumber3(Long resultNumber3) {
		this.resultNumber3 = resultNumber3;
	}
	public Long getSumNumber() {
		return sumNumber;
	}
	public void setSumNumber(Long sumNumber) {
		this.sumNumber = sumNumber;
	}
	@Override
	public String toString() {
		return "ResultEntity [id=" + id + ", resultNumber1=" + resultNumber1 + ", resultNumber2=" + resultNumber2
				+ ", resultNumber3=" + resultNumber3 + ", sumNumber=" + sumNumber + "]";
	}

	
}
