const axios = require('axios')
async function delUser(usuario) {
    const url = 'http://localhost:3030/user/' + usuario
    const user = await axios
        .delete(url)
        .then(function (response) {
            return response.data
        })
        .catch(function (error) {
            console.error(error)
        })
    return user
}
export { delUser }
