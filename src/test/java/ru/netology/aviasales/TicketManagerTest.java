package ru.netology.aviasales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(123, 1100, "MSK", "SPB", 95);
    Ticket ticket2 = new Ticket(124, 1000, "MSK", "SPB", 100);
    Ticket ticket3 = new Ticket(125, 10_000, "SPB", "LA", 350);
    Ticket ticket4 = new Ticket(126, 1000, "SPB", "MSK", 111);
    Ticket ticket5 = new Ticket(127, 15_000, "MSK", "UG", 150);
    Ticket ticket6 = new Ticket(128, 20_000, "UG", "LA", 249);
    Ticket ticket7 = new Ticket(129, 800, "MSK", "SPB", 222);
    Ticket ticket8 = new Ticket(122, 11_000, "UA", "UB", 186);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

    }

    @Test
    public void shouldFindAllTicketsFromCheapToExpensiveInOneDirection() {
        Ticket[] expected = {ticket7, ticket2, ticket1};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNonexistentTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("UB", "UA");

        Assertions.assertArrayEquals(expected, actual);
    }
}