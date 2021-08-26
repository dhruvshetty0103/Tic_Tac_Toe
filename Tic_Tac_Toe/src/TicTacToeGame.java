import java.util.*;
public class TicTacToeGame 
{
	Random rand=new Random();
	String turn="";
	public static char [] board=new char[10];
	char computerLetter,playerLetter,insertLetter;
	int i,move=0,count=0;
	/*move variable used to locate the cell in the board 
	 * and count to track whether all cells are filled or 
	 * not
	 */
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
		for(i=1;i<board.length;i=i+3)//Taking a length and adding 3 to i value display NxN matrix
		{
			System.out.println(board[i]+"|"+board[i+1]+"|"+board[i+2]);/*This will help us to iterate all elements in a current row*/
			System.out.println("-+-+-");
		}
	}
	
	
	void selectDesiredLocation()/*Displaying whether the desired location or index exists on board*/
	{
		while(count<=9)
		{
			
			System.out.println(turn+" chance enter desired location to make a move:");
			move=reader.nextInt();
			if(move>0 && move<(board.length))/*The board value will range in between 1 to N-1 where here the N is 10*/
			{
				System.out.println("Desired location:"+move+" exists on board");
				availableSpace(move);
			}
			else
				System.out.println("Please enter a location which exists in range of 1 to "+(board.length-1));
		}
		if(count==9)
			System.out.println("Board is full so game over!");
	}
	
	
	void availableSpace(int location)/*Where free space is available insert letter*/
	{
		if(turn=="Player")
		{
			insertLetter=playerLetter;
			turn="Computer";//Setting next turn to computer
		}
		else
		{
			insertLetter=computerLetter;
			turn="Player";//Setting next turn to player
		}
		if(board[location]!='X' || board[location]!='O')//When these spaces are not occupied by any letter
		{
			System.out.println("Free space available");
			board[move]=insertLetter;
			count++;
			showBoard();/*Showing board to check whether it is working or not*/
		}
		else
			System.out.println("Free space not available");
	}
	
	
	void toss()/*Toss function to decide who will go first */
	{
		System.out.println("Choose the side of the coin for toss\nEnter\n0.Heads\n1.Tails");
		int sideSelection=reader.nextInt();//Reading player choice for coin side
		int tossResult=rand.nextInt(2);//Generating random number to decide result of toss
		//reader.close();
		if(tossResult==sideSelection)//If the result of toss is in favor of player he gets turn for the first insert
		{
			System.out.println("It's player turn first");
			turn="Player";
		}
		else
		{
			System.out.println("It's computer turn first");
			turn="Computer";
		}
	}
	
	
	public static void main(String[] args) 
	{
		TicTacToeGame new_game=new TicTacToeGame();
		new_game.initialize();
		new_game.choose_Letter();
		new_game.showBoard();
		new_game.toss();
		new_game.selectDesiredLocation();
		//new_game.availableSpace();
	}
}
