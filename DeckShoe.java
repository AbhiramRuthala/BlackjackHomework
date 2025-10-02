/**
 * A stack of more than one deck of cards used in a casino game
 *
 */
public class DeckShoe {

    //An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;

    // you may need other instance variables here


    //Constructor: instantiates the number of decks specified and
    //adds them to the list of decks
    public DeckShoe(int numDecks) {
        //his.decks = numDecks > 0 ? new Deck[decks.length + numDecks] : null;
        if(numDecks <= 0){
            this.decks = new Deck[0];
        } else {
            this.decks = new Deck[numDecks];
            for(int i=0; i<numDecks; i++) {
                this.decks[i] = new Deck();
            }
        }

//        this.decks = numDecks;
//        decks. += numDecks;

    }


    //Deals the top card from the stack of decks and returns that Card.
    //You can implement this several ways, as long as it correctly
    //deals a card from one of the decks.
    //Important: if you've dealt the last card in all the decks, you'll want
    //to reshuffle all the decks and start over again
    public Card dealTopCard() {
        Card[] sense = new Card[decks.length];
        Card hand = new Card();
        for(int i = 0; i < decks.length; i++) {
            if(decks[i] != null) {
                sense[i] = decks[i].dealTopCard();
                hand = decks[i].dealTopCard();
                return hand;
                //return sense[i];
            } else {
                sense[i] = null;
                //return sense[i];
            }

            if(decks[i] != null && decks[i].cardsLeft() == 0) {

                //might have to run a loop function to see how many cards are left in every stack.
                decks[i].restockDeck();
            }

            //return sense;

            //return hand;
            //return sense[i];

        }
    }

    //Reshuffles all of the decks.
    protected void restoreDecks() {
        Deck newDeck = new Deck();
        for(int j = 0; j < decks.length; j++) {
            newDeck = decks[j];
            if(newDeck == null) {

            } else{
                newDeck.shuffle();
            }


        }
//            for(int i = 0; i < deck.length-1; i++) {
//                /*Get a random position between i and 51*/
//                int r = (int)(Math.random()*(52-i))+i;
//
//                /* Swap card i with that card */
//                Card temp = deck[i];
//                deck[i] = deck[r];
//                deck[r] = temp;
//            }

        }

    //returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {
        int sense = 0;
        for(int j = 0; j < decks.length; j++) {
            if(decks[j] != null && decks[j].cardsLeft() > 0) {
                sense += decks[j].cardsLeft();
            } else if(decks[j] == null){
                sense =sense;
            }
        }

        return sense;
    }

}

