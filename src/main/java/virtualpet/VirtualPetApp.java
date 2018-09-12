package virtualpet;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetApp {

	public static void main(String[] args) {
		System.out.println("Please pick a name for your cat.");
		@SuppressWarnings("resource")
		//i don't like the yellow bar on the side :(
		Scanner scanner = new Scanner(System.in);
		String Name = scanner.nextLine();
		//new scanner to take user input.

		System.out.println("That is a very nice name! Here's how " + Name + " is doing.");
		//creating the different needs.
		
		VirtualPet catHunger = new VirtualPet();
		int hunger = catHunger.getHunger();

		VirtualPet catBladder = new VirtualPet();
		int bladder = catBladder.getPotty();

		VirtualPet catRestless = new VirtualPet();
		Integer restless = catRestless.getRestless();

		VirtualPet catSleep = new VirtualPet();
		Integer sleep = catSleep.getSleep();

		String userInput = "";
		//game loop begins!
		
		while (!userInput.equals("5")) {
			
			//while the user isn't entering 5, the following code happens
			
			HashMap<String, Integer> catStats = new HashMap<String, Integer>();
			catStats.put("1. Hunger", hunger);
			catStats.put("2. Litterbox", bladder);
			catStats.put("3. Restlessness", restless);
			catStats.put("4. Sleep", sleep);
			

			for (Map.Entry<String, Integer> entry : catStats.entrySet()) {
				System.out.println(entry.getKey() + " is " + entry.getValue());
			}
			System.out.println("5. End Game");
			//just a way to list the end scenario outside of the hashmap.

			System.out.println("Which need would you like to care for?");

			userInput = scanner.nextLine();
			//creating the user input

			if (userInput.equals("1")) {
				catHunger.feedPet(5);
				catBladder.useLitterBox(2);
				hunger = catHunger.getHunger();
				bladder = catBladder.getPotty();

				System.out.println("You feed " + Name + " two cups of food! Better clean that litterbox.");
			} else if (userInput.equals("2")) {
				catBladder.cleanLitterBox(5);
				bladder = catBladder.getPotty();
				catHunger.getHungry(1);
				hunger = catHunger.getHunger();

				System.out.println("You clean " + Name + "'s litterbox. Simply more room for food now!");
			} else if (userInput.equals("3")) {
				catRestless.playtime(5);
				catSleep.getSleepy(1);
				sleep = catSleep.getSleep();
				restless = catRestless.getRestless();

				System.out.println("You play with " + Name + " and have a great time! They look tired, though.");
			} else if (userInput.equals("4")) {
				catSleep.getRest(5);
				catHunger.getHungry(1);
				hunger = catHunger.getHunger();
				sleep = catSleep.getSleep();
				
				System.out.println("You give " + Name + " some time to themselves. "
						+ "They go to sleep but wake up hungrier than before!");
				//the previous code simply has the user effect each need, while also inadvertently changing other needs. 
				//hunger increases litter box, vice-versa.
				//sleep affects hunger
				//playing affects sleep and so on
			}

			catHunger.tick();
			catRestless.tick();
			catBladder.tick();
			catSleep.tick();
			sleep = catSleep.getSleep();
			restless = catRestless.getRestless();
			bladder = catBladder.getPotty();
			hunger = catHunger.getHunger();
			
			//i'll be frank, i struggled for the longest trying to get the game to tick up needs.
			//in the end, my solution was to tick up each need individually, and then have the game re-check the needs
			//prior, the game would only tick up a need once u had entered its number which is not what i wanted
			//but now the loop will check to see if a need has changed regardless of the number
			//(it has, the tick method makes sure of that)
			//and then it updates the hashmap! yay!

		}

		System.out.println("Thanks for playing!");
		//the user has pressed 5 and ended the game. :3

	}

}
