// Show success modal after registering, editing, or deleting a bakery

const successModal =
    document.getElementById('successModal');

const successModalClose =
    document.getElementById('successModalClose');

const successModalMessage =
    document.getElementById('successModalMessage');


// Check success message
const successMessage =
    sessionStorage.getItem('successMessage');


// Show modal if success message exists
if (successMessage) {

    // Display message
    successModalMessage.textContent =
        successMessage;

    // Show modal
    successModal.classList.add('show');

    // Remove message so it doesn't appear again
    sessionStorage.removeItem('successMessage');
}


// Close by × button
successModalClose.addEventListener('click', () => {

    successModal.classList.remove('show');

});


// Close by clicking outside the modal
successModal.addEventListener('click', (event) => {

    if (event.target === successModal) {

        successModal.classList.remove('show');

    }

});
