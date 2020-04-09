package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;
    @BeforeEach
    void setup(){
        indexController = new IndexController();
    }
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("indexd", indexController.index(), "wrong view returned");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()),
                () -> "This is a expensive method");
    }
}