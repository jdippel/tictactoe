package de.softwerkskammer.kata;

import java.util.Arrays;
import java.util.List;

public class Row extends Line {

    Row( List<Field> line ) {
        super( line );
    }
    
    static List<Line> define() {
        return Arrays.asList( 
                Line.createLine( Arrays.asList( Field.getField("NW"), Field.getField("N"),      Field.getField("NE") )),
                Line.createLine( Arrays.asList( Field.getField("W"),  Field.getField("Center"), Field.getField("E") )),
                Line.createLine( Arrays.asList( Field.getField("SW"), Field.getField("S"),      Field.getField("SE") )));
    }
}
