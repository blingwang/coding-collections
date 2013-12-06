public class BlackJack {
    private int EvaluateHand(Hand hand)
    {
        int score = 0;
        for (Card currentCard in hand)
        {
            switch (currentCard.value)
            {
                case Value.Two:
                    score += 2;
                    break; 
                case Value.Three:
                    score += 3;
                    break;
                case Value.Four:
                    score += 4;
                    break;
                case Value.Five:
                    score += 5;
                    break;
                case Value.Six:
                    score += 6;
                    break;
                case Value.Seven:
                    score += 7;
                    break;
                case Value.Eight:
                    score += 8;
                    break;
                case Value.Nine:
                    score += 9;
                    break;
                case Value.Ten:
                case Value.Jack:
                case Value.Queen:
                case Value.King:
                    score += 10;
                    break;
                case Value.Ace:
                    score += 11;
                    break; 

            }

        }

        // after evaluating with 11 for each ace, if score has busted, then change each ace value from 11 to 1
        if (score > 21)
        {   // if our evaluated score is over 21, subtract 10 foreach ace in the hand. 
            foreach (Card currentAceCheckCard in hand)
            {
                if (score <= 21)
                {   // if we've subtracted enough until we're not busted, then break and return value
                    break;
                }
                
                if (currentAceCheckCard.value == Value.Ace)
                {
                    score -= 10;
                }
            }
        }
        
        return score; 
    } 
}
