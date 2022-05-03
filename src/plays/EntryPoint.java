package plays;

import java.util.*;

import players.*;
import games.*;

public class EntryPoint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Negamax test with Nim");
		Human player1 = new Human("Human", scanner);
		NegamaxPlayer cpu = new NegamaxPlayer();
		
		Nim gameToTest = new Nim(7,3,player1,cpu);
		Orchestrator gameManager = new Orchestrator(gameToTest);
		gameManager.play();
	}
}
