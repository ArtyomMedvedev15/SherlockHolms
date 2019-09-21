package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreakfastRepo extends JpaRepository<Breakfast,Long> {
 }
