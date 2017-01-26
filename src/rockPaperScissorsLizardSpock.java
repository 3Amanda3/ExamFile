
import java.util.Random;
import java.util.Scanner;

	/**
 	* Amanda Schepp
 	* Mr.Hardman
 	*Final project, to play rock, paper, scissors, lizard, spock with the computer.
   	* January 26th
   	*/
public class rockPaperScissorsLizardSpock {

	private static int round = 0;
	private static int won = 0;
	private static int lost = 0;
	private static int draw = 0;
	private static double per;

	private static int compInput;
	private static String uInput = "";
	private static int[] uInputArray = new int[5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game();
	}

	/**
	 * Game runs the game and calculates wins, losses and rounds.
	 * @param no parameters
	 * @retun game does not return anything
	 **/
	public static void Game() {

		Scanner userInput = new Scanner(System.in);
		Random randGenerator = new Random();
		int indexOfMax = 0;

		/**
		 * compInput number actions 
		 * Rock = 1 
		 * Paper = 2 
		 * Scissors = 3 
		 * Lizard = 4
		 * Spock = 5
		 **/

		System.out.println("Please enter, Rock, Paper, Scissors, Lizard, or Spock!");
		System.out.println("Type end when you are finished playing to get your final scores!");

		do {
			

			// computers throw down choice generator
			
			compInput = randGenerator.nextInt(5) + 1;

			// if round %10 = 0 will run this code			
			if (round % 10 == 0 && round > 0) {

				System.out.println("");
				System.out.println("Type stats to see your current game progress.");
				System.out.println("or continue onto round " + round);
				uInput = userInput.next();
				System.out.println("");

				// Game stats				
				if (uInput.equalsIgnoreCase("stats")) {

					System.out.println(String.format("%-55s " + won + " games", "You have won a current total of: "));
					System.out.println(String.format("%-55s " + lost + " games", "You have lost a current total of: "));
					System.out.println(String.format("%-55s " + draw + " games", "You have tied a current total of: "));
					per = (won / (round * 1.0)) * 100;
					System.out.println(String.format("%-55s " + per + "%% chance of wining the game!", "You currently have a: "));
					
					//using the array to display wich opton was picked the most
					indexOfMax = mostPicked();

					if (indexOfMax == 0) {
						System.out.println("You have played rock the most.");
					}
					
					if (indexOfMax == 1) {
						System.out.println("You have played scissors the most.");
					}
					
					if (indexOfMax == 2) {
						System.out.println("You have played paper the most.");
					}
					
					if (indexOfMax == 3) {
						System.out.println("You have played lizard the most.");
					}
					
					if (indexOfMax == 4) {
						System.out.println("You have played spock the most.");
					}

					//checks to see if you are winning the game
					if (won > lost) {
						System.out.println("You are winning the game!");
						System.out.println("");
					}

					if (lost > won) {
						System.out.println("You are losing the game!");
						System.out.println("");
					}

					if (lost == won) {
						System.out.println("You are tied with the computer!");
						System.out.println("");
					}

					//if there is no wins or loses during the point
					if (won == 0) {
						System.out.println("Wow you have not won a game yet... luck is not on your side today.");
						System.out.println("");
					}

					if (lost == 0) {
						System.out.println("Wow you have not lost a game yet, Great job!");
						System.out.println("");
					}

				}

				// game end code if typed while round = %10 = 0				
				else if (uInput.equalsIgnoreCase("end")) {

					System.out.println(String.format("%-20s " + won, "You have won a total of: "));
					System.out.println(String.format("%-20s " + lost, "You have lost a total of: "));
					System.out.println(String.format("%-20s " + draw, "You have tied a total of: "));
					
					indexOfMax = mostPicked();

					if (indexOfMax == 0) {
						System.out.println("You have played rock the most.");
					}
					
					if (indexOfMax == 1) {
						System.out.println("You have played scissors the most.");
					}
					
					if (indexOfMax == 2) {
						System.out.println("You have played paper the most.");
					}
					
					if (indexOfMax == 3) {
						System.out.println("You have played lizard the most.");
					}
					
					if (indexOfMax == 4) {
						System.out.println("You have played spock the most.");
					}

					if (won > lost) {
						System.out.println("You have won the game!");
					}

					if (lost > won) {
						System.out.println("You have lost the game.");
					}

					if (lost == won) {
						System.out.println("You have tied the game with the computer!");
					}


					System.out.println("Bye!");
					userInput.close(); //closes consol so no more input can be put in.

				}

				else {

					checkWin(uInput, compInput); // method call for the actual game code(at bottom)

				}
			}
			
			// if round is not a multiple of ten it will run this
			else {
				System.out.println("Begin round " + round);
				uInput = userInput.next();
				
				// Game stats2
				if (uInput.equalsIgnoreCase("stats")) {

					System.out.println(String.format("%-45s " + won + " games", "You have won a current total of: "));
					System.out.println(String.format("%-45s " + lost + " games", "You have lost a current total of: "));
					System.out.println(String.format("%-45s " + draw + " games", "You have tied a current total of: "));
					per = (won / (round * 1.0)) * 100;
					System.out.println(String.format("%-45s " + per + "%% chance of wining the game!", "You currently have a: "));
					
					//uses the info gathered by the array to display what the player has chosen most
					indexOfMax = mostPicked();

					if (indexOfMax == 0) {
						System.out.println("You have played rock the most.");
					}
					
					if (indexOfMax == 1) {
						System.out.println("You have played scissors the most.");
					}
					
					if (indexOfMax == 2) {
						System.out.println("You have played paper the most.");
					}
					
					if (indexOfMax == 3) {
						System.out.println("You have played lizard the most.");
					}
					
					if (indexOfMax == 4) {
						System.out.println("You have played spock the most.");
					}

					//checks to see if the user is winning or losing
					if (won > lost) {
						System.out.println("You are currently winning the game!");
						System.out.println("");
					}

					if (lost > won) {
						System.out.println("You are currently losing the game!");
						System.out.println("");
					}

					if (lost == won) {
						System.out.println("You are tied with the computer!");
						System.out.println("");
					}

					//if win or loss = 0 special messages will be displayed
					if (won == 0) {
						System.out.println("Wow you have not won a game yet... luck is not on your side today.");
						System.out.println("");
					}

					if (lost == 0) {
						System.out.println("Wow you have not lost a game yet, Great job!");
						System.out.println("");
					}

				}

				// game end code 2 if user types end while %10 != 0
				else if (uInput.equalsIgnoreCase("end")) {

					System.out.println(String.format("%-20s " + won, "You have won a total of: "));
					System.out.println(String.format("%-20s " + lost, "You have lost a total of: "));
					System.out.println(String.format("%-20s " + draw, "You have tied a total of: "));
					
					//uses the info gathered by the array to display what the player has chosen most
					indexOfMax = mostPicked();

					if (indexOfMax == 0) {
						System.out.println("You have played rock the most");
					}
					
					if (indexOfMax == 1) {
						System.out.println("You have played scissors the most");
					}
					
					if (indexOfMax == 2) {
						System.out.println("You have played paper the most");
					}
					
					if (indexOfMax == 3) {
						System.out.println("You have played lizard the most");
					}
					
					if (indexOfMax == 4) {
						System.out.println("You have played spock the most");
					}

					//checks to see if the user is winning or losing
					if (won > lost) {
						System.out.println("You have won the game!");
					}

					if (lost > won) {
						System.out.println("You have lost the game.");
					}

					if (lost == won) {
						System.out.println("You have tied the game with the computer!");
					}

					System.out.println("Bye!");
					userInput.close();
				}

				else {

					checkWin(uInput, compInput); // method call for actual game code(at bottom)
				}

			}

		} while (!uInput.equalsIgnoreCase("end"));
		userInput.close(); // ends the code so no more input can be given to the console
	}

