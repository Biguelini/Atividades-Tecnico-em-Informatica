function registerEmployee() {
    var name = document.getElementById('name')
    var baseSalary = document.getElementById('baseSalary')
    var childrenUnder14YearsOld = document.getElementById(
        'childrenUnder14YearsOld'
    )
    var incomeTaxDependent = document.getElementById('incomeTaxDependent')
    var wantTransportationVouchers = document.querySelector(
        'input[name="wantTransportationVouchers"]:checked'
    )
    if (
        checksThatFieldsAreFilledInCorrectly(
            name,
            baseSalary,
            childrenUnder14YearsOld,
            incomeTaxDependent,
            wantTransportationVouchers
        )
    ) {
        postToAPIEmployee(
            name.value,
            baseSalary.value,
            childrenUnder14YearsOld.value,
            incomeTaxDependent.value,
            wantTransportationVouchers.value
        )
    }
}
function checksThatFieldsAreFilledInCorrectly(
    name,
    baseSalary,
    childrenUnder14YearsOld,
    incomeTaxDependent,
    wantTransportationVouchers
) {
    if (
        !name.value ||
        !isNaN(name.value) ||
        !baseSalary.value ||
        isNaN(baseSalary.value) ||
        baseSalary.value < 0 ||
        childrenUnder14YearsOld.value < 0 ||
        !childrenUnder14YearsOld.value ||
        isNaN(childrenUnder14YearsOld.value) ||
        incomeTaxDependent.value < 0 ||
        !incomeTaxDependent.value ||
        isNaN(incomeTaxDependent.value) ||
        !wantTransportationVouchers
    ) {
        alert('Preencha corretamente os campos')
        return false
    }
    return true
}
function postToAPIEmployee(
    name,
    baseSalary,
    childrenUnder14YearsOld,
    incomeTaxDependent,
    wantTransportationVouchers
) {
    const data = {
        name: name,
        baseSalary: parseFloat(baseSalary),
        childrenUnder14YearsOld: parseInt(childrenUnder14YearsOld),
        incomeTaxDependent: parseInt(incomeTaxDependent),
        wantTransportationVouchers: wantTransportationVouchers == 'true',
    }
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }
    fetch('http://localhost:3000/employee', options)
    document.location.reload(true)
}
function fillTable() {
    const url = 'http://localhost:3000/employee'
    fetch(url)
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            const employees = data
            for (var line in employees) {
                var newTableLine = `
                <tr>
                    <td> ${employees[line].name}</td>
                    <td>R$ ${employees[line].baseSalary}</td>
                    <td>${employees[line].childrenUnder14YearsOld}</td>
                    <td>${employees[line].incomeTaxDependent}</td>
                    <td>${employees[line].wantTransportationVouchers == true ? 'Sim': 'Não'}</td>
                </tr>`
                document.getElementById('tableEmployeesBody').innerHTML += newTableLine
            }
        })
        .catch(function () {
            console.log('Houve algum problema!')
        })
}
