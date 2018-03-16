
document.getElementById("crudPerson").addEventListener("click", function (event) {
    var method = event.target.id;
    
    switch(method) {
        case "read": readPerson();
        case "delete": deletePerson();
        case "update": updatePerson();
        case "create": createPerson();
    }
});

function readPerson() {
    var name = document.getElementById("nameRead").value;
    
    fetch("http://localhost:8084/CA2/api/person/" + name)
            .then(resp => resp.json())
            .then(data => console.log(data));
}

function deletePerson() {
    var name = document.getElementById("nameDelete").value;
    
    fetch("http://localhost:8084/CA2/api/person/" + name, {method: 'delete'})
            .then(resp => resp.json())
            .then(data => console.log(data));
}

function updatePerson() {
    
}

function createPerson() {
    var fName = document.getElementById("firstNameCreate").value;
    var lName = document.getElementById("lastNameCreate").value;
    
    var myHeaders = new Headers();

    myHeaders.append('Content-Type', "application/json");
    myHeaders.append('Accept', "application/json");
    
    var data = {
        headers: myHeaders,
        body: {
            firstName: fName,
            lastName: lName
        },
        method: "post"
    };
    
    fetch("http://localhost:8084/CA2/api/person/", data)
            .then(resp => resp.json)
            .then(data =>  console.log(data));
}