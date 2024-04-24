/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.core.PapelMoeda;
import java.util.Iterator;

/**
 *
 * @author vm114
 */
public class TrocoTest {

    @Test
    public void testSeparacaoDinheiro() {

        int valor = 187;
        Troco troco = new Troco(valor);
        PapelMoeda[] papeisMoeda = troco.papeisMoeda;

        assertNotNull(papeisMoeda);
        assertEquals(5, papeisMoeda.length);

        assertEquals(1, papeisMoeda[5].getQuantidade());
        assertEquals(1, papeisMoeda[4].getQuantidade());
        assertEquals(1, papeisMoeda[3].getQuantidade());
        assertEquals(1, papeisMoeda[2].getQuantidade());
        assertEquals(1, papeisMoeda[1].getQuantidade());

    }

    @Test
    public void testTrocoIterator() {

        Troco troco = new Troco(187);

        Iterator<PapelMoeda> iterator = troco.getIterator();

        int[] expectedValues = { 100, 50, 20, 5, 2 };

        for (int i = 0; i < expectedValues.length; i++) {
            assertTrue(iterator.hasNext());
            PapelMoeda papelMoeda = iterator.next();
            assertNotNull(papelMoeda);
            assertEquals(expectedValues[i], papelMoeda.getValor());
        }

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoIteratorValorZero() {

        Troco troco = new Troco(0);

        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNext() {
        Troco troco = new Troco(187);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        Troco troco = new Troco(187);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertEquals(100, iterator.next().getValor());
        assertEquals(50, iterator.next().getValor());
        assertEquals(20, iterator.next().getValor());
        assertEquals(10, iterator.next().getValor());
        assertEquals(5, iterator.next().getValor());
        assertEquals(2, iterator.next().getValor());
    }

}
