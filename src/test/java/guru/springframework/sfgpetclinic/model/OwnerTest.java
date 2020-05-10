package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    static Stream<Arguments> getargs() {
        return Stream.of(
                Arguments.of("FL", 5, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 5));
    }
}