	/**
	 * checkWin checks to see if the user has won the match
	 * @param Urps
	 * @param compInput
	 * @retun check win does not return anything
	 **/

	public static void checkWin(String uInput, int compInput) {

		if (uInput.equalsIgnoreCase("Rock")) {
			round++; 
			uInputArray[0]++; //sends to the array to store that this was chosen
			
			if (compInput == 1) {
				System.out.println("You both picked Rock!");
				draw++;
			}

			if (compInput == 2) {
				System.out.println("You lost! The computer chose Paper.");
				lost++;
			}

			if (compInput == 3) {
				System.out.println("You won! The computer chose Scissors");
				won++;
			}

			if (compInput == 4) {
				System.out.println("You won! The computer chose Lizard");
				won++;
			}

			if (compInput == 5) {
				System.out.println("You lost! The computer chose Spock.");
				lost++;

			}
		}

		else if (uInput.equalsIgnoreCase("Scissors")) {
			round++;
			uInputArray[1]++;//sends to the array to store that this was chosen

			if (compInput == 3) {
				System.out.println("You both picked Scissors!");
				draw++;
			}

			if (compInput == 1) {
				System.out.println("You lost! The computer chose Rock.");
				lost++;
			}

			if (compInput == 2) {
				System.out.println("You won! The computer chose Paper");
				won++;
			}

			if (compInput == 4) {
				System.out.println("You won! The computer chose Lizard");
				won++;
			}

			if (compInput == 5) {
				System.out.println("You lost! The computer chose Spock.");
				lost++;

			}
		}

		else if (uInput.equalsIgnoreCase("Paper")) {
			round++;
			uInputArray[2]++;//sends to the array to store that this was chosen

			if (compInput == 2) {
				System.out.println("You both picked Paper!");
				draw++;
			}

			if (compInput == 1) {
				System.out.println("You won! The computer chose Rock");
				won++;
			}

			if (compInput == 3) {
				System.out.println("You lost! The computer chose Scissors");
				lost++;
			}

			if (compInput == 4) {
				System.out.println("You lost! The computer chose Lizard");
				lost++;
			}

			if (compInput == 5) {
				System.out.println("You won! The computer chose Spock.");
				won++;

			}
		}

		else if (uInput.equalsIgnoreCase("Lizard")) {
			round++;
			uInputArray[3]++;//sends to the array to store that this was chosen

			if (compInput == 4) {
				System.out.println("You both picked Lizard!");
				draw++;
			}

			if (compInput == 1) {
				System.out.println("You lost! The computer chose Rock.");
				lost++;
			}

			if (compInput == 2) {
				System.out.println("You won! The computer chose Paper");
				won++;
			}

			if (compInput == 3) {
				System.out.println("You lost! The computer chose Scissors");
				lost++;
			}

			if (compInput == 5) {
				System.out.println("You won! The computer chose Spock.");
				won++;

			}
		}

		else if (uInput.equalsIgnoreCase("Spock")) {
			round++;
			uInputArray[4]++;//sends to the array to store that this was chosen

			if (compInput == 5) {
				System.out.println("You both picked Spock!");
				draw++;
			}

			if (compInput == 1) {
				System.out.println("You won! The computer chose Rock.");
				won++;
			}

			if (compInput == 2) {
				System.out.println("You lost! The computer chose Paper");
				lost++;
			}

			if (compInput == 3) {
				System.out.println("You won! The computer chose Scissors");
				won++;
			}

			if (compInput == 4) {
				System.out.println("You lost! The computer chose Lizard.");
				lost++;

			}
		}

		// user input "cheating"
		else if (uInput.equalsIgnoreCase("grenade")) {
			System.out.println("Hey, that's cheating! This counts as a lost match.");
			lost++;
			round++;
		}

		else if (uInput.equalsIgnoreCase("gun")) {
			System.out.println("Hey, that's cheating! This counts as a lost match.");
			lost++;
			round++;
		}

		else if (uInput.equalsIgnoreCase("bomb")) {
			System.out.println("Hey, that's cheating! This counts as a lost match.");
			lost++;
			round++;
		}

		else if (uInput.equalsIgnoreCase("poison")) {
			System.out.println("Hey, that's cheating! This counts as a lost match.");
			lost++;
			round++;
		}

		else if (uInput.equalsIgnoreCase("dynomite")) {
			System.out.println("Hey, that's cheating! This counts as a lost match.");
			lost++;
			round++;
		}
	}

	/**
	 * mostPicked uses an array to see what the user has inputed most of.
	 * @param no parameters
	 * @return mostPicked returns the choice the player has played most
	 */
	public static int mostPicked() {

		int max;
		int index;

		index = 0;
		max = uInputArray[0];

		for (int i = 0; i < uInputArray.length; i++) {

			if (uInputArray[i] > max) {
				max = uInputArray[i];
				index = i;
			}

		}

		return index;

	}

}

		