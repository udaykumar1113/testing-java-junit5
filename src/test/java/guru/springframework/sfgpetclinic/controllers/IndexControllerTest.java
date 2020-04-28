package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    IndexController indexController;
    @BeforeEach
    void setup(){
        indexController = new IndexController();
    }
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "wrong view returned");
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

    @Disabled
    @Test
    @DisplayName("Normal Timeout Test")
    void testTimeout(){
        assertTimeout(Duration.ofMillis(200),() -> { Thread.sleep(5000);});
    }

    @Disabled
    @Test
    @DisplayName("Preemptive Timeout Test")
    void testPreemptiveTimeout(){
        assertTimeoutPreemptively(Duration.ofMillis(200),() -> { Thread.sleep(5000);});
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_9)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "udayk")
    @Test
    void testIfUserUday() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "fred")
    @Test
    void testIfUserFred() {
    }
}