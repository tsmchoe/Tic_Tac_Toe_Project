package tic_tac_class;


import java.util.*;

import tic_tac_class.Token;


public class Player {
	//public so anyone can see their current condition at any time
	public static ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<Integer> teams = new ArrayList<Integer>();
	public static char currPlayer;
	//keeps track of the game statistics
	public static ArrayList<Integer> winCount = new ArrayList<Integer>();
	public static ArrayList<Integer> lossCount = new ArrayList<Integer>();
	public static int tieCount;


	public Player(String name, int team){
		boolean same = true;
		
		//names and team number can be the same
		names.add(name);
		teams.add(team);
		winCount.add(0);
		lossCount.add(0);
		
		//making sure the token is not the same
		while(same) {
			System.out.print("Choose your token (any char): ");
			char x = Tic_Tac_Toe.plInput.next().charAt(0);
			if(Token.makeToken(x) == true) {
				same = false;
			}
			else {
				System.out.print("Don't copy! Try again!\n");
			}
		}
	}
	
	
	public static void changePlayer() {
		//Changes who is playing
		if (currPlayer == Token.prevPlayers.get(0)) {
			currPlayer = Token.prevPlayers.get(1);
		}
		else {
			currPlayer = Token.prevPlayers.get(0);
		}
	}
	


}
