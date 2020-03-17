
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
@DisplayName("game is over when all fields are taken")
public class AllFieldsAreTaken {  
    
    @Test
    @DisplayName("For a given initial board the game is not over")
    public void givenAnInitialBoard_ThenTheGameIsNotOver( ) {
       
        assertThat( Board.create().isGameOver() ).as("for an initial board the game is not over").isFalse();
    }
    
    @Test
    @DisplayName("For an undecided board the game is not over")
    public void givenAnBoardWithMovesButUndecided_ThenTheGameIsNotOver( ) {
       
        assertThat( Board.create().move("Center").move("NE").move("SW").move("NW").isGameOver() ).as("for an undecided board with moves the game is not over").isFalse();
    }
    
    @Test
    @DisplayName("For a decided board the game is over")
    public void givenAnBoardWithNineMoves_ThenTheGameIsOver( ) {
       
        assertThat( Board.create().move("Center").move("NE").move("SW").move("NW").move("N").move("S").move("E").move("W").move("SE").isGameOver() )
                         .as("for a decided board with nine moves the game is over").isTrue();
    }
}


