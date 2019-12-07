package Game;

import Cards.Interfaces.ICard;
import Enumerations.CardColor;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This is the pile on the table.
 * It stores all cards that were played and shows the top card
 */
public class DiscardPile {

    private ArrayList<ICard> cards;
    private ICard topCard;
    CardColor wishedColor;
    private PlayerQueue playerQueue;

    /**
     * @param card is any card that would liked to be placed on the pile
     * @return is a boolean that indicates if a card can be put on the pile
     */
    boolean isLegalNextCard(ICard card) {
        return true;
    }

    /**
     * @param color the color the next card must be legal on top of.
     *
     * Method gets called if a player wishes for a new color
     */
    void setLegalNextColor(CardColor color) {

    }

    /**
     * @param cardsToDraw numbers of cards the next player has to draw
     *
     * tell the next player to draw
     */
    void tellNextPlayerToDraw(int cardsToDraw) {

    }

    /**
     * tell the queue to skip
     */
    void skipOnePlayer() {

    }

    /**
     * Tell the queue to reverse
     */
    void reversePlayerOrder() {

    }

    /**
     * @return the cards that have been played, excluding the top one
     */
    ArrayList<ICard> getUsedCards() {

        return null;
    }
}