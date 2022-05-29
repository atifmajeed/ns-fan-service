package ca.ceilingfan.nsfanservice;

/**
 * This class encapsulates state of a ceiling fan such as its direction and speed
 * @author atif_majeed
 *
 */
public class FanState {
	
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
		return "FanState [speed=" + speed + ", reverse=" + reverse + "]";
	}
}
