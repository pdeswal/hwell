package com.pd.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pd.apps.model.Sensors;
import com.pd.apps.model.User;

@Repository
public interface SensorRepository extends JpaRepository<Sensors, Integer> {

}
