const axios = require('axios')
async function getUsers() {
    const users = await axios
        .get('http://localhost:3030/user')
        .then(function (response) {
            return response.data
        })
        .catch(function (error) {
            console.error(error)
        })
    return users
}
export { getUsers }
