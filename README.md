# 💼 Job Portal Application

Designed and developed a full-stack job portal system using Spring Boot (REST APIs) and MySQL for backend data management. Implemented JWT-based authentication authorization to ensure secure user sessions. Developed responsive frontend using HTML, CSS, and JavaScript

## Tech Stack

**Backend:** Java 17, Spring Boot 3.5, Spring Security, Spring Data JPA, MySQL, JWT (jjwt)
**Frontend:** HTML, CSS, JavaScript (vanilla, fetch API)

## Features

- **User Registration & Login** – JWT-based authentication; users sign up as a `JOB_SEEKER` or `RECRUITER`
- **Job Listings** – Browse all posted jobs (protected route, requires login)
- **Post a Job** – REST endpoint for creating new job listings
- **Apply to a Job** – Upload a resume through the frontend apply form
- **Application Records** – Applications are stored with a status field (`APPLIED`, `SHORTLISTED`, `REJECTED`)



## License

MIT LICENSE
