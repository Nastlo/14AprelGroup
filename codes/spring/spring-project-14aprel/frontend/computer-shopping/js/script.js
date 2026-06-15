function saveComputer() {

    let brand = document.getElementById("brand").value;
    let model = document.getElementById("model").value;

    if (brand === "" || model === "") {
        alert("Brand və Model boş ola bilməz!");
        return;
    }

    let computer = {
        brand: brand,
        model: model
    };

    fetch("http://localhost:8080/computers", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(computer)
    })
    .then(response => response.text())
    .then(data => {
        alert(data);

        document.getElementById("brand").value = "";
        document.getElementById("model").value = "";
    })
    .catch(error => {
        console.error(error);
        alert("Xəta baş verdi!");
    });
}