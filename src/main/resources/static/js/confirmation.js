// Register new bakery

const registerForm = document.getElementById('registerForm');

registerForm.addEventListener('submit', async (event) => {

    // Prevent normal form submission
    event.preventDefault();

    try {

        const formData = new FormData(registerForm);

        const response = await fetch(
            registerForm.action,
            {
                method: 'POST',
                body: formData
            }
        );

        if (!response.ok) {
            throw new Error('Registration failed');
        }

        // Get response JSON
        const data = await response.json();

        // Save success message temporarily
        sessionStorage.setItem(
            'successMessage',
            data.message || 'La boulangerie a été enregistrée.'
        );

        // Go to Home
        window.location.href = '/';

    } catch (error) {

        console.error(error);

        alert("L'enregistrement a échoué.");
    }

});
