import java.util.*;
public class TicTacToeGame 
{
	public static char [] ch={'\0',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	static void input()
	{
		Scanner reader=new Scanner(System.in);
		for(int i=1;i<10;i++)
			ch[i] = reader.next().charAt(i); 
		reader.close();
	}
	public static void main(String[] args) 
	{
		System.out.println("Enter elements");
		input();
		for(int i=1;i<10;i++)
			System.out.println(ch[i]);

	}

}
