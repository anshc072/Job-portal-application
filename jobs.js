// ⭐ check token first
const token = localStorage.getItem("token");

if(!token){
    alert("Please login first");
    window.location.href="login.html";
}

// ================= FETCH JOBS =================
fetch("http://192.168.29.185:8080/api/jobs", {
    headers: {
        "Authorization": "Bearer " + token
    }
})
.then(res => {

    // ⭐ if unauthorized → redirect to login
    if(res.status === 401 || res.status === 403){
        localStorage.removeItem("token");
        alert("Session expired. Login again.");
        window.location.href="login.html";
        return;
    }

    if (!res.ok) {
        throw new Error("Failed to fetch jobs");
    }

    return res.json();
})

.then(data => {

    if(!data) return;

    let html = "";

    const colors = [
        "linear-gradient(135deg, #ff9a9e, #fad0c4)",
        "linear-gradient(135deg, #a18cd1, #fbc2eb)",
        "linear-gradient(135deg, #f6d365, #fda085)",
        "linear-gradient(135deg, #84fab0, #8fd3f4)",
        "linear-gradient(135deg, #fccb90, #d57eeb)",
        "linear-gradient(135deg, #5ee7df, #b490ca)"
    ];

    let index = 0;

    data.forEach(job => {

        html += `
        <div class="job-card"
             style="background:${colors[index % colors.length]}; color:white;">
             
            <h3>${job.title}</h3>
            <p>${job.description}</p>

            <button class="apply-btn"
                onclick="apply(${job.id})">
                Apply
            </button>

        </div>
        `;

        index++;
    });

    document.getElementById("jobs").innerHTML = html;

})

.catch(err => console.error(err));


// ================= APPLY =================
function apply(jobId) {
    localStorage.setItem("jobId", jobId);
    window.location.href = "apply-job.html";
}