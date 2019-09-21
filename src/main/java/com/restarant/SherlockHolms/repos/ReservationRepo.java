package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    Reservation findByDateReservation(Date date);
}
