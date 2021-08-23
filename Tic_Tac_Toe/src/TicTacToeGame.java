import java.util.*;
public class TicTacToeGame 
{
	public static char [] board=new char[10];
	char computerLetter,playerLetter;
	int i,move=0;/*move variable used to locate the cell in the board */
	Scanner reader=new Scanner(System.in);
	void initialize()/*To initialize the game board*/
	{
		System.out.println("Welcome to TicTacToe");
		for(i=1;i<board.length;i++)
			board[i]=' ';
	}
	void choose_Letter()/*Function to assign letter to player and computer*/
	{
		System.out.println("Choose letter X or O for player");
		
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
		
	}
	void showBoard()/*Displaying current board*/
	{
		for(i=1;i<Math.sqrt(board.length);i++)//Taking a square root will help us to display NxN matrix
		{
			System.out.println(board[i]+"|"+board[i+1]+"|"+board[i+2]);/*This will help us to iterate all elements in a current row*/
			System.out.println("-+-+-");
		}
	}
	void selectDesiredLocation()/*Displaying whether the desired location or index exists on board*/
	{
		System.out.println("Enter desired location to make a move:");
		move=reader.nextInt();
		if(move>0 && move<(board.length))/*The board value will range in between 1 to N-1 where here the N is 10*/
		{
			System.out.println("Desired location:"+move+" exists on board");
			availableSpace(move);
		}
		else
			System.out.println("Please enter a location which exists in range of 1 to "+(board.length-1));
	}
	void availableSpace(int location)/*Stuck at use case 5*/
	{
		if(board[location]!='X' || board[location]!='O')
		{
			System.out.println("Free space available");
			//board[move]=The character to be added
		}
		else
			System.out.println("Free space not available");
	}
	public static void main(String[] args) 
	{
		TicTacToeGame new_game=new TicTacToeGame();
		new_game.initialize();
		new_game.choose_Letter();
		new_game.showBoard();
		new_game.selectDesiredLocation();
		//new_game.availableSpace();
	}
}
