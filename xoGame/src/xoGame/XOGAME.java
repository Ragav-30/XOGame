package xoGame;

import java.util.Scanner;

public class XOGAME {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][3];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}

		}

		boolean gameOver = false;
		char player = 'X';
		Scanner sc = new Scanner(System.in);

		while (!gameOver) {
			showGameBoard(board);
			System.out.println("Player " + player + " Enter:");
			int row = sc.nextInt();
			int col = sc.nextInt();
			System.out.println();
			if (row >= 3 || col >= 3) {
				System.out.println("Kindly enter possible move");
				row = sc.nextInt();
				col = sc.nextInt();
				System.out.println();
			}
			if (board[row][col] == ' ') {
				board[row][col] = player;
				gameOver = wonTheGame(board, player);
				if (gameOver == true) {
					System.out.println("Player " + player + " Wins.");
				} else {
					player = player == 'X' ? 'O' : 'X';
				}
			} else {
				System.out.println("Sry kindly enter correct row and column");

			}

		}
		showGameBoard(board);

	}

	private static boolean wonTheGame(char[][] board, char player) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		for (int col = 0; col < board.length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	private static void showGameBoard(char[][] board) {
		// TODO Auto-generated method stub
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " | ");
			}
			System.out.println();
		}

	}

}
