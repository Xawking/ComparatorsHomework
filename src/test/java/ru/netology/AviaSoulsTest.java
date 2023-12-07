package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    @Test
    public void shouldCompareNegative() {
        Ticket ticket = new Ticket("city", "city2", 1000, 12, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 2000, 9, 18);
        int expected = -1;
        int actual = ticket.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePositive() {
        Ticket ticket = new Ticket("city", "city2", 3000, 12, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 500, 9, 18);
        int expected = 1;
        int actual = ticket.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareEqual() {
        Ticket ticket = new Ticket("city", "city2", 1500, 12, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 1500, 9, 18);
        int expected = 0;
        int actual = ticket.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSorted() {
        Ticket ticket = new Ticket("city", "city2", 1500, 12, 17);
        Ticket ticket2 = new Ticket("city", "city2", 1000, 9, 18);
        Ticket ticket3 = new Ticket("city", "city2", 3000, 2, 20);
        AviaSouls manager = new AviaSouls();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        Ticket[] expected = {ticket2, ticket, ticket3};
        Ticket[] actual = manager.search("city", "city2");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeLessThroughComparator() {
        Ticket ticket = new Ticket("city", "city2", 1000, 12, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 2000, 9, 18);
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = -1;
        int actual = comparator.compare(ticket, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeMoreThroughComparator() {
        Ticket ticket = new Ticket("city", "city2", 1000, 10, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 2000, 10, 13);
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = 1;
        int actual = comparator.compare(ticket, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualThroughComparator() {
        Ticket ticket = new Ticket("city", "city2", 1000, 10, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 2000, 10, 17);
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = 0;
        int actual = comparator.compare(ticket, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSortedThroughComparator() {
        Ticket ticket = new Ticket("city", "city2", 1500, 10, 18);
        Ticket ticket2 = new Ticket("city", "city2", 1000, 10, 20);
        Ticket ticket3 = new Ticket("city", "city2", 3000, 10, 17);
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        Ticket[] expected = {ticket3, ticket, ticket2};
        Ticket[] actual = manager.searchAndSortBy("city", "city2", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneThroughComparator() {
        Ticket ticket = new Ticket("city", "city2", 1500, 10, 18);
        Ticket ticket2 = new Ticket("city3", "city4", 1000, 10, 20);
        Ticket ticket3 = new Ticket("city", "city6", 3000, 10, 17);
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        Ticket[] expected = {ticket};
        Ticket[] actual = manager.searchAndSortBy("city", "city2", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneSorted() {
        Ticket ticket = new Ticket("city", "city2", 1500, 12, 17);
        Ticket ticket2 = new Ticket("city3", "city4", 1000, 9, 18);
        Ticket ticket3 = new Ticket("city", "city6", 3000, 2, 20);
        AviaSouls manager = new AviaSouls();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        Ticket[] expected = {ticket};
        Ticket[] actual = manager.search("city", "city2");
        Assertions.assertArrayEquals(expected, actual);
    }

}