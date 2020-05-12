package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertion() {
        //given
        Person person = new Person(1l, "Joe", "Silva");
        //then
        assertAll("Test set",
                ()->assertEquals("Joe", person.getFirstName()),
                ()->assertEquals("Silva", person.getLastName()));
    }

    @Test
    void groupedAssertionMessages() {
        //given
        Person person = new Person(1l, "Joe", "Silva");
        //then
        assertAll("Test set",
                ()->assertEquals("Joe", person.getFirstName(),"Wrong Fist name"),
                ()->assertEquals("Silva", person.getLastName(), "Wrong Last Name"),
                ()->assertEquals("Silva", person.getLastName(), "Wrong Last Name"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        //todo - impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition());
    }
}