class UserController {
    index(req, res) {
        console.log(req.body)
        const user = req.body
        return res.status(200).json({
            error: false,
            user,
        })
    }

    show(req, res) {
        const users = ['Kaio', 'Larissa', 'Danver']
        return res.status(200).json({
            error: false,
            users,
        })
    }
}

module.exports = new UserController()
