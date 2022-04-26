const express = require('express')
const mongoose = require('mongoose')
const app = express()
const employeeRoutes = require('./routes/employeeRoutes')
const tablesRoutes = require('./routes/tablesRoutes')
const cors = require('cors')
app.use(
    express.urlencoded({
        extended: true,
    })
)
app.use(express.json())
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*')
    res.header('Access-Control-Allow-Headers', 'Content-Type')
    res.header('Access-Control-Allow-Methods', 'GET,POST,PUT,DELETE')
    app.use(cors())
    next()
})
app.use('/employee', employeeRoutes)
app.use('/tables', tablesRoutes)

app.get('/', (req, res) => {
    res.json({ message: 'Oi express!' })
})

mongoose
    .connect(
        'mongodb+srv://bigue:Biguelini1004@folhasalarialcluster.fgymu.mongodb.net/folhasalarial?retryWrites=true&w=majority'
    )
    .then(() => {
        console.log('conectado')
        app.listen(3000)
    })
    .catch((e) => {
        console.log(e)
    })
