package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void dependentAssertions(){
        Owner owner = new Owner(2L, "Joe", "Silva");
        owner.setCity("Arlington");
        owner.setAddress("Texas");

        assertAll("Properties Test",
                () -> assertAll("person properties",
                    ()->assertEquals("Joe", owner.getFirstName()),
                    ()->assertEquals("Silva", owner.getLastName())),
                () -> assertAll("owner properties",
                    ()->assertEquals("Arlington", owner.getCity()),
                    ()->assertEquals("Texas", owner.getAddress())));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Testing", "Guru"})
    void testValueSource(String values){
        System.out.println(values);
    }
}