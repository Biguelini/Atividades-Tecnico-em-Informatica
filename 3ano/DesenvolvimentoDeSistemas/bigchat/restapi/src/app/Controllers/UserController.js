const { PrismaClient } = require('@prisma/client')

const prisma = new PrismaClient()
class UserController {
    async read(req, res) {
        try {
            const allUsers = await prisma.usuario.findMany()
            return res.status(200).json(allUsers)
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async readOne(req, res) {
        try {
            const usuario = req.params.usuario
            const user = await prisma.usuario.findUnique({
                where: { usuario: usuario },
            })
            return res.status(200).json(user)
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
            const { usuario, nome, senha } = req.body
            const userAlreadyUsed = await prisma.usuario.findUnique({
                where: { usuario: usuario },
            })
            if (userAlreadyUsed) {
                return res.status(409).json({ message: 'User is already used' })
            }
            const createdUser = { nome: nome, usuario: usuario, senha: senha }
            await prisma.usuario.create({
                data: {
                    nome: nome,
                    usuario: usuario,
                    senha: senha,
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
            const usuario = req.params.usuario
            try {
                const haveMessage = await prisma.mensagem.findMany({
                    where: { destinatario: usuario },
                })
                const alreadySendMessage = await prisma.mensagem.findMany({
                    where: { remetente: usuario },
                })
                console.log(haveMessage.length, alreadySendMessage.length)
                if (haveMessage.length !== 0 || alreadySendMessage.length !== 0) {
                    return res.status(401).json({
                        message: 'O usuário possui mensagens',
                    })
                } else {
                    console.log(haveMessage, alreadySendMessage)
                    const deletedUser = await prisma.usuario.delete({
                        where: { usuario: usuario },
                    })
                    return res.status(200).json({
                        message: 'Usuário deletado com sucesso',
                        deletedUser,
                    })
                }
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
            const usuario = req.params.usuario
            const { nome, senha } = req.body
            try {
                const updatedUser = await prisma.usuario.update({
                    where: { usuario: usuario },
                    data: { nome: nome, senha: senha },
                })
                return res.status(200).json({
                    message: 'Usuário atualizado com sucesso',
                    updatedUser,
                })
            } catch (error) {
                return res.status(404).json({
                    error: error,
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
        const { usuario, senha } = req.body
        if (usuario != '') {
            const user = await prisma.usuario.findUnique({
                where: { usuario: usuario },
            })
            if (user) {
                const validated = senha == user.senha ? true : false
                if (validated) {
                    return res.status(200).json({ message: 'conectado' })
                }
            }
        }
        return res.status(401).json({ message: 'usuário ou senha incorretos' })
    }
}

module.exports = new UserController()
