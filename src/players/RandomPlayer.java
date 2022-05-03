package players;

import java.util.*;
import games.*;

public class RandomPlayer implements Player{

	Random generator = new Random();
	
	public RandomPlayer(Random inputRandom)
	{
		this.generator = inputRandom;
	}
	
	public int chooseMove(Game inputGame)
	{
		ArrayList<Integer> moveList = inputGame.validMoves();
		int randomPick = generator.nextInt(moveList.size());
		return moveList.get(randomPick);
	}
	
	@Override
	public String toString()
	{
		return ("Player n° " + this.hashCode());
	}
}
