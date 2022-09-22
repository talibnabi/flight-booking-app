package controller;

import controller.concretes.FlightControllerManager;
import entity.Flight;
import enumeration.Airline;
import enumeration.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.concretes.FlightServiceManager;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightControllerTest {
    private FlightControllerManager flightControllerManager;
    private FlightServiceManager flightServiceManager;
    private Flight flightFirst;
    private Flight flightSecond;

    @BeforeEach
    void before() {
        flightServiceManager = new FlightServiceManager();
        flightControllerManager = new FlightControllerManager();
        flightControllerManager.setFlightService(flightServiceManager);
        flightFirst = flightServiceManager.getById(0);
        flightSecond = new Flight(Airline.AMERICAN_AIRLINES, Airport.ABERDEEN, Airport.ABU_SIMBEL, 10, LocalDate.now(), LocalTime.now().plusNanos(10));
    }


}
