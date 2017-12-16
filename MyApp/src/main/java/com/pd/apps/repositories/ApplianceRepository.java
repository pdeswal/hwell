package com.pd.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pd.apps.model.Appliance;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
