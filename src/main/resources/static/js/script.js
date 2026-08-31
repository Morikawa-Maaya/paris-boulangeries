    const photoInput = document.getElementById("photo");
    const fileName = document.getElementById("file-name");

    photoInput.addEventListener("change", function () {
    if (this.files.length > 0) {
    fileName.textContent = this.files[0].name;
} else {
    fileName.textContent = "Aucune photo sélectionnée";
}
});
