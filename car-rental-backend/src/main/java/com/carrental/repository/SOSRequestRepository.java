package com.carrental.repository;

import com.carrental.model.SOSRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SOSRequestRepository extends JpaRepository<SOSRequest, Long> {
}