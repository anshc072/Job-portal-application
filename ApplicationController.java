package com.jobportal.jobportal_backend.controller;

import com.jobportal.jobportal_backend.entity.JobApplication;
import com.jobportal.jobportal_backend.service.ApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    // ✅ Apply Job with Resume Upload
    @PostMapping("/apply")
    public String applyJob(@RequestParam("resume") MultipartFile resume) {

        try {

            System.out.println("Resume uploaded: " + resume.getOriginalFilename());

            // 👉 Later you can save file here
            return "Application Submitted Successfully";

        } catch (Exception e) {
            return "Application Failed";
        }
    }

    // ✅ Get All Applications
    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAllApplications();
    }
}
