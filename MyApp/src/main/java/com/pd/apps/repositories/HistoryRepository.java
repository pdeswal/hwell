package com.pd.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pd.apps.model.Appliance;
import com.pd.apps.model.SensorHistory;
import com.pd.apps.model.User;

@Repository
public interface HistoryRepository extends JpaRepository<SensorHistory, Long>{

}
