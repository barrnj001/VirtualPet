package virtualpet;

import java.util.HashMap;

public class VirtualPet {

	private int hunger = 5;

	private int litterBox = 5;

	private int restless = 5;

	private int sleep = 5;

	public Integer getSleep() {
		return sleep;
	}

	public Integer getHunger() {
		return hunger;
	}

	public Integer getPotty() {
		return litterBox;
	}
	

	public void feedPet(int petFood) {
		hunger = hunger - petFood;

	}

	public void useLitterBox(int satisfaction) {
		litterBox = litterBox + 2;
	}

	public Integer getRestless() {
		return restless;
	}

	public void cleanLitterBox(int cleanliness) {
		litterBox = litterBox - 3;
	}

	public void getBored(int boredom) {
		restless = restless + boredom;
		
	}

	public void getHungry(int hungry) {
		hunger = hunger + hungry;
		
	}

	public void playtime(int scamper) {
		restless = restless - scamper;
		
	}
	
	public void tick() {
		hunger = hunger + 1;
		litterBox = litterBox +1;
		restless = restless + 1;
		sleep = sleep + 1;
	}

	public void getSleepy(int tired) {
		sleep += tired;
		
	}

	public void getRest(int alert) {
		sleep -= alert;
		
	}

}
