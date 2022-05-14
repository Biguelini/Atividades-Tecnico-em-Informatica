const { Router } = require('express')

const UserController = require('./app/Controllers/UserController')

const routes = new Router()


routes.get('/user', UserController.show)
routes.post('/user', UserController.create)

module.exports = routes
