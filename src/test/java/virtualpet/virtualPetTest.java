package virtualpet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void shouldBeAbleToEat() {
		VirtualPet cat = new VirtualPet();
		cat.feedPet(2);
		Integer hunger = cat.getHunger();
		assertTrue(hunger.equals(Integer.valueOf(3)));
	}

	@Test
	public void shouldBeAbleToUseLitterBox() {
		VirtualPet cat = new VirtualPet();
		cat.useLitterBox(3);
		Integer litterBox = cat.getPotty();
		assertTrue(litterBox.equals(Integer.valueOf(7)));
	}

	@Test
	public void shouldBeAbleToTick() {
		// hunger is at 3, litterBox at 1
		VirtualPet catHunger = new VirtualPet();
		catHunger.tick();
		Integer hunger = catHunger.getHunger();
		assertTrue(hunger.equals(Integer.valueOf(6)));
		// successful tick adds tick to hunger and bladder! :D
	}

}
