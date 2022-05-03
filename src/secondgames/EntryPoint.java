package secondgames;

import java.util.*;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orchestrator menu = new Orchestrator();
		
		String player1name, player2name;
		
		System.out.println("What game would you like to play?");
		System.out.println("1: TicTacToe");
		System.out.println("2: Nim");
		short gameSelection = 0;
		
		Scanner input = new Scanner(System.in);
		
		while ((gameSelection != 1) || (gameSelection !=2))
		{
			gameSelection = input.nextShort();
			System.out.println(gameSelection);
			if ((gameSelection == 1) || (gameSelection ==2))
			{
				break;
			}
			else
			{
				System.out.println("Invalid selection.");
			}
		}
		
		if (gameSelection == 1)
		{
			
			System.out.println("Player 1 name?");
			player1name = input.nextLine();
			player1name = input.nextLine();
			System.out.println(player1name);
			
			System.out.println("Player 2 name?");
			player2name = input.nextLine();
			System.out.println(player2name);
			
			System.out.println("Beginning TicTacToe...");
			TicTacToe newGame = new TicTacToe(new Player(player1name), new Player(player2name));
			menu.PlayGame(newGame);
			input.close();
		}
		else if (gameSelection == 2)
		{
			int pileSize, maxTake;
			
			System.out.println("Player 1 name?");
			player1name = input.nextLine();
			player1name = input.nextLine();
			System.out.println(player1name);
			
			System.out.println("Player 2 name?");
			player2name = input.nextLine();
			System.out.println(player2name);
			
			System.out.println("Starting pile size?");
			pileSize = input.nextInt();
			System.out.println(pileSize);
			
			System.out.println("Max take size?");
			maxTake = input.nextInt();
			System.out.println(maxTake);
			
			System.out.println("Beginning Nim...");
			Nim newGame = new Nim(pileSize, maxTake,new Player(player1name), new Player(player2name));
			menu.PlayGame(newGame);
			input.close();
		}
	}

}
