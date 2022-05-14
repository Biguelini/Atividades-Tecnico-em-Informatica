const { Router } = require('express')

const UserController = require('./app/Controllers/UserController')

const routes = new Router()


routes.get('/user', UserController.show)
routes.post('/user', UserController.create)
routes.post('/user/login', UserController.login)
routes.delete('/user/:id', UserController.delete)
routes.put('/user/:id', UserController.update)

module.exports = routes
