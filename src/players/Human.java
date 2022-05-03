package players;
import java.util.*;

import games.Game;

public class Human implements Player
{
	public Human(String inputName, Scanner inputScanner)
	{
		this.name = inputName;
		this.myScanner = inputScanner;
	}
	
	public String name;
	public Scanner myScanner;
	
	public String toString()
	{
		return this.name;
	}
	
	public int chooseMove(Game inputGame)
	{
		ArrayList<Integer> moveList = inputGame.validMoves();
		boolean valid = false;
		int selectedMove = -1;
		
		while (!valid)
		{
			for (int a = 0; a < moveList.size(); a++)
			{
				//System.out.println(moveList.get(a));
			}
			
			String asString = this.myScanner.next();
			try {
			        selectedMove = Integer.parseInt(asString);
			        valid = inputGame.isValid(selectedMove);
			} catch (NumberFormatException e) {
			        System.out.println("Invalid move.");
			        valid = false;
			}

		}

		return selectedMove;
	}
}
