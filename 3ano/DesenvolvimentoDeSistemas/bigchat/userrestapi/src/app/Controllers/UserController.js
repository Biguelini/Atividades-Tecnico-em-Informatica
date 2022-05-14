const { PrismaClient } = require('@prisma/client')

const prisma = new PrismaClient()
const bcrypt = require('bcrypt')
class UserController {
    async show(req, res) {
        try {
            const allUsers = await prisma.user.findMany()
            return res.status(200).json(allUsers)
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async create(req, res) {
        try {
            const { email, name } = req.body
            let { password } = req.body
            password = (await bcrypt.hash(password, 10)).toString()
            const emailAlreadyUsed = await prisma.user.findUnique({
                where: { email: email },
            })
            if (emailAlreadyUsed) {
                return res
                    .status(409)
                    .json({ message: 'Email is already used' })
            }
            const createdUser = { name: name, email: email, password: password }
            await prisma.user.create({
                data: {
                    name: name,
                    email: email,
                    password: password,
                },
            })
            return res
                .status(201)
                .json({ message: 'User created', createdUser })
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async delete(req, res) {
        try {
            const id = parseInt(req.params.id)
            try {
                const deletedUser = await prisma.user.delete({
                    where: { id: id },
                })
                return res.status(200).json({
                    message: 'Usuário deletado com sucesso',
                    deletedUser,
                })
            } catch (error) {
                return res.status(404).json({
                    error,
                })
            }
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async update(req, res) {
        try {
            const id = parseInt(req.params.id)
            const { email, name, password } = req.body
            try {
                const updatedUser = await prisma.user.update({
                    where: { id: id },
                    data: { email: email, name: name, password: password },
                })
                return res.status(200).json({
                    message: 'Usuário atualizado com sucesso',
                    updatedUser,
                })
            } catch (error) {
                return res.status(404).json({
                    error,
                })
            }
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async login(req, res) {
        const { email, password } = req.body
        const user = await prisma.user.findUnique({
            where: { email: email },
        })
        const validated = await bcrypt.compare(password, user.password)
        if (validated) {
            return res.status(200).json({ message: 'conectado' })
        }
        return res.status(404).json({ message: 'usuário ou senha incorreto' })
    }
}

module.exports = new UserController()
