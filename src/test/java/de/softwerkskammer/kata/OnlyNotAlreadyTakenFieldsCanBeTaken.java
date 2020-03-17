
package de.softwerkskammer.kata;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
@DisplayName("as player can only take a field if it's not already taken")
public class OnlyNotAlreadyTakenFieldsCanBeTaken {  
    
    @Test
    @DisplayName("For an undecided board fields cannot be taken twice")
    public void alreadyTakenField_leadsToIllegalArgumentException() {
        
        assertThatExceptionOfType( IllegalArgumentException.class ).isThrownBy(() -> {Board.create().move("C").move("NE").move("SW").move("NE"); })
                                                                   .withMessageContaining("NE");
    }
}


