package secondgames;

import java.util.*;

public class Nim extends AbstractGame{
	
	public int initialSize;
	public int maxTakeSize;
	public int currentMatches;
	
	public Nim(int inputInitialSize, int inputMaxTakeSize, Player inputPlayer1, Player inputPlayer2)
	{
		super(inputPlayer1, inputPlayer2);
		this.initialSize = inputInitialSize;
		this.maxTakeSize = inputMaxTakeSize;
		this.currentMatches = this.initialSize;
	}
	
	public int getInitialNbMatches()
	{
		return this.initialSize;
	}
	
	public int getCurrentNbMatches()
	{
		return this.currentMatches;
	}
	
	public String situationToString()
	{
		return ("Il reste " + this.getCurrentNbMatches() + " allumettes.");
	}
	
	public void doExecute(int moveNum)
	{
		this.removeMatches(moveNum);
	}
	
	public String moveToString()
	{
		return (this.currentPlayer.name + " enlève des allumettes.");
	}
	
	public ArrayList<Integer> validMoves()
	{
		//Return the list of how many matches we can pick up in one move.
		//For this, compare iterations with the current size and the max amount we can take in one go.
		
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		
		for (int a=1;a < this.maxTakeSize+1; a++)
		{
			if (a <= this.getCurrentNbMatches())
			{
				moveList.add(a);
			}
		}
		
		return moveList;
	}

	public void removeMatches(int inputNumToRemove)
	{
		if(isValid(inputNumToRemove))
		{this.currentMatches -= inputNumToRemove;
		}
	}
	
	public boolean isValid(int inputNumToRemove)
	{
		if (inputNumToRemove < 1)
		{
			return false;
		}
		
		if (this.getCurrentNbMatches() < inputNumToRemove)
		{
			return false;
		}
		if (this.maxTakeSize < inputNumToRemove)
		{
			return false;
		}
		if (this.getCurrentNbMatches() - inputNumToRemove < 0)
		{
			return false;
		}
		return true;
	}
	
	public Player getWinner()
	{
		
		if (this.getCurrentNbMatches() == 0)
		{
			return this.currentPlayer;
		}
		else
		{
			return null;
		}
	}
	public boolean isOver()
	{
		if (this.getCurrentNbMatches() == 0)
		{
			return true;
		}
		return false;
	}
}
