package shopstyle.mscustomer.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderEnumTest {

    @Test
    void values() {
        GenderEnum[] expectedValues = {GenderEnum.MASCULINO, GenderEnum.FEMININO};
        GenderEnum[] actualValues = GenderEnum.values();
        assertEquals(expectedValues.length, actualValues.length);
        for (int i = 0; i < expectedValues.length; i++) {
            assertEquals(expectedValues[i], actualValues[i]);
        }
    }

    @Test
    void valueOf() {
        assertEquals(GenderEnum.MASCULINO, GenderEnum.valueOf("MASCULINO"));
        assertEquals(GenderEnum.FEMININO, GenderEnum.valueOf("FEMININO"));
    }

    @Test
    void valueOf_invalidValue() {
        assertThrows(IllegalArgumentException.class, () -> GenderEnum.valueOf("INVALID"));
    }
}