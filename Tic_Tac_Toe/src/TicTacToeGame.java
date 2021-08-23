
public class TicTacToeGame 
{
	public static char [] board=new char[10];
	static void initialize()
	{
		System.out.println("Welcome to TicTacToe");
		for(int i=1;i<board.length;i++)
			board[i]=' ';
	}
	public static void main(String[] args) 
	{
		initialize();
	}
}
