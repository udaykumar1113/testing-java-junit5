package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

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
                ()->assertEquals("Joe1", person.getFirstName(),"Wrong Fist name"),
                ()->assertEquals("Silva", person.getLastName(), "Wrong Last Name"),
                ()->assertEquals("Silva1", person.getLastName(), "Wrong Last Name"));
    }

}