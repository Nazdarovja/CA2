
document.getElementById("crudPerson").addEventListener("click", function (event) {
    let method = event.target.id;

    switch (method) {
        case "read":
            readPerson();
            break;
        case "delete":
            deletePerson();
            break;
        case "update":
            updatePerson();
            break;
        case "create":
            createPerson();
            break;
        case "hobby":
            getPersonsWithGivenHobby();
            break;
        case "city":
            getPersonsFromGivenCity();
            break;
        case "company":
            getCompaniesWithMoreThanXXEmployees();
            break;
    }
});

function readPerson() {
    let name = document.getElementById("nameRead").value;
    fetch("http://localhost:8084/CA2/api/person/" + name)
            .then(resp => resp.json())
            .then(person => convertPersonToTable(person))
}

function deletePerson() {
    let name = document.getElementById("nameDelete").value;

    fetch("http://localhost:8084/CA2/api/person/" + name, {method: 'delete'})
            .then(resp => resp.json())
            .then(person => convertPersonToTable(person));
}

function updatePerson() {
    let pId = document.getElementById("idUpdate").value;
    let fName = document.getElementById("firstNameUpdate").value;
    let lName = document.getElementById("lastNameUpdate").value;
    let mail = document.getElementById("emailUpdate").value;
    let addr = document.getElementById("addressUpdate").value;
    let zip = document.getElementById("zipcodeUpdate").value;

    let myHeaders = new Headers();

    myHeaders.append('Content-Type', "application/json");
    myHeaders.append('Accept', "application/json");

    let objectBody = {
            firstName: fName,
            lastName: lName,
            email: mail,
            address: {street: addr, additionalInfo: "additionalInf",
                cityInfo: {zipCode: zip
                }},
            phoneNumbers: [
            ],
            hobbyDTOs: [
            ]
        };
    
    let data = {
        headers: myHeaders,
        body: JSON.stringify(objectBody),
        method: "PUT"
    };

    fetch("http://localhost:8084/CA2/api/person/"+pId, data)
            .then(resp => resp.json())
            .then(person => {console.log(person);convertPersonToTable(person);});
}

function createPerson() {
    let fName = document.getElementById("firstNameCreate").value;
    let lName = document.getElementById("lastNameCreate").value;
    let mail = document.getElementById("emailCreate").value;
    let addr = document.getElementById("addressCreate").value;
    let zip = document.getElementById("zipcodeCreate").value;
    let additionalInf = document.getElementById("additionalInfoCreate").value;

    let myHeaders = new Headers();

    myHeaders.append('Content-Type', "application/json");
    myHeaders.append('Accept', "application/json");

    let objectBody = {
            firstName: fName,
            lastName: lName,
            email: mail,
            address: {street: addr, additionalInfo: additionalInf,
                cityInfo: {zipCode: zip
                }},
            phoneNumbers: [
            ],
            hobbyDTOs: [
            ]
        };
    
    let data = {
        headers: myHeaders,
        body: JSON.stringify(objectBody),
        method: "POST"
    };
    

    fetch("http://localhost:8084/CA2/api/person", data)
            .then(resp => resp.json)
            .then(person => convertPersonToTable(person))
            .catch(error => console.log(error.message));
}

function getPersonsWithGivenHobby() {
    let hobbyList = document.getElementById("hobbies");
    let hobby = hobbyList.options[hobbyList.selectedIndex].value;
    fetch("http://localhost:8084/CA2/api/person/hobby/" + hobby)
            .then(resp => resp.json())
            .then(persons => convertArrayOfPersonsToTable(persons));
}

function getPersonsFromGivenCity() {
    let cityList = document.getElementById("cities");
    let city = cityList.options[cityList.selectedIndex].value;

    fetch("http://localhost:8084/CA2/api/person/city/" + city)
            .then(resp => resp.json())
            .then(persons => convertArrayOfPersonsToTable(persons));
}

function getCompaniesWithMoreThanXXEmployees() {
    let count = document.getElementById("companyCount").value;

    fetch("http://localhost:8084/CA2/api/company/countbynumemployeesbelow/" + count)
            .then(resp => resp.json())
            .then(companies => convertArrayOfCompaniesToTable(companies));
}

function convertPersonToTable(person) {
    let html = "<table>" + getTableSkeletForCrudResult() + "<tr>";
    for (var propt in person)
        html += "<td>" + person[propt] + "</td>";
    html += "</tr></tbody></table>";
    document.getElementById("result").innerHTML = html;
}

function convertArrayOfPersonsToTable(persons) {
    var html = "<table>" + getTableSkeletForCrudResult();
    for (var key in persons) {
        html += "<tr>";
        var obj = persons[key];
        for (var propt in obj) {
            if(obj[propt] instanceof Object) {
                let object = JSON.stringify(obj[propt]);
                html += "<td>" + object + "</td>";
            }
            else {
                html += "<td>" + obj[propt] + "</td>";
            }
        }
        html += "</tr>";
    }
        html += "</tbody></table>";
    document.getElementById("result").innerHTML = html;
}

function convertArrayOfCompaniesToTable(companies) {
    var html = "<table>" + getTableSkeletForCrudResultCompany();
    for (var key in companies) {
        html += "<tr>";
        var obj = companies[key];
        for (var propt in obj) {
            if(obj[propt] instanceof Object) {
                let object = JSON.stringify(obj[propt]);
                html += "<td>" + object + "</td>";
            }
            else {
                html += "<td>" + obj[propt] + "</td>";
            }
        }
        html += "</tr>";
    }
        html += "</tbody></table>";
    document.getElementById("result").innerHTML = html;
}

function getTableSkeletForCrudResult() {
    return "<thead><tr><th>Firstname</th><th>Lastname</th><th>Email</th>\n\
            <th>Address</th><th>Phones</th><th>Hobbies</th></tr></thead><tbody>";
}

function getTableSkeletForCrudResultCompany() {
    return "<thead><tr><th>Name</th><th>Description</th><th>CVR</th>\n\
            <th>NumEmployees</th><th>MarketValue</th><th>Email</th><th>Address</th><th>Phones</th></tr></thead><tbody>";
}