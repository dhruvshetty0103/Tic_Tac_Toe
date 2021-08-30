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
		while(count<9)
		{
			if(turn=="Player")//If turn is of player then ask him in which cell does he want to enter his letter
			{
				System.out.println(turn+" chance enter desired location to make a move:");
				move=reader.nextInt();
			}
			else
			{
				move=(int)((Math.random()*(9 - 1)) + 1);
				/*Here computer gets a randomly generated number in 
				 * between 1 to 9 where 9 is maximum and 1 is minimum in the range
				 */
				System.out.println("Computer randomly choses to cell number:"+move);
			}
			if(move>0 && move<(board.length))/*The board value will range in between 1 to N-1 where here the N is 10*/
			{
				System.out.println("Desired location:"+move+" exists on board");
				availableSpace(move);
			}
			else
				System.out.println("Please enter a location which exists in range of 1 to "+(board.length-1));
			/*Use case for to check that did anyone won for not */
			checkWinning();
		}
		if(count==9)//In course of game Tie the count reaches the limit 9 as all cells are filled up
			System.out.println("Board is full so game is Tie!");
	}
	
	
	void availableSpace(int location)/*Where free space is available insert letter*/
	{
		if(board[location]!='X' && board[location]!='O')//When these spaces are not occupied by any letter
		{
			/*If any letter exits in the cell it won't allow to insert letter
			 * not only that but also take care that turn of that player 
			 * or computer is not lost */
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
			System.out.println("Free space available");
			board[move]=insertLetter;//When free space is found then the letter is insert in that
			count++;//Updating that a cell is filled up
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
	/*We know pattern of winning are as follows if they have
	 * same letters at following indices 
	 * 123
	 * 147
	 * 159
	 * 258
	 * 369
	 * 357
	 * 456
	 * 789 
	 * So basically if letter are equal and are equal to either
	 * playerLetter or computerLetter then we get or winner
	 * and we stop the game and taking a flag variable to show 
	 * that game is won by someone and display the winner
	 * with it's associated letter
	 */
	void checkWinning()
	{
		int flag=0;
		if(board[1]==board[2] && board[2]==board[3] &&(board[1]==playerLetter||board[1]==computerLetter) )
			flag=1;
		if(board[1]==board[4] && board[4]==board[7] &&(board[1]==playerLetter||board[1]==computerLetter))
			flag=1;
		if(board[1]==board[5] && board[5]==board[9] &&(board[1]==playerLetter||board[1]==computerLetter))
			flag=1;
		if(board[2]==board[5] && board[5]==board[8] &&(board[2]==playerLetter||board[2]==computerLetter))
			flag=1;
		if(board[3]==board[6] && board[6]==board[9]&&(board[3]==playerLetter||board[3]==computerLetter))
			flag=1;
		if(board[3]==board[5] && board[5]==board[7]&&(board[3]==playerLetter||board[3]==computerLetter))
			flag=1;
		if(board[4]==board[5] && board[5]==board[6]&&(board[4]==playerLetter||board[4]==computerLetter))
			flag=1;
		if(board[7]==board[8] && board[8]==board[9]&&(board[7]==playerLetter||board[7]==computerLetter))
			flag=1;
		if(flag==1)
		{
			if(insertLetter==playerLetter)
			{
				System.out.println("Player won with letter:"+playerLetter);
				System.exit(0);
			}
			else
			{
				System.out.println("Computer won with letter:"+computerLetter);
				System.exit(0);
			}
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
	}
}
