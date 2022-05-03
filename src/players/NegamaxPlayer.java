package players;

import java.util.*;
import games.Game;

public class NegamaxPlayer implements Player{
	
	public NegamaxPlayer()
	{
		;
	}

	public int evaluate(Game currentSituation)
	{
		Player currentPlayer = currentSituation.getCurrentPlayer();
		
		//Start by checking if the game is over.
		if (currentSituation.isOver())
		{
			
			//If the current player wins, return 1.
			if (currentSituation.getWinner() == currentPlayer)
			{
				return 1;
			}
			//If the current player loses, return -1.
			else if (currentSituation.getWinner() != currentPlayer)
			{
				return -1;
			}
			//If the game is a tie, return 0.
			else if (currentSituation.getWinner() == null);
			{
				return 0;
			}
		}
		//Otherwise if it isn't over, start the recursive calls.
		else
		{
			Integer res = null;
			ArrayList<Integer> remainingMoveList = currentSituation.validMoves();
			
		//	System.out.println("BEGINNING RECURSIVE EVALUATION");
			
			for (int a = 0; a < remainingMoveList.size(); a++)
			{
				//Get the upcoming situation for a move in the move list for the player.
				Game upcomingSituation = currentSituation.copy();
				int matchesToRemove = remainingMoveList.get(a);
				upcomingSituation.execute(matchesToRemove);
				
				//Call recursively.
				int value = -(evaluate(upcomingSituation));
				if ((res == null) || (value > res))
				{
					res = value;
				}
			}
			//System.out.println("ENDING RECURSIVE EVALUATION");
			return res;
		}
	}
	
	public int chooseMove(Game currentGame)
	{
		Integer bestValue = null;
		Integer bestMove = null;
		int a = 0;
		ArrayList<Integer> moveList = currentGame.validMoves();
		//System.out.println("BEGINNING NEGAMAX CALCULATION");
		
		
		for (a = 0; a < moveList.size(); a++)
		{
			Game nextSituation = currentGame.copy();
			System.out.println(moveList.get(a));
			int matchesToRemove = moveList.get(a);
			nextSituation.execute(matchesToRemove);
			int value = -evaluate(nextSituation);
			if ((bestValue == null) || (value > bestValue))
			{
				bestValue = value;
				bestMove = a;
			}
		}
	//	System.out.println("END OF NEGAMAX CALCULATION");
		System.out.println("Best calculated move is " + bestMove + " which is " + moveList.get(bestMove));
		return moveList.get(bestMove);
	}
	
}
