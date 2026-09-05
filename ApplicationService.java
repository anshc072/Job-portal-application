package com.jobportal.jobportal_backend.service;

import com.jobportal.jobportal_backend.entity.JobApplication;
import com.jobportal.jobportal_backend.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final JobApplicationRepository repo;

    public ApplicationService(JobApplicationRepository repo) {
        this.repo = repo;
    }

    public JobApplication apply(JobApplication app) {
        app.setStatus("APPLIED");
        return repo.save(app);
    }

    public List<JobApplication> getAllApplications() {
        return repo.findAll();
    }
}
