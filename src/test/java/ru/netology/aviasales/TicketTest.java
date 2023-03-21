package ru.netology.aviasales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketTest {
    Ticket ticket1 = new Ticket(123, 1100, "MSK", "SPB", 95);
    Ticket ticket2 = new Ticket(124, 1000, "MSK", "SPB", 100);
    Ticket ticket3 = new Ticket(125, 10_000, "SPB", "LA", 350);
    Ticket ticket4 = new Ticket(126, 1000, "SPB", "MSK", 111);
    Ticket ticket5 = new Ticket(127, 15_000, "MSK", "UG", 150);
    Ticket ticket6 = new Ticket(128, 20_000, "UG", "LA", 249);
    Ticket ticket7 = new Ticket(129, 800, "MSK", "SPB", 222);
    Ticket ticket8 = new Ticket(122, 11_000, "UA", "UB", 186);


    @Test
    public void compareToExpensiveFromThisTickets() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToCheaperFromThisTickets() {
        int expected = -1;
        int actual = ticket7.compareTo(ticket6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToSamePrice() {
        int expected = 0;
        int actual = ticket2.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }
}