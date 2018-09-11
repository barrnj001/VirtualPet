package virtualpet;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetApp {

	public static void main(String[] args) {
		System.out.println("Please pick a name for your cat.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String Name = scanner.nextLine();

		System.out.println("That is a very nice name! Here's how " + Name + " is doing.");

		VirtualPet catHunger = new VirtualPet();
		int hungerBefore = catHunger.getHunger();

		VirtualPet catBladder = new VirtualPet();
		int bladderBefore = catBladder.getPotty();

		VirtualPet catRestless = new VirtualPet();
		Integer restlessBefore = catRestless.getRestless();

		VirtualPet catSleep = new VirtualPet();
		Integer sleepBefore = catSleep.getSleep();

		String userInput = "";
		while (!userInput.equals("5")) {
			
			HashMap<String, Integer> catStats = new HashMap<String, Integer>();
			catStats.put("1. Hunger", hungerBefore);
			catStats.put("2. Litterbox", bladderBefore);
			catStats.put("3. Restlessness", restlessBefore);
			catStats.put("4. Sleep", sleepBefore);
			

			for (Map.Entry<String, Integer> entry : catStats.entrySet()) {
				System.out.println(entry.getKey() + " is " + entry.getValue());
			}
			System.out.println("5. End Game");

			System.out.println("Which need would you like to care for?");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {
				catHunger.feedPet(5);
				catBladder.useLitterBox(2);
				hungerBefore = catHunger.getHunger();
				bladderBefore = catBladder.getPotty();

				System.out.println("You feed " + Name + " two cups of food! Better clean that litterbox.");
			} else if (userInput.equals("2")) {
				catBladder.cleanLitterBox(5);
				bladderBefore = catBladder.getPotty();
				catHunger.getHungry(1);
				hungerBefore = catHunger.getHunger();

				System.out.println("You clean " + Name + "'s litterbox. Simply more room for food now!");
			} else if (userInput.equals("3")) {
				catRestless.playtime(5);
				catSleep.getSleepy(1);
				sleepBefore = catSleep.getSleep();
				restlessBefore = catRestless.getRestless();

				System.out.println("You play with " + Name + " and have a great time! They look tired, though.");
			} else if (userInput.equals("4")) {
				catSleep.getRest(5);
				catHunger.getHungry(1);
				hungerBefore = catHunger.getHunger();
				sleepBefore = catSleep.getSleep();
				
				System.out.println("You give " + Name + " some time to themselves. They go to sleep but wake up hungrier than before!");
			}

			catHunger.tick();
			catRestless.tick();
			catBladder.tick();
			catSleep.tick();
			sleepBefore = catSleep.getSleep();
			restlessBefore = catRestless.getRestless();
			bladderBefore = catBladder.getPotty();
			hungerBefore = catHunger.getHunger();

		}

		System.out.println("Thanks for playing!");

	}

}
