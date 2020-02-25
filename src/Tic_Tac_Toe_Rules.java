package tic_tac_class;
import tic_tac_class.Board;

public class Tic_Tac_Toe_Rules {
	public static boolean winCheck(int x, int y) {
		return (winRow()||winDiag(x, y)||winCol());
	}
	
	private static boolean winDiag(int x, int y) {
		// Determines if player has one by getting winNum in a diagonal
		int counter = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;
		int five = 0;
		int six = 0;
		int checker = 0;
		
		if(Board.width < Board.len) {
			checker = Board.width;
		}
		else {
			checker = Board.len;
		}
		
		for (int i=0; i < checker; i++) {
			if (Board.board[i][i] == Player.currPlayer) {
				counter++;
			}
			if (Board.board[i][Board.width-i-1] == Player.currPlayer) {
				second++;
			}
		}
		if(Board.len > 3 || Board.width > 3) {
			for (int j=0; j < checker-1; j++) {
				if (Board.board[j][j+1] == Player.currPlayer) {
					third++;
				}
				if (Board.board[j][Board.width-(j+1)-1] == Player.currPlayer) {
					fourth++;
				}
			}
			for (int k = 0; k < checker-1; k++) {
				if(Board.board[k+1][k] == Player.currPlayer) {
					five++;
				}
				if (Board.board[k+1][Board.width-k-1] == Player.currPlayer) {
					six++;
				}
			}
		}

		if (counter == Board.winNum || second == Board.winNum || third == Board.winNum || fourth == Board.winNum || five == Board.winNum || six == Board.winNum) {
			return true;
		}
		return false;
	}
	
	private static boolean winRow() {
		// Determines if player has one by getting winNum in a row
		int counter = 0;
		for (int i=0; i < Board.width; i++) {
			for (int j=0; j < Board.len; j++) {
				if (Board.board[j][i] == Player.currPlayer) {
					counter++;
				}
			}
			//check here and reset counter if not a win in that row
			if (counter == Board.winNum) {
				return true;
			}
			counter = 0;
		}
		return false;
	}
	
	private static boolean winCol() {
		// Determines if player has one by getting winNum in a column
		int counter = 0;
		for (int i=0; i < Board.len; i++) {
			for (int j=0; j < Board.width; j++) {
				if (Board.board[i][j] == Player.currPlayer) {
					counter++;
				}
			}
			//check here and reset counter if not a win in that column
			if (counter == Board.winNum) {
				return true;
			}
			counter = 0;
		}
		return false;
	}
}
