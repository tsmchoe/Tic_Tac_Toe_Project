package tic_tac_class;

import java.util.*;

public class Token {
	public static ArrayList<Character> prevPlayers = new ArrayList<Character>();
	
	
	public static boolean makeToken(char token) {
		if(prevPlayers.isEmpty()) {
			prevPlayers.add(token);
			return true;
		}
		//make sure there are no similar tokens
		else {
			for(int i=0; i < prevPlayers.size(); i++) {
				if(prevPlayers.get(i) == token) {
					break;
				}
				else {
					prevPlayers.add(token);
					return true;
				}
			}
		}

		return false;
	}
	
}
