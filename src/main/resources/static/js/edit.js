// button for register photo (registration page)
const photoInput = document.getElementById("photo");
const fileName = document.getElementById("file-name");

photoInput.addEventListener("change", function () {
    if (this.files.length > 0) {
        fileName.textContent = this.files[0].name;
    } else {
        fileName.textContent = "Aucune photo sélectionnée";
    }
});

// Update bakery

const editForm = document.getElementById('editForm');

editForm.addEventListener('submit', async (event) => {

// Prevent normal form submission
    event.preventDefault();

    try {
        // Get bakery ID
        const bakeryId = editForm.dataset.bakeryId;

        // Get all form data
        const formData = new FormData(editForm);

        // Send PUT request
        const response = await fetch(
            editForm.action,
            {
                method: 'PUT',
                body: formData
            }
        );

        if (!response.ok) {
            throw new Error('Update failed');
        }

        // Get response JSON
        const data = await response.json();

        // Save success message temporarily
        sessionStorage.setItem(
            'successMessage',
            data.message || 'La boulangerie a été modifiée.'
        );

        // Go to bakery detail
        window.location.href = `/bakery/${bakeryId}`;

    } catch (error) {

        console.error(error);

        alert("La modification a échoué.");
    }


});