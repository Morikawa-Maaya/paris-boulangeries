// delete one bakery data (detail page > delete)

const deleteButton = document.getElementById('deleteButton');
const deleteModal = document.getElementById('deleteModal');
const cancelDeleteButton =
    document.getElementById('cancelDeleteButton');
const confirmDeleteButton =
    document.getElementById('confirmDeleteButton');


// Delete button
deleteButton.addEventListener('click', () => {

    deleteModal.classList.add('show');

});


// Cancel
cancelDeleteButton.addEventListener('click', () => {

    deleteModal.classList.remove('show');

});


// Confirm delete
confirmDeleteButton.addEventListener('click', async () => {

    const bakeryId = deleteButton.dataset.bakeryId;

    try {

        const response = await fetch(
            `/api/bakery/${bakeryId}`,
            {
                method: 'DELETE'
            }
        );

        if (!response.ok) {
            throw new Error('Delete failed');
        }

        // Get response JSON
        const data = await response.json();

        // Save success message temporarily
        sessionStorage.setItem(
            'deleteSuccessMessage',
            data.message || 'La boulangerie a été supprimée.'
        );

        // Home
        window.location.href = '/';

    } catch (error) {

        console.error(error);

        alert('La suppression a échoué.');
    }
});