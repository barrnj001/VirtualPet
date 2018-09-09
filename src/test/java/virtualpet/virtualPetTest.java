package virtualpet;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class virtualPetTest {
	@Test
	public void shouldBeAbleToEat() {
		virtualPet hunger = new virtualPet(500);
		hunger.feedPet(200);
		BigDecimal status = hunger.getStatus();
		assertTrue(status.equals(BigDecimal.valueOf(300)));
	}
	

}
