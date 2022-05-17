const axios = require('axios')
async function loginUser(user, password) {
    const message = await axios
        .post('http://localhost:3030/user/login', {
            usuario: user.toString(),
            senha: password.toString(),
        })
        .then(function(response) {
            return response.data.message
        })
        .catch(function(error) {
            console.error(error)
        })
    return message
}
export { loginUser }
