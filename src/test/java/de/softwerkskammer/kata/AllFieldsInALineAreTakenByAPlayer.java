
package de.softwerkskammer.kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
* <p>
* Kata for tic tac toe game (2020-02-06)
* </p>
*
* @author    Jörg Dippel
* @version   February 2020
*
*/
@DisplayName("game is over when all fields in a line are taken by one player")
public class AllFieldsInALineAreTakenByAPlayer { 

    @ParameterizedTest( name = "given a board with moves {1} the game over predicate is {0}" )
    @MethodSource("booleanAndListProvider")
    public void testWithMultiArgMethodSource( boolean gameIsOver, List<String> moves ) {
        assertThat( createBoard( moves).isGameOver() ).as( "checking a marked line" ).isEqualTo( gameIsOver );
    }

    private Board createBoard( List<String> moves ) {
        
        Board result = Board.create();
        for ( String move : moves ) {
            result = result.move( move );
        }
        return result;
    }

    public static Stream<Arguments> booleanAndListProvider() {
        return Stream.of(
            
            Arguments.of( false, Arrays.asList( "Center", "N" ) ),
            Arguments.of( false, Arrays.asList( "Center" ) )
            
        ); }
}

