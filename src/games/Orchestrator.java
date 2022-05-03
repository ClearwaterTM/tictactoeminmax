package games;

import java.util.*;

public class Orchestrator {

	public void PlayGame(AbstractGame game)
	{
		Scanner scanner = new Scanner(System.in);
		while (!game.isOver())
		{
			System.out.println(game.getCurrentPlayer().toString() + "'s turn");
			ArrayList<Integer> availableMoves = game.validMoves();
			for (int a=0; a < availableMoves.size(); a++)
			{
				System.out.println(availableMoves.get(a));
			}
			System.out.println("Select a move to play.");
			int selectedMove = scanner.nextInt();
			if (availableMoves.contains(selectedMove))
			{
				game.execute(selectedMove);
			}
			else
			{
				System.out.println("Invalid move.");
			}
		}
		System.out.println(game.getWinner().toString() + " is the winner. Ending game.");
		scanner.close();
	}
	
}
