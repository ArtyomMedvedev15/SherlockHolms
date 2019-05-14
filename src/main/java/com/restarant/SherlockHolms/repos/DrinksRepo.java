package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinksRepo extends JpaRepository<Drinks,Long> {
}
