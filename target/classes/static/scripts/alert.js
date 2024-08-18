document.addEventListener('DOMContentLoaded', function() {
    // Check if the flash attribute is present
    const alertMessage = [[${alertMessage}]]; // Thymeleaf syntax
    if (alertMessage) {
        const alert = document.getElementById('myAlert');
        alert.classList.remove('d-none');
        alert.classList.add('fade-in');

        // Fade out the alert after 4 seconds
        setTimeout(() => {
            alert.classList.remove('fade-in');
            alert.classList.add('fade-out');
            setTimeout(() => {
                alert.classList.add('d-none');
                alert.classList.remove('fade-out');
            }, 500); // Match this time with the duration of your fade-out animation
        }, 4000); // Show alert for 4 seconds
    }
});