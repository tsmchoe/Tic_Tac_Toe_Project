package tic_tac_class;
import tic_tac_class.Player;

public class Board_Cell extends Board{
	
	public static boolean placetoken(int x, int y) {
		//allows the player to place their tokens on the board
		if ((x >= 0) && (x < board.length)) {
			if ((y >= 0) && (y < width)) {
				if (board[x][y] == ' ') {
					board[x][y] = Player.currPlayer;
					return true;
				}
			}
		}
		return false;
	}
	
}
