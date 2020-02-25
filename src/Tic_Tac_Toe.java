package tic_tac_class;
import java.util.Scanner;

import tic_tac_class.Player;
import tic_tac_class.Tic_Tac_Toe_Rules;

public class Tic_Tac_Toe {
	public static Scanner plInput = new Scanner(System.in);
	
	public static void playTTT() {
		
		boolean runner = true;
		boolean niner = false;
		boolean finish = false;
		boolean winCondition = true;
		char yesn = 'o';
		int switcher = 0;
		int x = 0;
		int y = 0;

		
		//init players
		System.out.print("Welcome to Tic-Tac-Toe!\n");
		System.out.print("Player 1 - Please enter your credentials (name, team number): ");
		new Player(plInput.next(), plInput.nextInt());
		System.out.print("Player 2 - Please enter your credentials (name, team number): ");
		new Player(plInput.next(), plInput.nextInt());
		
		//init stats
		int oneW = Player.winCount.get(0);
		int twoW = Player.winCount.get(1);
		int oneL = Player.lossCount.get(0);
		int twoL = Player.lossCount.get(1);
		
		while(runner) {
			
			//Creating Board
			System.out.print("Please enter board size (x,y): ");
			int l = plInput.nextInt();
			int w = plInput.nextInt();
			Player.currPlayer = Token.prevPlayers.get(0);
			
			//How many you need to get in a line to win - checks to make sure win condition is within the board's length
			while(winCondition) {
				System.out.print("Set win number condition: ");
				Board.winNum = plInput.nextInt();
				if (Board.winNum > l && Board.winNum > w) {
					System.out.print("Too big! Try again!\n");
				}
				else if(Board.winNum < 3) {
					System.out.print("Too small! Try again!\n");
				}
				else {
					break;
				}
				
			}
			//show Board
			Board.makeBoard(l,w);

			//show the players
			System.out.print("Player 1 is: " + Player.names.get(0) + "\n");
			System.out.print("Player 2 is: " + Player.names.get(1) + "\n");
			
			
			//start the game
			while (Board.fullBoard() != true){
				while (niner == false) {
					System.out.print(Player.names.get(switcher) + " enter your move for " + Player.currPlayer + ":");
					x = plInput.nextInt();
					y = plInput.nextInt();
					niner = Board_Cell.placetoken(x,y);
					if (niner == false) {
						System.out.print("Input wrong! Try again:\n" );
					}
				}
				niner = false;
				switcher += 1;
				if (switcher > 1) {
					switcher = switcher - 2;
				}
				Board.printBoard(l,w);
				
				if (Tic_Tac_Toe_Rules.winCheck(x,y) == true) {
					//check for a winner
					if (Player.currPlayer == Token.prevPlayers.get(0)) {
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
					System.out.print("Player " + Player.currPlayer + " wins!" );
					break;
				}
				Player.changePlayer();
			}
			
			if (Board.fullBoard() == true && Tic_Tac_Toe_Rules.winCheck(x,y) == false) {
				Player.tieCount += 1;
				System.out.print("Board is full! Stalemate");
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
