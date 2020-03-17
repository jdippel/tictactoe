package de.softwerkskammer.kata;


public enum Field {
    
    NORTH_WEST( "NW" ), NORTH( "N" ), NORTH_EAST( "NE"),
    WEST( "W" ), CENTER( "Center" ), EAST( "E" ),
    SOUTH_WEST( "SW" ), SOUTH( "S" ), SOUTH_EAST( "SE" );
    
    // ---
    
    String shortName;
    
    private Field( String shortName ) { this.shortName = shortName; }
    private String getShortName()     { return this.shortName; }
    
    // ---

    public static int numberOfFields() {
        return values().length;
    }
    
    public static Field getField( String name ) {
        for( Field element : Field.values() ) {
            String shortName = element.getShortName();
            if( shortName.equalsIgnoreCase( name ) ) return element;
        }
        return null;
    }
}
