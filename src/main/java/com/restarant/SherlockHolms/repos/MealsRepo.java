package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.Meals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepo extends JpaRepository<Meals,Long> {
}
