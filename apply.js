document.getElementById("applyForm").addEventListener("submit", function(e) {

    e.preventDefault();

    const resumeInput = document.getElementById("resume");

    if (!resumeInput.files.length) {
        showPopup("Please upload resume");
        return;
    }

    const formData = new FormData();
    formData.append("resume", resumeInput.files[0]);

    fetch("http://192.168.29.185:8080/api/applications/apply", {
        method: "POST",
        body: formData
    })
     .then(response => response.text())
        .then(data => {
            alert(data);
        })
        .catch(() => {
            alert("Server Error");
        });
    });


// ⭐ Popup functions
function showPopup(message) {
    document.getElementById("popupMessage").innerText = message;
    document.getElementById("popup").style.display = "block";
}

function closePopup() {
    document.getElementById("popup").style.display = "none";
}
