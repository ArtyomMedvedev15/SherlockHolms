package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.Snacks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnacksRepo extends JpaRepository<Snacks,Long> {
}
