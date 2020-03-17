
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
@DisplayName("game is over when all fields in a diagonal are taken by one player")
public class AllFieldsInADiagonalAreTakenByAPlayer {  
    
    @Test
    @DisplayName("For a decided board with a diagonal marked by one player the game is over")
    public void givenAnBoardWithAMarkedDiagonal_ThenTheGameIsOver( ) {
       
        assertThat( Board.create().move("N").move("Center").move("W").move("NW").move("E").move("NE").move("SE").move("SW").isGameOver() )
                         .as("for a decided board with marked diagonal the game is over").isTrue();
    }
}


