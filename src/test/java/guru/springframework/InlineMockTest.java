package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class InlineMockTest {

    @Test
    void testInlineMock(){
        Map mockMap = mock(Map.class);
        assertEquals(mockMap.size(), 0);
    }
}
