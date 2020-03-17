package de.softwerkskammer.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Board {
    
    List<String> history;

    private Board() {
        this.history = new ArrayList<>();
    }
    
    private Board( List<String> list ) {
        this.history = list;
    }
    
    public static Board create() {
        return new Board();
    }
    
    public Board move( String current ) {
        if ( this.history.contains( current )) {
            throw new IllegalArgumentException( current );
        }
        return createHistory( this.history, current );
    }
    
    private Board createHistory( List<String> past, String current ) {
        return new Board( addElementAtTailOfAListByCopying( past, current ) );
    }
    
    private List<String> addElementAtTailOfAListByCopying( List<String> past, String current ) {
        
        List<String> list = new ArrayList<>( past.size() + 1 );
        for( String entry : past ) {
            list.add( entry );
        }
        list.add( current );
        return list;
    }

    public boolean isGameOver() {
        return GameEvaluation.GameIsRunning != evaluate();
    }
    
    private boolean areAllFieldsTaken() {
        return history.size() == Field.numberOfFields();
    }
    
    private boolean areAllFieldsTakenInAColumn() {
        return Column.define().stream().anyMatch( isFilled );
    }
    
    private boolean areAllFieldsTakenInARow() {
        return Row.define().stream().anyMatch( isFilled );
    }
    
    private boolean areAllFieldsTakenInADiagonal() {
        return Diagonal.define().stream().anyMatch( isFilled );
    }

    private List<Field> createFields() {
        int numberOfMoves = this.history.size();
        int cursor = ( numberOfMoves + 1 ) % 2;
        List<Field> result = new ArrayList<>( numberOfMoves / 2 );
        while ( cursor < numberOfMoves ) {
            result.add( Field.getField( this.history.get( cursor ) ) );
            cursor += 2;
        }
        return result;
    }
    
    private Supplier<List<Field>> createFieldsUsedBytheCurrentPlayer = () -> createFields();
    
    private Predicate<Line> isFilled = x -> x.isLineTaken( createFieldsUsedBytheCurrentPlayer );
    


    public GameEvaluation evaluate() {
        
        int numberOfMoves = this.history.size();
        if( ( numberOfMoves % 2 ) == 1 ) { // player one
            if( areAllFieldsTakenInAColumn() )   return GameEvaluation.FirstPlayerHasWonWithColumn;
            if( areAllFieldsTakenInARow() )      return GameEvaluation.FirstPlayerHasWonWithRow;
            if( areAllFieldsTakenInADiagonal() ) return GameEvaluation.FirstPlayerHasWonWithDiagonal;
            
        }
        else { // player two
            if( areAllFieldsTakenInAColumn() )   return GameEvaluation.SecondPlayerHasWonWithColumn;
            if( areAllFieldsTakenInARow() )      return GameEvaluation.SecondPlayerHasWonWithRow;
            if( areAllFieldsTakenInADiagonal() ) return GameEvaluation.SecondPlayerHasWonWithDiagonal;
        }
        if( areAllFieldsTaken() ) return GameEvaluation.Draw;
        return GameEvaluation.GameIsRunning;
    }
}
