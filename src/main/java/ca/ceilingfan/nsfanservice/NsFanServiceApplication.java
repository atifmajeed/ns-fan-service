package ca.ceilingfan.nsfanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class starts the application that contains a micro service to get and save the state of a ceiling fan 
 * such as its direction and speed as received from a client application
 * @author atif_majeed
 *
 */
@SpringBootApplication
public class NsFanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsFanServiceApplication.class, args);
	}

}
