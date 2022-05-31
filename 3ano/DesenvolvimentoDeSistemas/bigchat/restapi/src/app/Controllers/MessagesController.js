const { PrismaClient } = require('@prisma/client')

const prisma = new PrismaClient()

var moment = require('moment-timezone')
class MessagesController {
    async read(req, res) {
        const usuario = req.params.usuario
        try {
            const messages = await prisma.mensagem.findMany({
                where: { destinatario: usuario },
            })
            console.log
            return res.status(200).json(messages)
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async create(req, res) {
        const { remetente, destinatario, assunto, mensagem } = req.body
        try {
            const message = await prisma.mensagem.create({
                data: {
                    remetente: remetente,
                    destinatario: destinatario,
                    assunto: assunto,
                    mensagem: mensagem,
                },
            })
            return res.status(201).json(message)
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
    async delete(req, res) {
        const id = parseInt(req.params.id)
        try {
            const deletedMessage = await prisma.mensagem.delete({
                where: { id: id },
            })
            return res.status(201).json(deletedMessage)
        } catch (e) {
            return console.log(e)
        } finally {
            ;async () => {
                await prisma.$disconnect()
            }
        }
    }
}

module.exports = new MessagesController()
