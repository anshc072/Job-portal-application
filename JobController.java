package com.jobportal.jobportal_backend.controller;

import com.jobportal.jobportal_backend.entity.Job;
import com.jobportal.jobportal_backend.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public Job postJob(@RequestBody Job job) {
        return service.postJob(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }
}
