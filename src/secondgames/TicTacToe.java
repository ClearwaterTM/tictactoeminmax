package secondgames;

import java.util.*;

public class TicTacToe extends AbstractGame{
	
	public Player[][] grid;
	
	public TicTacToe(Player inputplayer1, Player inputplayer2)
	{
		super(inputplayer1, inputplayer2);
		this.grid = new Player[3][3];
		
		for (int a = 0; a < 2; a++)
		{
			for (int b = 0; b < 2; b++)
			{
				this.grid[a][b] = null;
			}
		}
	}
	
	
	public ArrayList<Integer> validMoves()
	{
		ArrayList<Integer> validMoveList = new ArrayList<Integer>();
		
		int spaceToCheck = 0;
		
		for (int a = 0; a < 3; a++)
		{
			for (int b = 0; b < 3; b++)
			{
				if (grid[a][b] == null)
				{
					validMoveList.add(spaceToCheck);
				}
			spaceToCheck++;
			}
		}
		return validMoveList;
	}
	
	public boolean isValid(int movenum)
	{
		ArrayList<Integer> validMoves = this.validMoves();
		
		if (validMoves.contains(movenum))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public void doExecute(int movenum)
	{
		//If the selected move is valid then update the corresponding square.
		if (isValid(movenum))
		{
			
			switch(movenum)
			{
			case 0: {this.grid[0][0] = this.getCurrentPlayer(); break;}
			case 1: {this.grid[0][1] = this.getCurrentPlayer(); break;}
			case 2: {this.grid[0][2] = this.getCurrentPlayer(); break;}
			case 3: {this.grid[1][0] = this.getCurrentPlayer(); break;}
			case 4: {this.grid[1][1] = this.getCurrentPlayer(); break;}
			case 5: {this.grid[1][2] = this.getCurrentPlayer(); break;}
			case 6: {this.grid[2][0] = this.getCurrentPlayer(); break;}
			case 7: {this.grid[2][1] = this.getCurrentPlayer(); break;}
			case 8: {this.grid[2][2] = this.getCurrentPlayer(); break;}
			}
			
		}
		else
		{
			System.out.println("Invalid move.");
		}
	}
	
	
	//problem - checking for wrong player, returning null when should be returning player1?
	public boolean wins(Player playerToCheck, int row, int column, int deltaRow, int deltaColumn)
	{	

		if (playerToCheck.equals(this.grid[row][column])
			&& playerToCheck.equals(this.grid[row+deltaRow][column+deltaColumn])
			&& playerToCheck.equals(this.grid[row + 2*deltaRow][column+2*deltaColumn]))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public Player getWinner()
	{
		
		//Lines and columns
		for (int i = 0; i <= 2; i++)
		{
			if (this.wins(this.player1, i, 0, 0, 1) ||this.wins(this.player1, 0, i, 1, 0))
			{
				return this.player1;
			}
				
		}
		
		for (int i = 0; i <= 2; i++)
		{
			if (this.wins(this.player2, i, 0, 0, 1) ||this.wins(this.player2, 0, i, 1, 0))
			{
				return this.player2;
			}
				
		}
		
		//Diagonals
		
		if (this.wins(this.player1, 0, 0, 1, 1) || this.wins(this.player1, 2, 0, -1, 1))
		{
			return this.player1;
		}
		
		if (this.wins(this.player2, 0, 0, 1, 1) || this.wins(this.player2, 2, 0, -1, 1))
		{
			return this.player2;
		}
		
		return null;
	}
	
	public String situationToString()
	{
		return("Insert table here");
	}
	
	public String moveToString()
	{
		return(this.currentPlayer + " takes square at  [] []");
	}
	
	public boolean isOver()
	{
		if ((this.getWinner() == player1) || (this.getWinner() == player2))
		{
			return true;
		}
		//Need to check if the game is a tie or if still ongoing.
		//We do this by checking if there's still an empty square left.
		
		for (int a = 0; a < 3; a++)
		{
			for (int b = 0; b < 3; b++)
			{
				if (this.grid[a][b] == null)
						{
						return false;
						}
			}
		}
		return true;
	}
	

}
