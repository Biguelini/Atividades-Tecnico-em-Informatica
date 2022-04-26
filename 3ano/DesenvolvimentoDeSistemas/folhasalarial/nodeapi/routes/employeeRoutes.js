const router = require('express').Router()

const Employee = require('../models/Employee')

router.post('/', async (req, res) => {
    const {
        name,
        baseSalary,
        childrenUnder14YearsOld,
        incomeTaxDependent,
        wantTransportationVouchers,
    } = req.body
    if (!name) {
        return res.status(422).json({ error: 'Preencha os campos' })
    }
    const employee = {
        name,
        baseSalary,
        childrenUnder14YearsOld,
        incomeTaxDependent,
        wantTransportationVouchers,
    }
    try {
        await Employee.create(employee)
        return res.status(201).json({ message: 'Inserido com sucesso' })
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
router.get('/', async (req, res) => {
    try {
        const employees = await Employee.find()
        return res.status(200).json(employees)
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})
router.get('/:id', async (req, res) => {
    const id = req.params.id
    try {
        const employee = await Employee.findOne({ _id: id })
        if (!employee) {
            return res.status(422).json({ message: 'Funcionário não encontrado' })
        }
        return res.status(200).json(employee)
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})
router.delete('/:id', async (req, res)=>{
    const id = req.params.id
    const employee = await Employee.findOne({ _id: id })
    if (!employee) {
        return res.status(422).json({ message: 'Funcionário não encontrado' })
    }

    try {
        await Employee.deleteOne({_id:id})
        return res.status(200).json({message: 'Usuário removido com susseso'})
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})


module.exports = router
