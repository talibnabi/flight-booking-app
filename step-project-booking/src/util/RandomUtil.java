package util;

import enumeration.Airline;
import enumeration.Airport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    public static final Random randomNum = new Random();
    public static LocalDate getRandomLocalDate() {
        LocalDate start = LocalDate.now();
        long days = ChronoUnit.DAYS.between(start, LocalDate.now().plusDays(1));
        return start.plusDays(randomNum.nextInt((int) days + 1));
    }

    public static LocalTime getRandomLocalTime() {
        LocalTime time1 = LocalTime.of(8, 0, 0);
        LocalTime time2 = LocalTime.of(0, 0, 0);
        long totalNanos = Math.abs(ChronoUnit.NANOS.between(time1, time2));
        long randomNanos = ThreadLocalRandom.current().nextLong(totalNanos);
        LocalTime firstTime = time2.isAfter(time1) ? time1 : time2;
        return firstTime.plusNanos(randomNanos);
    }

    public static int getRandomTicketPrice() {
        return 300 + randomNum.nextInt(700);
    }

    public static int getRandomFreeSeats() {
        return 5 + randomNum.nextInt(10);
    }

    public static Airline getRandomAirline() {
        Airline[] airlines = Airline.values();
        List<Airline> list = new ArrayList<>(Arrays.asList(airlines));
        return list.get(getRandomNumber(airlines.length));
    }

    private static int getRandomNumber(int max) {
        return randomNum.nextInt(max);
    }

    private static Airport[] getAllAirports() {
        return Airport.values();
    }

    private static List<Airport> getAirportFrom() {
        List<Airport> airportListFrom = new ArrayList<>();
        List<Airport> allAirportList = new ArrayList<>(Arrays.asList(getAllAirports()));
        for (int i = 0; i < allAirportList.size() / 2; i++) {
            airportListFrom.add(allAirportList.get(i));
        }
        return airportListFrom;
    }

    private static List<Airport> getAirportTo() {
        List<Airport> airportListTo = new ArrayList<>();
        List<Airport> allAirportList = new ArrayList<>(Arrays.asList(getAllAirports()));
        for (int i = allAirportList.size() / 2; i < allAirportList.size(); i++) {
            airportListTo.add(allAirportList.get(i));
        }
        return airportListTo;
    }

    public static Airport getRandomAirportFrom() {
        List<Airport> airports = getAirportFrom();
        return airports.get(getRandomNumber(airports.size()));
    }

    public static Airport getRandomAirportTo() {
        List<Airport> airports = getAirportTo();
        return airports.get(getRandomNumber(airports.size()));
    }
}
