package ru.netology.aviasales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(123, 1100, "MSK", "SPB", 95);
    Ticket ticket2 = new Ticket(124, 1000, "MSK", "SPB", 100);
    Ticket ticket3 = new Ticket(125, 10_000, "SPB", "LA", 250);
    Ticket ticket4 = new Ticket(126, 1000, "SPB", "MSK", 111);
    Ticket ticket5 = new Ticket(127, 15_000, "MSK", "UG", 150);
    Ticket ticket6 = new Ticket(128, 20_000, "UG", "LA", 249);
    Ticket ticket7 = new Ticket(129, 800, "MSK", "SPB", 222);
    Ticket ticket8 = new Ticket(122, 11_000, "UA", "UB", 186);

    @Test
    public void testRemoveById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.removeById(122);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket4);
        repo.findById(ticket4.getId());

        Ticket[] expected = {ticket4};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindAllTickets() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSaveTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket7);

        Ticket[] expected = {ticket7};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testNotFoundException() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }
}