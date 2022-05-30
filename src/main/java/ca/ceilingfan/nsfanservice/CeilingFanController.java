package ca.ceilingfan.nsfanservice;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;

/**
 * This controller class provides service end point to retrieve and save the state of ceiling fan
 * @author atif_majeed
 *
 */
@RestController
public class CeilingFanController {
	
	@Autowired
	private FanStateRepository fanStateRepository;
	
	/**
	 * This method returns the state of ceiling fan to initialize the parameters on the UI 
	 * @return FanState - a class encapsulating the state of a fan
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/fan-state")
	public Optional<FanState> getFanState() {
		return fanStateRepository.findById(Long.valueOf(1));
	}
	
	/**
	 * This method saves the state of ceiling fan received from the UI 
	 * @return FanState - updated state of a fan
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/fan-state", method = RequestMethod.PUT)
	public @ResponseBody FanState updateFanState(@Valid @RequestBody FanState fanState){
	 return fanStateRepository.save(fanState);
	}
	
	/**
	 * Handles error if incoming request contains bad data. Returns a validation error response (Status code 400)
	 * with the field that is invalid
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}	
}
