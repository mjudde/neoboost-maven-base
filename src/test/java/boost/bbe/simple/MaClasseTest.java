package boost.bbe.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaClasseTest {
    @Test
    void testMaMethode() {
        MaClasse mc = new MaClasse();
        Assertions.assertTrue(mc.isEmpty(null));
        Assertions.assertTrue(mc.isEmpty(List.of()));
        Assertions.assertFalse(mc.isEmpty(List.of("A")));
    }
}
