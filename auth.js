document.addEventListener("DOMContentLoaded", function () {

    window.showPopup = function(message) {
        const popupMessage = document.getElementById("popupMessage");
        const popup = document.getElementById("popup");

        if (!popupMessage || !popup) {
            console.error("Popup elements not found");
            return;
        }

        popupMessage.innerText = message;
        popup.style.display = "flex";
    };

    window.closePopup = function() {
        document.getElementById("popup").style.display = "none";
    };

});


// ================= LOGIN =================
function login() {

    const data = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    fetch("http://192.168.29.185:8080/api/users/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })

    // ⚠️ IMPORTANT → backend returns TEXT TOKEN (not JSON)
    .then(res => res.text())

    .then(token => {

        // save JWT
        localStorage.setItem("token", token);

        showPopup("Login Successful");

        // redirect to job list (simple version)
        setTimeout(() => {
            window.location.href = "job-list.html";
        }, 1000);
    })

    .catch(() => {
        showPopup("Login Failed");
    });
}


// ================= REGISTER =================
function register() {

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        role: document.getElementById("role").value
    };

    fetch("http://192.168.29.185:8080/api/users/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })

    .then(response => {

        if (response.ok) {

            showPopup("Registration Successful");

            setTimeout(() => {
                window.location.href = "login.html";
            }, 1500);

        } else {
            showPopup("Registration Failed");
        }

    })

    .catch(error => {
        console.error("Error:", error);
        showPopup("Something went wrong!");
    });
}