package firstgames;

public class Nim {

	
	public int initialSize;
	public int maxTakeSize;
	
	public Player player1;
	public Player player2;
	
	public int currentMatches;
	public Player currentPlayer;
	
	public Nim(int inputInitialSize, int inputMaxTakeSize, Player inputPlayer1, Player inputPlayer2)
	{
		this.initialSize = inputInitialSize;
		this.currentMatches = this.initialSize;
		this.maxTakeSize = inputMaxTakeSize;
		this.player1 = inputPlayer1;
		this.player2 = inputPlayer2;
		this.currentPlayer = this.player1;	
	}
	
	public int getInitialNbMatches()
	{
		return this.initialSize;
	}
	
	public int getCurrentNbMatches()
	{
		return this.currentMatches;
	}
	
	public Player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	public String situationToString()
	{
		return ("Il reste " + this.getCurrentNbMatches() + " allumettes.");
	}

	public void removeMatches(int inputNumToRemove)
	{
		if(isValid(inputNumToRemove))
		{this.currentMatches -= inputNumToRemove;
		if (this.getCurrentPlayer() == this.player1)
			{
				this.currentPlayer = this.player2;
			}
		else if (this.getCurrentPlayer() == this.player2)
		{
			this.currentPlayer = this.player1;
		}
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
