/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class TicketMachineTest {
    
       @Test
    public void testInserirPapelMoedaInvalido() {
        try {
            TicketMachine ticketMachine = new TicketMachine(10);
            ticketMachine.inserir(3); // Papel moeda inválido
            fail("Deveria ter lançado uma PapelMoedaInvalidaException");
        } catch (PapelMoedaInvalidaException e) {
            // Esperado, nada a fazer aqui
        }
    }

    @Test
    public void testImprimirSemSaldoSuficiente() throws PapelMoedaInvalidaException {
        try {
            TicketMachine ticketMachine = new TicketMachine(20);
            ticketMachine.inserir(10);
            ticketMachine.imprimir(); // Saldo insuficiente
            fail("Deveria ter lançado uma SaldoInsuficienteException");
        } catch (SaldoInsuficienteException e) {
            // Esperado, nada a fazer aqui
        }
    }

    @Test
    public void testFornecerTrocoImpossivel() throws PapelMoedaInvalidaException {
        TicketMachine ticketMachine = new TicketMachine(20);
        ticketMachine.inserir(50);
        try {
            ticketMachine.imprimir(); // Saldo restante: 30
            ticketMachine.getTroco(); // Não há cédulas disponíveis para o troco
            fail("Deveria ter lançado uma RuntimeException");
        } catch (RuntimeException e) {
            // Esperado, nada a fazer aqui
        } catch (SaldoInsuficienteException e) {
            fail("Não deveria ter lançado uma SaldoInsuficienteException");
        }
    }
    @Test
public void testInserirPapelMoedaValido() throws PapelMoedaInvalidaException {
    TicketMachine ticketMachine = new TicketMachine(10);
    ticketMachine.inserir(10); // Papel moeda válido
    assertEquals(10, ticketMachine.getSaldo());
}

@Test
public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
    TicketMachine ticketMachine = new TicketMachine(20);
    ticketMachine.inserir(20);
    String ticket = ticketMachine.imprimir();
    String expectedTicket = "*****************\n" +
                            "*** R$ 20,00 ****\n" +
                            "*****************\n";
    assertEquals(expectedTicket, ticket);
    assertEquals(0, ticketMachine.getSaldo());
}
@Test
public void testFornecerTroco() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
    TicketMachine ticketMachine = new TicketMachine(10);
    ticketMachine.inserir(20);
    // Imprimir o ticket para deduzir o saldo
    ticketMachine.imprimir();
    // Obter o troco
    Iterator<Integer> troco = ticketMachine.getTroco();
    List<Integer> expectedTroco = Arrays.asList(10);
    List<Integer> actualTroco = new ArrayList<>();
    while (troco.hasNext()) {
        actualTroco.add(troco.next());
    }
    assertEquals(expectedTroco, actualTroco);
    assertEquals(0, ticketMachine.getSaldo());
}
}
