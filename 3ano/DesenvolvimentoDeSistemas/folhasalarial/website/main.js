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
                    <td>${
                        employees[line].wantTransportationVouchers == true
                            ? 'Sim'
                            : 'Não'
                    }</td>
                </tr>`
                document.getElementById('tableEmployeesBody').innerHTML +=
                    newTableLine
            }
        })
        .catch(function () {
            console.log('Houve algum problema!')
        })
}
function calcSalary() {
    const url = 'http://localhost:3000/employee'
    fetch(url)
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            const employees = data
            for (var line in employees) {
                var name = employees[line].name
                var baseSalary = employees[line].baseSalary
                var inss = calcINSS(baseSalary)
                var familySalary =
                    baseSalary <= 1655.98
                        ? employees[line].childrenUnder14YearsOld * 56.47
                        : 0
                var vt = employees[line].wantTransportationVouchers
                    ? calcPercent(baseSalary, 6)
                    : 0
                var baseCalcSalary =baseSalary - inss -employees[line].incomeTaxDependent * 189.59
                var irrf = calcIRFF(baseCalcSalary)
                const finalSalary = baseSalary - inss + familySalary - vt - irrf
                var newTableLine = `
                    <tr>
                        <td> ${name}</td>
                        <td>R$ ${baseSalary.toFixed(2)}</td>
                        <td>R$ ${inss.toFixed(2)}</td>
                        <td>R$ ${familySalary.toFixed(2)}</td>
                        <td>R$ ${vt.toFixed(2)}</td>
                        <td>R$ ${irrf.toFixed(2)}</td>
                        <td>R$ ${finalSalary.toFixed(2)}</td>
                        <td class="d-flex justify-content-center">
                            <a href="./holerite.html?idEmployee=${
                                employees[line]._id
                            }"><button
                        class="btn btn-primary" type="button" >Ver
                        Holerite</button><a/></td>
                    </tr>`
                document.getElementById('tableEmployeesBody').innerHTML +=
                    newTableLine
            }
        })
        .catch(function () {
            console.log('Houve algum problema!')
        })
}
const calcPercent = (value, percent) => value * (percent / 100)
function calcINSS(baseSalary) {
    var inss = 0
    if (baseSalary <= 1212) {
        inss = calcPercent(baseSalary, 7.5)
    } else if (baseSalary > 1212 && baseSalary <= 2427.36) {
        inss = calcPercent(1212, 7.5)
        inss += calcPercent(baseSalary - 1212.01, 9)
    } else if (baseSalary > 2427.36 && baseSalary <= 3641.03) {
        inss = calcPercent(1212, 7.5)
        inss += calcPercent(2427.36 - 1212.01, 9)
        inss += calcPercent(baseSalary - 2427.37, 12)
    } else if (baseSalary > 3641.03 && baseSalary <= 7087.22) {
        inss = calcPercent(1212, 7.5)
        inss += calcPercent(2427.36 - 1212.01, 9)
        inss += calcPercent(3641.03 - 2427.37, 12)
        inss += calcPercent(baseSalary - 3641.04, 14)
    } else {
        inss = calcPercent(1212, 7.5)
        inss += calcPercent(2427.36 - 1212.01, 9)
        inss += calcPercent(3641.03 - 2427.37, 12)
        inss += calcPercent(7087.22 - 3641.04, 14)
    }
    return inss
}
function calcIRFF(baseCalcSalary) {
    irrf = 0
    if (baseCalcSalary <= 1903.98) {
        irrf = 0
    } else if (baseCalcSalary > 1903.98 && baseCalcSalary <= 2826.65) {
        irrf = calcPercent(baseCalcSalary, 7.5) - 142.8
    } else if (baseCalcSalary > 2826.65 && baseCalcSalary <= 3751.05) {
        irrf = calcPercent(baseCalcSalary, 15) - 354.8
    } else if (baseCalcSalary > 3751.05 && baseCalcSalary <= 4664.68) {
        irrf = calcPercent(baseCalcSalary, 22.5) - 646.13
    } else {
        irrf = calcPercent(baseCalcSalary, 27.5) - 869.36
    }
    return irrf
}
