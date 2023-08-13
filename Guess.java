import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Guess {

	public static void main(String[] args) {
		Boolean ans = true;
		while(ans)
		{
			Info info = new Info();
			System.out.println("===============================");
			System.out.println("========= NUMBER GUESS ========");
			System.out.println("===== WELCOME TO THE GAME =====");
			System.out.println("===============================");
			System.out.println("========== GAME RULE ==========");
			System.out.println(" 1.GUESS NUMBER BETWEEN 1 TO 10");
			System.out.println("  2.YOU HAVE A ONLY 3 CHANCES  ");
			System.out.println("===============================");
				int attempt = 3;
				int randamNumber = info.RandamNumber();
				while(attempt>0)
				{
				  System.out.println("=========== ATTEMPT ===========");
				  System.out.print("Please Enter Guessed number : ");
				  try {
						int userGuessNo = info.UserGuessNo();
						if(userGuessNo>0&&userGuessNo<10)
						{
							if(randamNumber==userGuessNo)
							{
								System.out.println("===============================");
								System.out.println("==== CONGRATULATIONS !!!! =====");	
								System.out.println("YOU HAVE GUESSED CORRECT NUMBER");
								System.out.println("=!=!=!=!=!=!=!=!=!=!=!=!=!=!=!=");
								break;
									
							}else if(randamNumber>userGuessNo)
							{
								System.out.println("===============================");
									
								System.out.println("  You Have Guessed low Number  ");
								System.out.println("===============================");
								attempt--;
							}else if(randamNumber<userGuessNo)
							{
								System.out.println("===============================");
									
								System.out.println("  You Have Guessed High Number ");
								System.out.println("===============================");
								attempt--;
							}
							
						}else
						{
							System.out.println("Guess Number Between 1 To 10");
							attempt--;
						}
				  }catch(InputMismatchException e)
				  {
					  System.out.println("!! Enter Value in Number Format");
					  System.out.println("===============================");
					  attempt--;
				  }
			}
				if(attempt!=0)
				{
					
					System.out.println("===============================");
					System.out.println("== DO YOU WANT TO PLAY AGAIN ==");
					System.out.println("== IF You Want Play Enter Y ===");
					System.out.println("== Other wise Enter Any key ===");
					char anss = info.UserGuessAns();
					if(anss=='y' || anss=='Y')
					{
						ans=true;
					}else
					{
						ans=false;
					}
					
					
			    }
				
				if(attempt==0)
				{
					System.out.println("========= YOU LOSE GAME =======");
					System.out.println();
					System.out.println("===============================");
					System.out.println("== DO YOU WANT TO PLAY AGAIN ==");
					System.out.println("== IF You Want Play Enter Y ===");
					System.out.println("== Other wise Enter Any key ===");
					char anss = info.UserGuessAns();
					if(anss=='y' || anss=='Y')
					{
						ans=true;
					}else
					{
						ans=false;
					}
					
			    }
				
		}
}

}
class Info
{
	public int RandamNumber() {
		Random randam = new Random();
		int randamNumber = randam.nextInt(10)+1;
		return randamNumber;
	}
	public int UserGuessNo()
	{
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		return number;
	}
	public char UserGuessAns()
	{
		Scanner scan = new Scanner(System.in);
		char ans = scan.next().charAt(0);
		return ans;
	}
}
