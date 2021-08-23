import java.util.*;
public class TicTacToeGame 
{
	public static char [] board=new char[10];
	char computerLetter,playerLetter;
	void choose_Letter()/*Function to assign letter to player and computer*/
	{
		System.out.println("Choose letter X or O for player");
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter player letter:");
		playerLetter=reader.next().charAt(0);
		if(playerLetter=='X' || playerLetter=='x')/*Doing this to avoid case sensitivity */
		{
			computerLetter='O';
			System.out.println("Player letter:"+playerLetter+" and Computer letter:"+computerLetter);/*Determinig player and computer letter*/
		}
		else if(playerLetter=='O' || playerLetter=='o')
		{
			computerLetter='X';
			System.out.println("Player letter:"+playerLetter+" and Computer letter:"+computerLetter);/*Determinig player and computer letter*/
		}
		else
			System.out.println("Please enter either X or O other letter are not allowed");
		reader.close();
	}
	void initialize()/*To initialize the game board*/
	{
		System.out.println("Welcome to TicTacToe");
		for(int i=1;i<board.length;i++)
			board[i]=' ';
	}
	public static void main(String[] args) 
	{
		TicTacToeGame new_game=new TicTacToeGame();
		new_game.initialize();
		new_game.choose_Letter();
	}
}
