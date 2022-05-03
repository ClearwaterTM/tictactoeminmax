package plays;

import java.util.Scanner;

import games.*;

public class Orchestrator {

	Game currentGame;
	
	public Orchestrator(Game inputGame)
	{
		this.currentGame = inputGame;
	}
	
	public void play()
	{
		Scanner scanner = new Scanner(System.in);
		while (!this.currentGame.isOver())
		{
			System.out.println(this.currentGame.situationToString());
			
			System.out.println(this.currentGame.getCurrentPlayer().toString() + "'s turn");
			
			int selectedMove = this.currentGame.getCurrentPlayer().chooseMove(this.currentGame);
			this.currentGame.execute(selectedMove);

		}
		//System.out.println(this.currentGame.getWinner().toString() + " is the winner. Ending game.");
		scanner.close();
	}
	
}
