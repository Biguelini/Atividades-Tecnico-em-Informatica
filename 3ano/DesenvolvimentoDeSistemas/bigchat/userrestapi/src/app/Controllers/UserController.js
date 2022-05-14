const { PrismaClient } = require('@prisma/client')

const prisma = new PrismaClient()

class UserController {
    show(req, res) {
        async function main() {
            const allUsers = await prisma.user.findMany()
            return res.status(200).json(allUsers)
        }
        main()
            .catch((e) => {
                throw e
            })
            .finally(async () => {
                await prisma.$disconnect()
            })
    }
    create(req, res) {
        async function main() {
            const { email, name, password } = req.body
            const createdUser = req.body
            await prisma.user.create({
                data: {
                    name: name,
                    email: email,
                    password: password,
                },
            })
            return res
                .status(200)
                .json({ message: 'User created', createdUser })
        }
        main()
            .catch((e) => {
                throw e
            })
            .finally(async () => {
                await prisma.$disconnect()
            })
    }
}

module.exports = new UserController()
