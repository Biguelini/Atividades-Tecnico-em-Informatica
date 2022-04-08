const express = require('express')

const router = express.Router()
router.get('/', (req, res, next)=>{
    res.status(200).send({
        message: 'GET funcionários'
    })
})


router.post('/', (req, res, next)=>{
    res.status(200).send({
        message: 'POST funcionários'
    })
})

router.get('/:id_emplloyee',(req, res, next)=>{
    const id = req.params.id_emplloyee

    res.status(200).send({
        message: 'GET de um funcionário específico',
        id: id
    })
})
router.patch('/',(req, res, next)=>{

    res.status(201).send({
        message: 'PATCH funcionários',
    })
})
router.delete('/',(req, res, next)=>{

    res.status(201).send({
        message: 'DELETE funcionários',
    })
})



module.exports = router