package com.jobportal.jobportal_backend.service;

import com.jobportal.jobportal_backend.entity.Job;
import com.jobportal.jobportal_backend.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public Job postJob(Job job) {
        return repo.save(job);
    }

    public List<Job> getAllJobs() {
        return repo.findAll();
    }
}
