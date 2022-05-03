package games;

import java.util.*;
import players.*;

public class TicTacToeWithHints extends TicTacToe{
	
	public TicTacToeWithHints(Player player1, Player player2)
	{
		super(player1, player2);
	}

	
	public ArrayList<Integer> hints()
	{
		int listIterate = 0;
		ArrayList<Integer> hintList = new ArrayList<Integer>();
		
		
		//Get the list of empty squares.
			
		
		//Scan each square in the grid.
		
		Player oppositePlayer = this.player1;
		
		if (this.currentPlayer == this.player1)
		{
			oppositePlayer = this.player2;
		}
		else if (this.currentPlayer == this.player2)
		{
			oppositePlayer = this.player1;
		}
		
		
		for (int a = 0; a < 3; a++)
		{
			for (int b = 0; b < 3; b++)
			{
						
				
				//If the current square is empty...
				if (this.grid[a][b] == null)
				{
					//...Fill it temporarily with the current player...
					this.grid[a][b] = oppositePlayer;
					//...And see if it can result in a win.
					if (this.getWinner() == oppositePlayer)
					{
						//If it does, add it to the list.
						hintList.add(listIterate);
					
						
					}
					//And don't forget to undo the move!
					this.grid[a][b] = null;
					
				}
				listIterate += 1;
			}
		}
		return hintList;
	}
}
