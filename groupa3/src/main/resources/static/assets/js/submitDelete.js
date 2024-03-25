// Attach event listener to the delete link
document.getElementById('deleteLink').addEventListener('click', function(event) {
    // Prevent the default link behavior
    event.preventDefault();

    // Get the form element
    var form = document.getElementById('taskForm');

    // Change the action attribute of the form
    form.action = '/projectCalender/delete';

    // Submit the form
    form.submit();
});