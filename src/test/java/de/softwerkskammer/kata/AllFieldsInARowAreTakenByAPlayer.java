
package de.softwerkskammer.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * Kata for tic tac toe game (2020-02-06)
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("game is over when all fields in a row are taken by one player")
public class AllFieldsInARowAreTakenByAPlayer {  
    
    @Test
    @DisplayName("For a decided board with a row marked by one player the game is over")
    public void givenAnBoardWithAMarkedRow_ThenTheGameIsOver( ) {
       
        assertThat( Board.create().move("Center").move("NE").move("W").move("SE").move("E").isGameOver() )
                         .as("for a decided board with marked row the game is over").isTrue();
    }
    
    @Test
    @DisplayName("For a decided board with a row marked by the second player the game is over")
    public void givenAnBoardWithAMarkedRowOfSecondPlayer_ThenTheGameIsOver( ) {
       
        assertThat( Board.create().move("Center").move("NE").move("SW").move("Nw").move("E").move("N").isGameOver() )
                         .as("for a decided board with marked row the game is over").isTrue();
    }
}


