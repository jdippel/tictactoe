package de.softwerkskammer.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Line {

    private List<Field> line;
    
    Line( List<Field> line ) {
        this.line = line;
    }
    
    private List<Field> getLine()              { return this.line; }
    private Field getLineElement( int cursor ) { return getLine().get( cursor ); }
    
    static Line createLine( List<Field> fields ) {
        return new Line( fields );
    }
    
    static List<Line> define() {
        return concatenateLists( Column.define(), concatenateLists( Row.define(),  Diagonal.define() ));
    }
 
    private static List<Line> concatenateLists( List<Line> head, List<Line> tail ) {
        List<Line> list = new ArrayList<>();
        list.addAll( head );
        list.addAll( tail );
        return list;
    }

    public boolean isLineTaken( List<Field> fields ) {
        return fields.contains( getLineElement( 0 ) ) && fields.contains( getLineElement( 1 ) ) && fields.contains( getLineElement( 2 ) );
    }
    
    public boolean isLineTaken( Supplier<List<Field>> function ) {
        return isLineTaken( function.get() );
    }
    
    public String toString() {
        return String.format( "[%s, %s, %s]", line.get(0), line.get(1), line.get(2) );
    }
}
