package games;

import java.util.*;
import players.*;

public interface Game {

	public void execute(int moveNum);
	public Player getCurrentPlayer();
	public boolean isValid(int moveNum);
	public ArrayList<Integer> validMoves();
	public Player getWinner();
	public boolean isOver();
	public String moveToString(int move);
	public String situationToString();
	
	public Game copy();
	
}
