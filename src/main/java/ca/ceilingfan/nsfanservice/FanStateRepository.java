package ca.ceilingfan.nsfanservice;

import org.springframework.data.repository.CrudRepository;

/**
 * This class abstracts access to a database table to show an example of data acess. 
 * In this case, it provides access to fan_state table that save state data
 * @author atif_majeed
 *
 */
public interface FanStateRepository extends CrudRepository<FanState, Long> {

}