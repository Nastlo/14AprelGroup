const API = "http://localhost:8080/cars";

function loadCars() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            let table = document.getElementById("carTable");
            table.innerHTML = "";

            data.forEach(car => {
                table.innerHTML += `
                    <tr>
                        <td>${car.marka}</td>
                        <td>${car.model}</td>
                        <td>${car.year}</td>
                        <td>
                            <button class="action-btn edit" onclick="editCar(${car.id})">Edit</button>
                            <button class="action-btn delete" onclick="deleteCar(${car.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}

function addCar() {
    let car = {
        marka: document.getElementById("marka").value,
        model: document.getElementById("model").value,
        year: document.getElementById("year").value
    };

    fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(car)
    }).then(() => {
        loadCars();
    });
}

function deleteCar(id) {
    fetch(`${API}/${id}`, {
        method: "DELETE"
    }).then(() => {
        loadCars();
    });
}

function editCar(id) {
    let marka = prompt("New Marka:");
    let model = prompt("New Model:");
    let year = prompt("New Year:");

    let car = { marka, model, year };

    fetch(`${API}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(car)
    }).then(() => {
        loadCars();
    });
}

loadCars();