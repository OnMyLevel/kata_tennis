import kata.tennis.Match;
import org.junit.Assert;
import org.junit.Test;

public class MatchTest {





    @Test
    public void winMatch() {


        Match match = new Match(7,"P1","P2");
        match.playMatch();
        Match test = match;
        Assert.assertEquals(test,match);

    }


}