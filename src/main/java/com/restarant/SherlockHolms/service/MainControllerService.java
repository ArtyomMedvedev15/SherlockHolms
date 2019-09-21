package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.CountofPeople;
import com.restarant.SherlockHolms.domain.Reservation;
import com.restarant.SherlockHolms.repos.ReservationRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class MainControllerService {

    private final ReservationRepo reservationRepo;

    public MainControllerService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public Reservation checkDate(String dates){
        Reservation reservationByDate = reservationRepo.findByDateReservation(convertStringtoDate(dates));

        if(reservationByDate == null){
            return null;
        }
        return reservationByDate;
    }

    public Boolean addReservation(String name, String email,
                               String phoneNumber, String counts,
                               String dates, String message
    ){

            Reservation reservation = new Reservation();

            reservation.setName(name);

            Set<CountofPeople> countofPeopleSet = new HashSet<>();
            countofPeopleSet.add(CountofPeople.valueOf(counts));
            reservation.setCountofPeople(countofPeopleSet);
            reservation.setEmail(email);

            reservation.setMessage(message);
            reservation.setDateReservation(convertStringtoDate(dates));
            reservation.setPhoneNumber(phoneNumber);

            reservationRepo.save(reservation);

            return true;
    }

    public Date convertStringtoDate(String dates) {
        String[]masDate = dates.split("/");
        return new Date(Integer.parseInt(masDate[2])-1900,Integer.parseInt(masDate[0])-1,Integer.parseInt(masDate[1]));
    }
    public Map<String,List<Object>> cutMassiveontwohalf(List<Object>massiveObject){
        Map<String,List<Object>>massives = new HashMap<>();
        List<Object>left = new ArrayList<>();
        List<Object>right = new ArrayList<>();

        for (int i = 0; i <= massiveObject.size()/2 - 1 ; i++) {
            left.add(massiveObject.get(i));
        }


        for (int i = massiveObject.size()/2; i < massiveObject.size(); i++) {
            right.add(massiveObject.get(i));
        }

        massives.put("left",left);
        massives.put("right",right);


        return massives;
    }

    public Boolean addReservation(String name, String email,
                                  String phoneNumber, String counts,
                                  String message
    ){

        Reservation reservation = new Reservation();

        reservation.setName(name);

        Set<CountofPeople> countofPeopleSet = new HashSet<>();
        countofPeopleSet.add(CountofPeople.valueOf(counts));
        reservation.setCountofPeople(countofPeopleSet);
        reservation.setEmail(email);

        reservation.setMessage(message);
        reservation.setPhoneNumber(phoneNumber);

        reservationRepo.save(reservation);

        return true;
    }

    public boolean editReservation(String name, String email, String phoneNumber, String count, String date, String message, Reservation reservation) {

        reservation.setName(name);
        reservation.setEmail(email);
        reservation.setPhoneNumber(phoneNumber);
        Set<CountofPeople> countofPeopleSet = new HashSet<>();
        countofPeopleSet.add(CountofPeople.valueOf(count));
        reservation.setCountofPeople(countofPeopleSet);

        reservation.setMessage(message);
        reservation.setDateReservation(convertStringtoDate(date));

        reservationRepo.save(reservation);

        return true;
    }
}
