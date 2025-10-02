
/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */

// Name: Abhiram Ruthala
// Computing ID: kas4kj@virginia.edu
// Homework Name: Homework 4 - BlackJack
// Resources used: ChatGPT 5 for debugging

import java.util.*;

public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		return 10; //always bet 10
	}

	@Override
	public Move getMove() {
        Random r = new Random();
        Move move = null;

		/* Hits until we get a score of 16 or better */
		if(this.handScore() < 16) {
            move = Move.HIT;
            return Move.HIT;
        } else if(this.handScore() == 16) {
            String[] newList = {Move.HIT.toString(), Move.STAY.toString()};
            int sense = r.nextInt(newList.length);
            if(newList[sense].equals(Move.STAY.toString())) {
                move =  Move.STAY;
                return Move.STAY;
            } else if (newList[sense].equals(Move.HIT.toString())) {
                //String moveValue = Move.STAY.toString();
                move = Move.HIT;
                if (this.handScore() > 16 && this.handScore() < 19) {

                    String[] anotherChance = {Move.STAY.toString(), Move.HIT.toString(), Move.STAY.toString(), Move.STAY.toString(), Move.STAY.toString(), Move.STAY.toString(), Move.STAY.toString()};
                    int newIndex = r.nextInt(anotherChance.length);
                    if(anotherChance[newIndex].equals(Move.STAY.toString())) {
                        move = Move.valueOf(Move.STAY.toString());
                        return move;
                    } else{
                        move = Move.HIT;
                        return move;
                    }
                } else if(handScore() == 19) {
                    int newIndexSense = 0;
                    String[] bestOfLuck = {Move.STAY.toString(), Move.HIT.toString(), Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(),Move.STAY.toString(), Move.STAY.toString(), Move.STAY.toString()};
                    if (bestOfLuck[newIndexSense].equals(Move.STAY.toString())) {
                        move =  Move.STAY;
                        return Move.STAY;
                    } else if (bestOfLuck[newIndexSense].equals(Move.HIT.toString())) {
                        move = Move.HIT;
                        return Move.HIT;
                    }

                }

                else if(handScore() == 20 || handScore() == 21) {
                    move = Move.STAY;
                    return Move.STAY;
                }

                //return moveValue.notToString(); // have to fix this command here.
            } else {
                move =  Move.STAY;
                return Move.STAY;
            }
        }
        else {
            move =  Move.STAY;
		    return Move.STAY;
        }

        return move;

	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */

        for(int i = 0; i < dealerHand.length; i++) {
            if(dealerHand[i].getRank() == 10){

            }
        }
		
	}

	
}
