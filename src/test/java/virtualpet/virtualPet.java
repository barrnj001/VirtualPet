package virtualpet;

import java.math.BigDecimal;

public class virtualPet {

	private BigDecimal status = new BigDecimal(0);

	
	public BigDecimal getStatus() {
		return status;
	}

	public virtualPet (int startingAmount) {
		status = status.subtract(new BigDecimal(startingAmount));

	}

	public void feedPet(int newfood) {
		status = status.subtract(new BigDecimal(newfood));
		
	}

}
