package ca.ceilingfan.nsfanservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int speed = 0;
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
