package com.jobportal.jobportal_backend.repository;

import com.jobportal.jobportal_backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
