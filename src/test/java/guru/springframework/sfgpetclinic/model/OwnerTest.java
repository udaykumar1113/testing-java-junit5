package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void dependentAssertions(){
        Owner owner = new Owner(2L, "Joe", "Silva");
        owner.setCity("Arlington");
        owner.setAddress("Texas");

        assertAll("Properties Test",
                () -> assertAll("person properties",
                    ()->assertEquals("Joes", owner.getFirstName()),
                    ()->assertEquals("Silva", owner.getLastName())),
                () -> assertAll("owner properties",
                    ()->assertEquals("Arlingtons", owner.getCity()),
                    ()->assertEquals("Texas", owner.getAddress())));
    }
}