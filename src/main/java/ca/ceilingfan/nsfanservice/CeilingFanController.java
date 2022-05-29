package ca.ceilingfan.nsfanservice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class provides service end ponts for GET and PUT to retrieve and save the state of ceiling fan
 * @author atif_majeed
 *
 */
@RestController
public class CeilingFanController {
	
	/**
	 * This method returns the state of ceiling fan to initialize the parameters on the UI 
	 * @return FanState - a class encapsulating the state of a fan
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/fan-state")
	public FanState getFanState() {
		return new FanState();
	}
	
	/**
	 * This method saves the state of ceiling fan received from the UI 
	 * @return FanState - updated state of a fan
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/fan-state", method = RequestMethod.PUT)
	public @ResponseBody FanState updateFanState(@RequestBody FanState fanState){
	 System.out.println(fanState.toString());
	 return fanState;
	}
}
