import Deck
import Card

// The 52-card Deck
Deck deck = new Deck()

// Defining each player for printing
println("\n\n\n\n\n\n\n\n\n\n\n\n----------------------------------------\nWelcome to 21! By: Ronan_77 (Alain Nuñez)\n----------------------------------------\n\n\n\n")

Scanner scan = new Scanner (System.in)

//Declare the player names
def player1 = "Alain"
def player2 = "John"

def hand1 = []
def hand2 = []

int player1GamesWon = 0
int player2GamesWon = 0

int handSize = 2
int numPlayers = 2

//Declare the amount of games to play
println("- How many games would you like to play?\n")
int numGames = scan.nextInt()

//Checks if the amount of games is a positive number, if not set it to (1)
int games = 1
if (numGames < 1)
    numGames = 1

for (int i = 0; i < numGames; i++)
{
    //Shuffle cards, randomly select cards each match
    deck.reset()
    deck.shuffle()
    hand1 = deck.deal(handSize)
    hand2 = deck.deal(handSize)
    int gameWon = 0
    def hands = [hand1, hand2]
    def players = [player1, player2]
    int pointP1 = hand1[0].rank + hand1[1].rank
    int pointP2 = hand2[0].rank + hand2[1].rank
    int player1Play = 1
    int player2Play = 1
    int handNum1 = 1
    int handNum2 = 1
    int ties = 0
    //Visually sepearates games
    println("\n------------------------ Game " + games + "/" + numGames + " ------------------------\n")

    while (player1Play == 1 || player2Play == 1)
    {
        //Shows current scores
        println("------------------------------------------------\n" + player1 + " has " + pointP1 + " points " + hand1 + "\n" + player2 + " has " + pointP2 + " points " + hand2  + "\n------------------------------------------------" + "\n")
        //Game logic
        if ((pointP1 < 21) && (pointP2 > 21))
        {
            gameWon = 1
        }
        else if ((pointP1 > 21) && (pointP2 < 21))
        {
            gameWon = 2
        }
        else if ((pointP1 > pointP2) && ((pointP1 < 21) && (pointP2 < 21)))
        {
            gameWon = 1
        }
        else if ((pointP1 < pointP2) && ((pointP1 < 21) && (pointP2 < 21)))
        {
            gameWon = 2
        }
        else if ((pointP1 < pointP2) && ((pointP1 > 21) && (pointP2 > 21)))
        {
            gameWon = 1
        }
        else if ((pointP1 > pointP2) && ((pointP1 > 21) && (pointP2 > 21)))
        {
            gameWon = 2
        }
        else if (pointP1 == 21)
        {
            gameWon = 1
        }
        else if (pointP2 == 21)
        {
            gameWon = 2
        }
        else if (pointP1 == pointP2)
        {
            gameWon = 0
        }
        //Point logic if there is not a losing or winning point
        if (pointP1 < 21 && pointP2 < 21)
        {
            //Asks player1 if they like to hit or stand
            println("- " + player1 + " would you like to get a new card? (1 = Yes, 2 = No)\n")
            player1Play = scan.nextInt()
            //Prints if player1 answered Stand
            if (player1Play >= 2)
            {
                player1Play = 2
                println(player1 + " answered No\n")
            }
            //Prints if player1 answer Hit
            else 
            {
                println(player1 + " answered Yes\n")
                hand1.add(deck.deal(1))
                pointP1 += hand1[1+handNum1].rank
                handNum1++
            }
            //Asks player1 if they like to hit or stand
            println("- " + player2 + " would you like to get a new card? (1 = Yes, 2 = No)\n")
            player2Play = scan.nextInt()
            //Prints i2 player2 answer Stand
            if (player2Play >= 2)
            {
                player2Play = 2
                println(player2 + " answered No\n")
            }
            //Prints if player2 answer Hit
            else
            {
                println(player2 + " answered Yes\n") 
                hand2.add(deck.deal(1))
                pointP2 += hand2[1+handNum2].rank
                handNum2++
            }
        }
        //Cut out of the loop if one of two points are above 20
        else 
        {
            player1Play = 2 
            player2Play = 2
        }
    }
    //Print out what player has won in that one match
    if (gameWon == 1)
    {
        println(">>>------------------------<<<\n" + player1 + " has won the game!" + "\n>>>------------------------<<<")
        player1GamesWon++
    }
    else if (gameWon == 2)
    {
        println(">>>------------------------<<<\n" + player2 + " has won the game!" + "\n>>>------------------------<<<")
        player2GamesWon++
    }
    else if (gameWon == 0)
        println("Tie!")
        ties++
    if (numGames > 1)
        games++
}
//If the amount of games that was declared is above 1, print out the majority score for the multiple matches
if (numGames > 1)
{
    println("\n------------------------ Scores ------------------------\n")
    if (player1GamesWon > player2GamesWon)
    {
        if (ties == 0)
            println(player1 + " has won " + player1GamesWon + " out of " + numGames + " games!")
        else
            println(player1 + " has won " + player1GamesWon + " out of " + numGames + " games! With " + ties + " Tie(s)!")
    }
    else if (player2GamesWon > player1GamesWon)
    {
        if (ties == 0)
            println(player2 + " has won " + player2GamesWon + " out of " + numGames + " games!")
        else 
            println(player2 + " has won " + player2GamesWon + " out of " + numGames + " games! With " + ties + " Tie(s)!" )
    }
    else if (player2GamesWon == player1GamesWon)
    {
        if (!(numGames/2 > 1))
        {
            if (ties == 0)
                println("It's a Tie! " + player1 + " and " + player2 + " have won " + (numGames/2) + " game each")
            else
                println("It's a Tie! " + player1 + " and " + player2 + " have won " + ((numGames-1)/2) + " game each. With " + ties + " Tie!")
        }
        else
        {
            if (ties == 0)
                println("It's a Tie! " + player1 + " and " + player2 + " have won " + (numGames/2) + " games each")
            else
                println("It's a Tie! " + player1 + " and " + player2 + " have won " + (numGames/2) + " games each. With " + ties + " Tie(s)!")
        }
    }
}
println("\n------------------------ End Game ------------------------\n")
























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
println(player1 + ": " + player1GamesWon + " games, " + player2 + ": " + player2GamesWon + " games")
*/
