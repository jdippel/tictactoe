package de.softwerkskammer.kata;

import java.util.Arrays;
import java.util.List;

public class Diagonal extends Line {

    Diagonal( List<Field> line ) {
        super( line );
    }
    
    static List<Line> define() {
        return Arrays.asList( 
                Line.createLine( Arrays.asList( Field.getField("NW"), Field.getField("Center"), Field.getField("SE") )),
                Line.createLine( Arrays.asList( Field.getField("SW"), Field.getField("Center"), Field.getField("NE") )));
    }
}
