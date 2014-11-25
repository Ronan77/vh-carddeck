import Deck
import Card

// The 52-card Deck
Deck deck = new Deck()

// Defining each player for printing
println("\n\n\n\n\n\n\n\n\n\n\n\n----------------------------------------\nWelcome to 21! By: Ronan_77 (Alain Nuñez)\n-- Dealer Edition\n----------------------------------------\n\n\n\n")

Scanner scan = new Scanner (System.in)

def player1 = "Alain"
def player2 = "Dealer"

def hand1 = []
def hand2 = []

int player1GamesWon = 0
int player2GamesWon = 0

int handSize = 2
int numPlayers = 2

//Delcare the amount of games there will be
println("- How many games would you like to play?\n")
int numGames = scan.nextInt()

//Make sure the games are a positive number, if not, set it to (1)
int games = 1
if (numGames < 1)
    numGames = 1

for (int i = 0; i < numGames; i++)
{
    //Shuffle and declare random cards each reset of a match
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
    //Visually shows the change in a match
    println("\n------------------------ Game " + games + "/" + numGames + " ------------------------\n")


    while (player1Play == 1 || player2Play == 1)
    {
        //Shows Current Scores
        /*for (int a = 0; a < 1 + handNum1; a++)
        {
            if (hand1[a].rank == 11 && (pointP1 > 21))
            {
                hand1[a].rank = 1
                pointP1 -= 10
            }
        }
        for (int a = 0; a < 1 + handNum2; a++)
        {
            if (hand2[a].rank == 11 && (pointP2 > 21))
            {
                hand2[a].rank = 1
                pointP2 -= 10
            }
        }*/
        println("------------------------------------------------\n" + player1 + " has " + pointP1 + " points " + hand1 + "\n" + player2 + " has " + pointP2 + " points " + hand2  + "\n------------------------------------------------" + "\n")
        //Game Logic (Probably a bunch in unnesesary)
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
        //Point logic if below 20
        if (pointP1 < 21 && pointP2 < 21)
        {
            //Player1's choice to have a new card
            println("- " + player1 + " would you like to get a new card? (1 = Yes, 2 = No)\n")
            player1Play = scan.nextInt()
            //Say if they answered No
            if (player1Play >= 2)
            {
                player1Play = 2
                println(player1 + " answered No\n")
            }
            //Say if they answered Yes
            else 
            {
                println(player1 + " answered Yes\n")
                hand1.add(deck.deal(1))
                pointP1 += hand1[1+handNum1].rank
                handNum1++
            }
            println("- " + player2 + " would you like to get a new card? (1 = Yes, 2 = No)\n")
            //Dealer Logic
            if (pointP2 <= 15)
                player2Play = 1
            else if (pointP2 > 15)
            {
                player2Play = (int)(Math.random()*10)+1
                if (player2Play > 2)
                    player2Play = 2
                else if (player2Play <= 2)
                    player2Play = 1
            }
            //Say if Dealer asnwered No
            if (player2Play >= 2)
            {
                player2Play = 2
                println(player2 + " answered No\n")
            }
            //Say if Dealer answered Yes
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
    if (numGames > 1)
    games++
}
//If the amount of games that was declared is above 1, print out the majority score for the multiple matches
if (numGames > 1)
{
    println("\n------------------------ Scores ------------------------\n")
    if (player1GamesWon > player2GamesWon)
        println(player1 + " has won " + player1GamesWon + " out of " + numGames + " games!")
    else if (player2GamesWon > player1GamesWon)
        println(player2 + " has won " + player2GamesWon + " out of " + numGames + " games!")
    else if (player2GamesWon == player1GamesWon)
    {
        if (!(numGames/2 > 1))
            println("It's a Tie! " + player1 + " and " + player2 + " have won " + (numGames/2) + " game each")
        else
            println("It's a Tie! " + player1 + " and " + player2 + " have won " + (numGames/2) + " games each")
    }
}
println("\n------------------------ End ------------------------\n")




