package virtualpet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void shouldBeAbleToEat() {
		VirtualPet cat = new VirtualPet(0);
		cat.feedPet(2);
		Integer hunger = cat.getHunger();
		assertTrue(hunger.equals(Integer.valueOf(3)));
	}
	
	@Test
	public void shouldBeAbleToUseLitterBox() {
		VirtualPet cat = new VirtualPet(0);
		cat.useLitterBox(3);
		Integer litterBox = cat.getPotty();
		assertTrue(litterBox.equals(Integer.valueOf(7)));
	}
	@Test
	public void shouldBeAbleToGetStatus() {
		VirtualPet catHunger = new VirtualPet(0);
		catHunger.feedPet(2);
		Integer hunger = catHunger.getHunger();
		
		VirtualPet catNeeds = new VirtualPet(0);
		catNeeds.useLitterBox(3);
		Integer litterBox = catNeeds.getPotty();
		
		VirtualPet catStatus = new VirtualPet(0);
		catStatus.getStatus();
		Integer status = litterBox + hunger;
		assertTrue(status.equals(Integer.valueOf(10)));
	}
	@Test
	public void shouldBeAbleToTick () {
		//hunger is at 3, litterBox at 1
		VirtualPet catHunger = new VirtualPet(0);
		catHunger.tick();
		Integer hunger = catHunger.getHunger();
		assertTrue(hunger.equals(Integer.valueOf(6)));
	//successful tick adds tick to hunger and bladder! :D
	}

}
