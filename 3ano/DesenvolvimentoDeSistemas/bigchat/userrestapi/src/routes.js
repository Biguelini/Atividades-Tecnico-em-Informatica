const { Router } = require('express')

const UserController = require('./app/Controllers/UserController')

const routes = new Router()


routes.get('/user', UserController.show)
routes.post('/user', UserController.create)
routes.post('/user/login', UserController.login)
routes.delete('/user/:usuario', UserController.delete)
routes.put('/user/:usuario', UserController.update)

module.exports = routes
