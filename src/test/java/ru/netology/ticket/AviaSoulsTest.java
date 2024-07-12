package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldComparePrice() {
        Ticket price1 = new Ticket("Санкт-Петербург", "Москва", 8_500, 18, 19);
        Ticket price2 = new Ticket("Санкт-Петербург", "Москва", 5_500, 18, 19);
        AviaSouls aviaSouls = new AviaSouls();


        aviaSouls.add(price1);
        aviaSouls.add(price2);


        int expected = 1;
        int actual = price1.compareTo(price2);

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSortPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 8_500, 18, 19);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5_500, 18, 19);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Москва", 1_500, 18, 19);
        Ticket ticket4 = new Ticket("Санкт-Петербург", "Москва", 9_500, 18, 19);
        Ticket ticket5 = new Ticket("Санкт-Петербург", "Москва", 500, 18, 19);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket5, ticket3, ticket2, ticket1, ticket4};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 8_500, 18, 20);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5_500, 19, 20);

        int actual = 1;
        int expected = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSortFlightTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 8_500, 18, 20);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 5_500, 18, 19);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);


        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Санкт-Петербург", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 3_500, 18, 19);
        Ticket ticket2 = new Ticket("Сочи", "Пермь", 15_500, 18, 23);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 3_500, 18, 19);
        Ticket ticket2 = new Ticket("Сочи", "Пермь", 15_500, 18, 23);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Краснодар", "Казань");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSeveralTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Москва", 2_500, 16, 17);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Москва", 3_500, 18, 19);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Москва", 4_000, 20, 21);
        Ticket ticket4 = new Ticket("Краснодар", "Пермь", 17_500, 15, 20);
        Ticket ticket5 = new Ticket("Сочи", "Уфа", 15_500, 18, 23);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.search("Санкт-Петербург", "Москва");

        Assertions.assertArrayEquals(expected, actual);

    }
}