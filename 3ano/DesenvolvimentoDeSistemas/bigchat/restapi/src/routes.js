const { PrismaClient } = require('@prisma/client')

const prisma = new PrismaClient()

const router = require('express').Router()

router.post('/user', async (req, res) => {
    try {
        const { name, email } = req.body

        const userEmailIsAlreadyUsed = await prisma.user.findUnique({
            where: { email },
        })
        if (userEmailIsAlreadyUsed) {
            return res.json({ error: 'This email is already used' })
        }
        const createdUser = await prisma.user.create({ data: { name, email } })
        return res.json(createdUser)
    } catch (error) {
        return res.json({ error: error })
    }
})

module.exports = router
