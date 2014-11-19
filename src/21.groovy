import Deck

// Simple UNO Rules:
// 1. 52 cards
// 2. No special cards (no plus cards, no reverse, no wild cards, no change color, etc).
// 3. 2 players
// 4. No user input (yet)
// 5. 7 cards per hand
// 6. Goal: to have 0 cards
// 7. Turn consists of:
//    a. Match suit or rank of card to top card on pile
//    b. If match (see a.) then discard one matching card
//    c. If no match, draw a card until you have a match (see a.)
// 8. If there are no card in the discard pile, then put one here face up from the draw pile
// 9. "UNO" does not need to be called 

// The 52-card Deck
Deck deck = new Deck()

// Defining each player for printing
def player1 = "Alain"
def player2 = "Nuñez"

def hand1 = []
def hand2 = []

int player1GamesWon = 0
int player2GamesWon = 0

int handSize = 2 // We COULD make this smaller
int numPlayers = 2
int numGames = 1
int gameWon = 0

// Play the game numGames times.
for (int i = 0; i < numGames; i++)
{
    deck.reset()
    deck.shuffle()
    hand1 = deck.deal(handSize)
    hand2 = deck.deal(handSize)
    def hands = [hand1, hand2]
    def players = [player1, player2]
    
    int pointP1 = hand1[0].rank + hand1[1].rank
    int pointP2 = hand2[0].rank + hand2[1].rank
    println(pointP1 + " " + pointP2)
    for (int a = 0; i < )
    if ((pointP1 < 21) && (pointP2 > 21))
    {
        gameWon = 1
    }
    else if ((pointP1 > 21) && (pointP2 < 21))
    {
        gameWon = 2
    }
}
 



























 /*   def drawPile = []
    // the pile that we match cards against and/or discard matching cards for each turn
    def discardPile = []

    def initialCard = deck.deal()
    discardPile.add(initialCard)

    // Put the rest of the deck down as the drawPile
    drawPile = deck.deal(deck.size())

    // Now we have two piles: the draw pile has 52-14 cards 
    // and the discard pile shows one card facing up

    int playerIndex = 0
    // The "game" loop. Each draw is a turn in the UNO game.
    // While any player has at least one card, we will keep playing
    while (hand1.size() > 0 && hand2.size() > 0)
    {
        // Get the current hand and player
        def currentHand = hands[playerIndex]
        def currentPlayer = players[playerIndex]

        // Get the next index
        playerIndex++
        playerIndex = playerIndex % numPlayers // example: 1 mod 2 is 1

        // Print out the current player and hand...
        println currentPlayer + " is playing with hand: " + currentHand

        // Get the next card to compare
        Card compareCard = discardPile[discardPile.size() - 1]

        Card matchedCard = null
        while (!matchedCard)
        {
            // Try to find a match for current player
            // We find the first match and that is also the highest card that matches
            // To do this, we sort the cards by "descending" rank. This is EASY in Groovy

            // Sort by rank and then reverse so get descending rank
            currentHand.collect().sort { it.rank } // TODO: There may be an issue here with aces for some reason
            currentHand = currentHand.reverse(true)

            for (Card h in currentHand)
            {
                // If the rank or suit matches, save the matched card and break
                if(h.compareRank(compareCard) == 0 || h.suit == compareCard.suit)
                {
                    matchedCard = h
                    currentHand.remove(h)
                    discardPile.add(h)
                    match = true
                    break // exit the loop
                }
                println "    draw"
            }

            // Refill the draw pile with the discard pile's cards if necessary...
            if (drawPile.isEmpty() && !discardPile.isEmpty())
            {
                Collections.shuffle(discardPile)
                drawPile.addAll(discardPile)
                discardPile.clear()
                def newInitialCard = drawPile.remove(drawPile.size() - 1)
                discardPile.add(newInitialCard)
            }
    
            // If no match, get a card from the draw pile and try again
            if(!matchedCard)
            {
                currentHand.add(drawPile.remove(drawPile.size() - 1))
            }
            else
            {
                println "    match found: " + matchedCard
            }
        }    
    }

    // Determine the winner!
    def winner
    def winnerCardCount = 0
    def loserCardCount = 0
    if (hand2.size() > hand1.size())
    {
        winner = player1
        winnerCardCount = hand1.size()
        loserCardCount = hand2.size()
        player1GamesWon++
    }
    else
    {
        winner = player2
        winnerCardCount = hand2.size()
        loserCardCount = hand1.size()
        player2GamesWon++
    }

    // Announce the winner of the game
    println ""
    println ">>>>> " + winner + " wins with " + winnerCardCount  + " vs " + loserCardCount + " cards"
}

println ""
// Announce the winner of the "best-of" series
println(player1 + ": " + player1GamesWon + " games, " + player2 + ": " + player2GamesWon + " games")*/
