const express = require('express')
const app = express()
const morgan = require('morgan')
const bodyParser =  require('body-parser')

const employeesRoute = require('./routes/employees')


app.use(morgan('dev'))
app.use(bodyParser.urlencoded({ extended:false}))
app.use(bodyParser.json())

app.use((req, res, next)=>{
    res.header('Acess-Control-Allow-Origin', '*')
    res.header('Acess-Control-Allow-Header',
    'Origin, X-Requested-With, Content-Type, Accept, Authorization')
    if(req.method === 'OPTIONS'){
        req.header('Acess-Control-Allow-Methods', 'PUT, POST, GET, PATCH, DELETE')
        return res.status(200).send({})
    }
    next()
})


app.use('/employees', employeesRoute)
app.use((req, res, next)=>{
    const error = new Error('Not Found!')
    error.status=404;
    next(error)
})
app.use((error, req, res, next)=>{
    res.status(error.status || 500)
    return res.send({
        error: {
            message: error.message
        }
    })
})


module.exports = app