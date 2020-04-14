package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;
    @BeforeEach
    void setup(){
        indexController = new IndexController();
    }
    @Test
    void index() {
        assertEquals("indexd", indexController.index());
        assertEquals("indexx", indexController.index(), "wrong view returned");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()),
                () -> "This is a expensive method");
    }

    @Test
    @DisplayName("Exception Test of ValueNotFoundException")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class,() -> indexController.oopsHandler());
    }

    @Test
    @DisplayName("Normal Timeout Test")
    void testTimeout(){
        assertTimeout(Duration.ofMillis(200),() -> { Thread.sleep(5000);});
    }

    @Test
    @DisplayName("Preemptive Timeout Test")
    void testPreemptiveTimeout(){
        assertTimeoutPreemptively(Duration.ofMillis(200),() -> { Thread.sleep(5000);});
    }
}