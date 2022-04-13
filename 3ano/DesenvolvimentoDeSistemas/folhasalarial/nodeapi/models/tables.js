const mongoose = require('mongoose')

const Tables = mongoose.model('Tables',{
    firstTierINSS: Number,
    secondTierINSS: Number,
    thirdTierINSS: Number,
    fourthTierINSS: Number,
    firstAliquotINSS: Number,
    secondAliquotINSS: Number,
    thirdAliquotINSS: Number,
    fourthAliquotINSS: Number,
    maximumEligibleSalaryForFamilySalary: Number,
    valueFamilySalary: Number,
    firstTierIRRF: Number,
    secondTierIRRF: Number,
    thirdTierIRRF: Number,
    fourthTierIRRF: Number,
    secondAliquotIRRF: Number,
    thirdAliquotIRRF: Number,
    fourthAliquotIRRF: Number,
    fifthAliquotIRRF: Number,
    secondDeductionIRRF: Number,
    thirdDeductionIRRF: Number,
    fourthDeductionIRRF: Number,
    fifthDeductionIRRF: Number,
    dependentDeduction: Number
})
module.exports = Tables