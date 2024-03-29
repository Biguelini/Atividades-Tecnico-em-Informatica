const router = require('express').Router()

const Tables = require('../models/tables')
router.get('/', async (req, res) => {
    try {
        const allTables = await Tables.find()
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

router.put('/inss/:id', async (req,res)=>{
    const id = req.params.id
    const {
        firstTierINSS,
        secondTierINSS,
        thirdTierINSS,
        fourthTierINSS,
        firstAliquotINSS,
        secondAliquotINSS,
        thirdAliquotINSS,
        fourthAliquotINSS,
        
    } = req.body
    const table = {
        firstTierINSS,
        secondTierINSS,
        thirdTierINSS,
        fourthTierINSS,
        firstAliquotINSS,
        secondAliquotINSS,
        thirdAliquotINSS,
        fourthAliquotINSS,
        
    }
    try{
        const updatedTables = await Tables.updateOne({_id:id}, table)
        res.status(200).json(table)
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
router.put('/fs/:id', async (req,res)=>{
    const id = req.params.id
    const {
        maximumEligibleSalaryForFamilySalary,
        valueFamilySalary,
        
    } = req.body
    const table = {
        maximumEligibleSalaryForFamilySalary,
        valueFamilySalary,
        
    }
    try{
        const updatedTables = await Tables.updateOne({_id:id}, table)
        res.status(200).json(table)
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
router.put('/irrf/:id', async (req,res)=>{
    const id = req.params.id
    const {
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
        
    } = req.body
    const table = {
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
        
    }
    try{
        const updatedTables = await Tables.updateOne({_id:id}, table)
        if (updatedTables.matchedCount === 0){
            return res.status(422).json({ message: 'Tabela não encontrada' })
        }
        res.status(200).json(table)
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
module.exports = router

