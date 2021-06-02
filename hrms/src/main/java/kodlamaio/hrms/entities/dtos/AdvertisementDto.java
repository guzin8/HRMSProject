package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto {
	
	private int id;
	private String companyName;
	//private String jobPosition;
	private int numberOFHires;
	private LocalDate createdDate;
	private LocalDate deadline;

}
