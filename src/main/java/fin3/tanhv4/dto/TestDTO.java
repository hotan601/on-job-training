package fin3.tanhv4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TestDTO {
	private String testID;
	private String testName;
	private int testAge;
	private String testAddress;


}
