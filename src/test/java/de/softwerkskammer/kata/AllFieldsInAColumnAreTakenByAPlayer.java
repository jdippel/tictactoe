
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
@DisplayName("game is over when all fields in a column are taken by one player")
public class AllFieldsInAColumnAreTakenByAPlayer {  
    
    @Test
    @DisplayName("For a decided board with a column marked by one player the game is over")
    public void givenAnBoardWithAMarkedColumn_ThenTheGameIsOver( ) {
       
        assertThat( Board.create().move("Center").move("NE").move("N").move("SE").move("S").isGameOver() )
                         .as("for a decided board with marked column the game is over").isTrue();
    }
}


