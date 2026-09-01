// show modal window after deleting one bakery data

const successModal =
    document.getElementById('successModal');

const successModalClose =
    document.getElementById('successModalClose');

const successModalMessage =
    document.getElementById('successModalMessage');


// Check delete success message
const deleteSuccessMessage =
    sessionStorage.getItem('deleteSuccessMessage');

if (deleteSuccessMessage) {

    // Display message
    successModalMessage.textContent =
        deleteSuccessMessage;

    // Show modal
    successModal.classList.add('show');

    // Remove message so it doesn't appear again
    sessionStorage.removeItem('deleteSuccessMessage');
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