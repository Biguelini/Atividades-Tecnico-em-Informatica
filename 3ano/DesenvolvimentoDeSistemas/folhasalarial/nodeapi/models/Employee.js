const mongoose = require('mongoose')

const Employee = mongoose.model('Employee',{
    name: String,
    baseSalary: Number,
    childrenUnder14YearsOld: Number,
    incomeTaxDependent: Number,
    wantTransportationVouchers: Boolean
})
module.exports = Employee