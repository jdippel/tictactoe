package de.softwerkskammer.kata;

import java.util.Arrays;
import java.util.List;

public class Column extends Line {

    Column( List<Field> line ) {
        super( line );
    }

    static List<Line> define() {
        return Arrays.asList( 
                Line.createLine( Arrays.asList( Field.getField("NW"), Field.getField("W"),      Field.getField("SW") )),
                Line.createLine( Arrays.asList( Field.getField("N"),  Field.getField("Center"), Field.getField("S") )),
                Line.createLine( Arrays.asList( Field.getField("NE"), Field.getField("E"),      Field.getField("SE") )));
    }
}
