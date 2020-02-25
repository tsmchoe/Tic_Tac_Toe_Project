package tic_tac_class;


public class Board {
	public static char[][] board;
	public static int winNum;
	public static int width;
	public static int len;
	
	public static void initBoard(int n, int m) {
		//Creates the board for objects to be placed in
		len = n;
		width = m;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public static void outBorder(int n) {
		//creates upper and lower boundaries
		System.out.print("+--+");
		if (n > 1) {
			for (int i = 1; i < n; i++) {
				System.out.print("--+");
			}
		}
		System.out.print("\n");
	}
	
	public static void middleBorder(int n, int m) {
		//creates middle boundaries between tokens and also keeps current state of board
		outBorder(m);
		for (int i = 0; i < n; i++) {
			System.out.print("|");
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " |");
			}
			System.out.print("\n");
			outBorder(m);
		}
	}
	
	public static void makeBoard(int n, int m) {
		//creates a board size n x m
		board = new char[n][m];
		initBoard(n,m);
		middleBorder(n, m);
	}
	
	public static void printBoard(int n, int m) {
		//creates a board size n x m
		middleBorder(n, m);
	}
	
	
	public static boolean fullBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
