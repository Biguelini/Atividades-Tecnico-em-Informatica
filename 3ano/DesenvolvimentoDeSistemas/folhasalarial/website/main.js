function registerEmployee() {
    const {
        name,
        baseSalary,
        childrenUnder14YearsOld,
        incomeTaxDependent,
        wantTransportationVouchers,
    } = getEmployeeFormData()
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
const getEmployeeFormData = () => {
    const name = document.getElementById('name')
    const baseSalary = document.getElementById('baseSalary')
    const childrenUnder14YearsOld = document.getElementById(
        'childrenUnder14YearsOld'
    )
    const incomeTaxDependent = document.getElementById('incomeTaxDependent')
    const wantTransportationVouchers = document.querySelector(
        'input[name="wantTransportationVouchers"]:checked'
    )
    return {
        name,
        baseSalary,
        childrenUnder14YearsOld,
        incomeTaxDependent,
        wantTransportationVouchers,
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
        !wantTransportationVouchers ||
        childrenUnder14YearsOld.value > incomeTaxDependent.value
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
            for (let line in employees) {
                const newTableLine = `
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
                    <td><button class="btn btn-primary" type="button" onclick="deleteEmployee('${
                        employees[line]._id
                    }')">Deletar</button></td>
                    <td class="d-flex justify-content-center">
                            <a href="./funcionario.html?idEmployee=${
                                employees[line]._id
                            }"><button
                        class="btn btn-primary" type="button" >Editar</button><a/></td>
                </tr>`
                document.getElementById('tableEmployeesBody').innerHTML +=
                    newTableLine
            }
        })
        .catch(function () {
            console.log('Houve algum problema!')
        })
}
function deleteEmployee(id) {
    if (confirm('Quer mesmo deletar esse usuário?') == true) {
        text = 'Usuário deletado!'
        const options = {
            method: 'DELETE',
        }
        const url = 'http://localhost:3000/employee/' + id
        fetch(url, options)
        document.location.reload(true)
        alert('Usuário deletado com sucesso')
    } else {
        text = 'Operação cancelada!'
    }
}
function getTables() {}
function calcSalary() {
    const url = 'http://localhost:3000/employee'
    fetch(url)
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            const employees = data

            const urlTables = 'http://localhost:3000/tables'
            fetch(urlTables)
                .then(function (response) {
                    return response.json()
                })
                .then(function (data) {
                    const tables = data
                    const table = tables[0]
                    const {
                        firstTierINSS,
                        secondTierINSS,
                        thirdTierINSS,
                        fourthTierINSS,
                        firstAliquotINSS,
                        secondAliquotINSS,
                        thirdAliquotINSS,
                        fourthAliquotINSS,
                        maximumEligibleSalaryForFamilySalary,
                        valueFamilySalary,
                        firstTierIRRF,
                        secondTierIRRF,
                        thirdTierIRRF,
                        fourthTierIRRF,
                        secondAliquotIRRF,
                        thirdAliquotIRRF,
                        fourthAliquotIRRF,
                        fifthAliquotIRRF,
                        secondDeductionIRRF,
                        thirdDeductionIRRF,
                        fourthDeductionIRRF,
                        fifthDeductionIRRF,
                        dependentDeduction,
                    } = table
                    for (var line in employees) {
                        var name = employees[line].name
                        var baseSalary = employees[line].baseSalary
                        var inss = 0
                        if (baseSalary <= firstTierINSS) {
                            inss = calcPercent(baseSalary, firstAliquotINSS)
                        } else if (
                            baseSalary > firstTierINSS &&
                            baseSalary <= secondTierINSS
                        ) {
                            inss = calcPercent(firstTierINSS, firstAliquotINSS)
                            inss += calcPercent(
                                baseSalary - (firstTierINSS + 0.01),
                                secondAliquotINSS
                            )
                        } else if (
                            baseSalary > secondTierINSS &&
                            baseSalary <= thirdTierINSS
                        ) {
                            inss = calcPercent(firstTierINSS, firstAliquotINSS)
                            inss += calcPercent(
                                secondTierINSS - (firstTierINSS + 0.01),
                                secondAliquotINSS
                            )
                            inss += calcPercent(
                                baseSalary - (secondTierINSS + 0.01),
                                thirdAliquotINSS
                            )
                        } else if (
                            baseSalary > thirdTierINSS &&
                            baseSalary <= fourthTierINSS
                        ) {
                            inss = calcPercent(firstTierINSS, firstAliquotINSS)
                            inss += calcPercent(
                                secondTierINSS - (firstTierINSS + 0.01),
                                secondAliquotINSS
                            )
                            inss += calcPercent(
                                thirdTierINSS - (secondTierINSS + 0.01),
                                thirdAliquotINSS
                            )
                            inss += calcPercent(
                                baseSalary - (thirdTierINSS + 0.01),
                                fourthAliquotINSS
                            )
                        } else {
                            inss = calcPercent(firstTierINSS, firstAliquotINSS)
                            inss += calcPercent(
                                secondTierINSS - (firstTierINSS + 0.01),
                                secondAliquotINSS
                            )
                            inss += calcPercent(
                                thirdTierINSS - (secondTierINSS + 0.01),
                                thirdAliquotINSS
                            )
                            inss += calcPercent(
                                fourthTierINSS - (thirdTierINSS + 0.01),
                                fourthAliquotINSS
                            )
                        }
                        var familySalary =
                            baseSalary <= maximumEligibleSalaryForFamilySalary
                                ? employees[line].childrenUnder14YearsOld *
                                  valueFamilySalary
                                : 0
                        var vt = employees[line].wantTransportationVouchers
                            ? calcPercent(baseSalary, 6)
                            : 0
                        var baseCalcSalary =
                            baseSalary -
                            inss -
                            employees[line].incomeTaxDependent * dependentDeduction
                        var irrf = 0
                        if (baseCalcSalary <= firstTierIRRF) {
                            irrf = 0
                        } else if (
                            baseCalcSalary > firstTierIRRF &&
                            baseCalcSalary <= secondTierIRRF
                        ) {
                            irrf = calcPercent(baseCalcSalary, secondAliquotIRRF) - secondDeductionIRRF
                        } else if (
                            baseCalcSalary > secondTierIRRF &&
                            baseCalcSalary <= thirdTierIRRF
                        ) {
                            irrf = calcPercent(baseCalcSalary, thirdAliquotIRRF) - thirdDeductionIRRF
                        } else if (
                            baseCalcSalary > thirdTierIRRF &&
                            baseCalcSalary <= fourthTierIRRF
                        ) {
                            irrf = calcPercent(baseCalcSalary, fourthAliquotIRRF) - fourthDeductionIRRF
                        } else {
                            irrf = calcPercent(baseCalcSalary, fifthAliquotIRRF) - fifthDeductionIRRF
                        }
                        const finalSalary =
                            baseSalary - inss + familySalary - vt - irrf
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
                        document.getElementById(
                            'tableEmployeesBody'
                        ).innerHTML += newTableLine
                    }
                })
                .catch(function () {
                    console.log('Houve algum problema!')
                })
        })
        .catch(function () {
            console.log('Houve algum problema!')
        })
}
const calcPercent = (value, percent) => value * (percent / 100)
