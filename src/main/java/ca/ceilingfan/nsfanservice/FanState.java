package ca.ceilingfan.nsfanservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

/**
 * This class encapsulates state of a ceiling fan such as its direction and speed
 * @author atif_majeed
 *
 */
@Entity
@Table(name="FAN_STATE")
public class FanState {
	@Id
	private long id = 1;
	
	@Min(value = 0L, message = "Speed must be between 0 and 3")
	@Max(value = 3L, message = "Speed must be between 0 and 3")
	private int speed = 0;
	
	@NotNull
	private boolean reverse = false;
	
	/**
	 * default constructor
	 */
	public FanState() {
	}
	
	/**
	 * constructor to initialize the class give state parameters
	 * @param fanSpeed
	 * @param reversed true if fan is in reverse direction
	 */
	public FanState(int fanSpeed, boolean reversed) {
		this.speed = fanSpeed;
		this.reverse = reversed;
	}
	
	public long getId() {
		return id;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isReverse() {
		return reverse;
	}
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	@Override
	public String toString() {
		return "FanState [id=" + id +", speed=" + speed + ", reverse=" + reverse + "]";
	}
}
