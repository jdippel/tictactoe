package de.softwerkskammer.kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("the public method GameEvaluation evaluate( ) for class Board is tested")
public class Evaluate {

    @ParameterizedTest( name = "given a sequence of moves by {1} the expected evaluation result {0} is returned" )
    @MethodSource("enumAndListProvider")
    public void testWithMultiArgMethodSource( GameEvaluation expectedState, List<String> moves ) {
        
        Board board =  Board.create();
        for( String move : moves ) {
            board = board.move( move );
        }
        assertThat( board.evaluate() ).as( "evaluation result should match" ).isEqualTo( expectedState );
    }

    static Stream<Arguments> enumAndListProvider() {
        return Stream.of(
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "N" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "N", "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "N", "NW", "SE" ) ),
            Arguments.of( GameEvaluation.FirstPlayerHasWonWithColumn, Arrays.asList( "Center", "NE", "SW", "N", "NW", "SE", "W" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW"  ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "W" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "W", "S" ) ),            
            Arguments.of( GameEvaluation.FirstPlayerHasWonWithRow, Arrays.asList( "Center", "NW", "W", "S", "E" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE", "N" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE", "N", "NE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE", "N", "NE", "E" ) ),
            Arguments.of( GameEvaluation.FirstPlayerHasWonWithDiagonal, Arrays.asList( "Center", "NW", "SE", "N", "NE", "E", "SW" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE", "W" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE", "W", "NE" ) ),
            Arguments.of( GameEvaluation.SecondPlayerHasWonWithRow, Arrays.asList( "NW", "Center", "SE", "W", "NE", "E" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE", "NE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NW", "SE", "NE", "S" ) ),
            Arguments.of( GameEvaluation.SecondPlayerHasWonWithRow, Arrays.asList( "Center", "NW", "SE", "NE", "S", "N" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE", "N" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NW", "Center", "SE", "N", "SW" ) ),
            Arguments.of( GameEvaluation.SecondPlayerHasWonWithColumn, Arrays.asList( "NW", "Center", "SE", "N", "SW", "S" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NE", "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NE", "NW", "N" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NE", "NW", "N", "SE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "NE", "NW", "N", "SE", "S" ) ),
            Arguments.of( GameEvaluation.SecondPlayerHasWonWithDiagonal, Arrays.asList( "NE", "NW", "N", "SE", "S", "Center" ) ),
            
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "NW" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "NW", "N" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "NW", "N", "S" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "NW", "N", "S", "E" ) ),
            Arguments.of( GameEvaluation.GameIsRunning, Arrays.asList( "Center", "NE", "SW", "NW", "N", "S", "E", "W" ) ),
            Arguments.of( GameEvaluation.Draw, Arrays.asList( "Center", "NE", "SW", "NW", "N", "S", "E", "W", "SE" ) )
    ); }
}
