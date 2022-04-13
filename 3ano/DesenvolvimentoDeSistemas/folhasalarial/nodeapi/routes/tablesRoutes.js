const router = require('express').Router()

const Tables = require('../models/tables')
router.get('/', async (req, res) => {
    try {
        const allTables = await Tables.find()
        console.log(allTables.length)
        return res.status(200).json(allTables)
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})
router.post('/', async (req, res) => {
    
    const table = {
        firstTierINSS: 0,
        secondTierINSS: 0,
        thirdTierINSS: 0,
        fourthTierINSS: 0,
        firstAliquotINSS: 0,
        secondAliquotINSS: 0,
        thirdAliquotINSS: 0,
        fourthAliquotINSS: 0,
        maximumEligibleSalaryForFamilySalary: 0,
        valueFamilySalary: 0,
        firstTierIRRF: 0,
        secondTierIRRF: 0,
        thirdTierIRRF: 0,
        fourthTierIRRF: 0,
        secondAliquotIRRF: 0,
        thirdAliquotIRRF: 0,
        fourthAliquotIRRF: 0,
        fifthAliquotIRRF: 0,
        secondDeductionIRRF: 0,
        thirdDeductionIRRF: 0,
        fourthDeductionIRRF: 0,
        fifthDeductionIRRF: 0,
        dependentDeduction: 0,
    }
    try {
        const allTables = await Tables.find()
        if(allTables.length == 0 ){

            await Tables.create(table)
            return res.status(201).json({ message: 'Inserido com sucesso' })
        }
        return res.status(500).json({ message: 'Já possui um registro' })
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
module.exports = router
