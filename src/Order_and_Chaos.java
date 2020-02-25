package tic_tac_class;
import java.util.Scanner;
import tic_tac_class.Token;
import tic_tac_class.Board;
import tic_tac_class.Player;
import tic_tac_class.Tic_Tac_Toe_Rules;
import tic_tac_class.Board_Cell;


public class Order_and_Chaos {
	public static Scanner plInput = new Scanner(System.in);


	public static void playOC() {

		boolean runner = true;
		boolean niner = false;
		boolean finish = false;
		boolean complete = true;
		char yesn = 'o';
		int switcher = 0;
		int order = 0;
		int x = 0;
		int y = 0;
		char e =' ';
		String name ="";


		//init players
		System.out.print("Welcome to Order and Chaos!\n");
		System.out.print("Player 1 - Please enter your credentials (name, team number): ");
		new Player(plInput.next(), plInput.nextInt());
		System.out.print("Player 2 - Please enter your credentials (name, team number): ");
		new Player(plInput.next(), plInput.nextInt());

		//init stats
		int oneW = Player.winCount.get(0);
		int twoW = Player.winCount.get(1);
		int oneL = Player.lossCount.get(0);
		int twoL = Player.lossCount.get(1);


		System.out.print("Choose who will be Order: ");
		while (runner){
			name = plInput.next();
			if (Player.names.contains(name)) {
				if(Player.names.indexOf(name) == 0) {
					System.out.print(Player.names.get(0) + " is Order (get 5 in a row!)\n");
					System.out.print(Player.names.get(1) + " is Chaos (make the board full!)\n");
					switcher = 0;
					break;
				}
				else {
					System.out.print(Player.names.get(1) + " is Order (get 5 in a row!)\n");
					System.out.print(Player.names.get(0) + " is Chaos (make the board full!)\n");
					switcher = 1;
					order = 1;
					break;
				}
			}

			else {
				System.out.print("\nNot accepted. Enter a valid name!");
			}
		}
		while(complete) {
			Board.makeBoard(6,6);
			Board.winNum = 5;

			while (Board.fullBoard() != true){
				while (niner == false) {
					System.out.print(Player.names.get(switcher) + " enter your move with either tokens! (x, y, token): ");
					x = plInput.nextInt();
					y = plInput.nextInt();
					while (runner){
						e = plInput.next().charAt(0);
						if (Token.prevPlayers.contains(e)) {
							break;
							}
						else {
							System.out.print("Input wrong! Choose a char you made in the beginning!" );
						}
					}
					niner = Board_Cell.placeOCtoken(x,y,e);
					if (niner == false) {
						System.out.print("Input wrong! Try again:\n" );
					}
				}
				niner = false;
				switcher += 1;
				if (switcher > 1) {
					switcher = switcher - 2;
				}
				Board.printBoard(6,6);

				if (Tic_Tac_Toe_Rules.winCheck(x,y) == true) {
					//check for a winner
					if (order == 0) {
						oneW += 1;
						twoL += 1;
						Player.winCount.set(0, oneW);
						Player.lossCount.set(1, twoL);

					}
					else {
						oneL += 1;
						twoW += 1;
						Player.winCount.set(1, twoW);
						Player.lossCount.set(0, oneL);
					}
					System.out.print("Order wins!" );
					break;
				}
				Player.changePlayer();
			}

			if (Board.fullBoard() == true && Tic_Tac_Toe_Rules.winCheck(x,y) == false) {
				System.out.print("Chaos wins!");
				if (order == 1) {
					oneW += 1;
					twoL += 1;
					Player.winCount.set(0, oneW);
					Player.lossCount.set(1, twoL);

				}
				else {
					oneL += 1;
					twoW += 1;
					Player.winCount.set(1, twoW);
					Player.lossCount.set(0, oneL);
				}
			}

			System.out.print("\nPlay again? (y/n):");

			//checks to see if user input is acceptable
			while (finish == false){
				yesn = plInput.next().charAt(0);
				if (yesn == 'y') {
					break;
				}
				if (yesn == 'n') {
					runner = false;
					System.out.print("\nThanks for playing!\n");
					break;
				}
				else {
					System.out.print("\nNot accepted. Please put y for yes or n for no\n");
				}
			}
			switcher = 0;
		}
		System.out.print("Statistics:\n");
		System.out.print("\n" + Player.names.get(0) + " won " + Player.winCount.get(0) +" games\n");
		System.out.print(Player.names.get(0) + " lost " + Player.lossCount.get(0) +" games\n");
		System.out.print("\n" + Player.names.get(1) + " won " + Player.winCount.get(1) +" games\n");
		System.out.print(Player.names.get(1) + " lost " + Player.lossCount.get(1) +" games\n");
		System.out.print("Ties: " + Player.tieCount+"\n");
	}


}
