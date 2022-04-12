const mongoose = require('mongoose')

const Person = mongoose.model('Person',{
    name: String,
    salary: Number
})
module.exports = Person