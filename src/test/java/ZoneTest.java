import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZoneTest {

    @Test
    public void test_position_and_state(){
        Zone z = new Zone(1,2, Etat.Submergée);
        assertEquals(1,z.getX());
        assertEquals(2,z.getY());
        assertEquals(Etat.Submergée,z.getEtat());
    }

    @Test
    public void test_position_and_state_NotValid(){
        Zone z = new Zone(2,3, Etat.Inondée);
        assertEquals(2, z.getX());
        assertNotEquals(1,z.getY());
        assertNotEquals(Etat.Submergée, z.getEtat());
    }


}
