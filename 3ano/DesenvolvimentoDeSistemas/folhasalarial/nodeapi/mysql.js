const mysql = require('mysql')
var pool = mysql.createPool({
    "user": "root",
    "password": "vertrigo",
    "database": "folhasalarial",
    "host": "localhost",
    "port": 3306,
})
exports.pool = pool