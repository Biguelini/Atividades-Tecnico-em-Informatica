const router = require('express').Router()

const Person = require('../models/Person')

router.post('/', async (req, res) => {
    const { name, salary, approved } = req.body
    if (!name) {
        return res.status(422).json({ error: 'Insira o nome' })
    }
    const person = {
        name,
        salary,
        approved,
    }
    try {
        await Person.create(person)
        return res.status(201).json({ message: 'Inserido com sucesso' })
    } catch (error) {
        return res.status(500).json({ error: error })
    }
})
router.get('/', async (req, res) => {
    try {
        const people = await Person.find()
        return res.status(200).json(people)
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})
router.get('/:id', async (req, res) => {
    const id = req.params.id
    try {
        const person = await Person.findOne({_id: id})
        if(!person){
            return res.status(422).json({ message: 'Usuário não encontrado' })
        }
        return res.status(200).json(person)
    } catch (error) {
        console.log(error)
        return res.status(500).json({ error: error })
    }
})

module.exports = router
