var selectedTaskId; // Variable to store the selected task ID

function selectRow(row) {
    var selectedRow = document.querySelector(".selected");
    if (selectedRow) {
        selectedRow.classList.remove("selected");
    }
    
    row.classList.add("selected");
    document.getElementById("editButton").style.display = "block";

    // Get the task ID of the selected row
    selectedTaskId = row.querySelector("td:first-child").innerText;
}

function redirectToEdit() {
    if (selectedTaskId) {
        // Redirect to the edit page with the selected task ID
        window.location.href = "/projectCalender/editTask/" + selectedTaskId; // Replace "/edit-task/" with your actual edit page URL
    } else {
        console.error("No task selected."); // Log an error if no task is selected
    }
}