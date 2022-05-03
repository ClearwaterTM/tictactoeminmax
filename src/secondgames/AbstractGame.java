package secondgames;

import java.util.*;

public abstract class AbstractGame {
	
	public Player currentPlayer;
	public Player player1;
	public Player player2;
	
	public AbstractGame(Player inputplayer1, Player inputplayer2)
	{
		this.player1 = inputplayer1;
		this.player2 = inputplayer2;
		this.currentPlayer = this.player1;
	}
	
	protected abstract void doExecute(int moveNum);
	
	public void execute(int moveNum)
	{
		doExecute(moveNum);
		System.out.println(moveToString());
		System.out.println(situationToString());
		if (this.currentPlayer == this.player1)
		{
			this.currentPlayer = this.player2;
		}
		else
		{
			this.currentPlayer = this.player1;
		}
	}
	
	public Player getCurrentPlayer()
	{
		return this.currentPlayer;
	}

	public abstract ArrayList<Integer> validMoves();
	public abstract boolean isValid(int moveNum);
	public abstract String situationToString();
	public abstract String moveToString();
	public abstract boolean isOver();	
	public abstract Player getWinner();
}
