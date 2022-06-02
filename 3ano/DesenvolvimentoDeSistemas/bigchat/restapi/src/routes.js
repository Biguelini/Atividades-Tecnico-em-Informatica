const { Router } = require('express')

const UserController = require('./app/Controllers/UserController')
const MessagesController = require('./app/Controllers/MessagesController')

const routes = new Router()


routes.get('/user', UserController.read)
routes.get('/user/:usuario', UserController.readOne)
routes.post('/user', UserController.create)
routes.post('/user/login', UserController.login)
routes.delete('/user/:usuario', UserController.delete)
routes.put('/user/:usuario', UserController.update)

routes.get('/messages/:usuario', MessagesController.read)
routes.delete('/messages/:id', MessagesController.delete)
routes.post('/messages', MessagesController.create)

module.exports = routes
