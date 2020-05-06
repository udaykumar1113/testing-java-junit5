package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
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

    @ParameterizedTest(name="{displayName} - [{index}] - {arguments}")
    @DisplayName("Enum Source Test")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @ParameterizedTest(name="{displayName} - [{index}] - {arguments}")
    @DisplayName("CSV Source Test")
    @CsvSource({"FL, 1, 1",
    "OH, 2, 2",
    "MI, 3, 3"})
    void testCSVSource(String stateName, int val1, int val2){
        System.out.println(stateName+" "+val1+":"+val2);
    }
}