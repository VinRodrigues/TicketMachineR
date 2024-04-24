

import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vm114
 */
public class PapelMoedaTest {
    
    @Test
    public void testGetValor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor());
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(5, papelMoeda.getQuantidade());
    }
}
