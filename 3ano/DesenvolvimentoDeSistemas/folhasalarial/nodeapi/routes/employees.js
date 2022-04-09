const express = require('express')
const router = express.Router()
const mysql = require('../mysql').pool

router.get('/', (req, res, next) => {
    mysql.getConnection((error, conn) => {
        if (error) {
            return res.status(500).send({ error: error })
        }
        conn.query('SELECT * FROM employees', (error, result, fields) => {
            if (error) {
                return res.status(500).send({ error: error })
            }
            const response = {
                amount: result.length,
                employees: result.map((employee) => {
                    return {
                        id: employee.id,
                        name: employee.name,
                        baseSalary: employee.baseSalary,
                        numberOfChildrenUnderFourteen:
                            employee.numberOfChildrenUnderFourteen,
                        numberOfIncomeTaxDependents:
                            employee.numberOfIncomeTaxDependents,
                        wantMealVouchers: employee.wantMealVouchers,
                        request: {
                            type: 'GET',
                            description: 'Returns all registered employees',
                            url: 'localhost:3000/employees/' + employee.id,
                        },
                    }
                }),
            }
            return res.status(200).send({ response })
        })
    })
})

router.post('/', (req, res, next) => {
    mysql.getConnection((error, conn) => {
        if (error) {
            return res.status(500).send({ error: error })
        }
        conn.query(
            'INSERT INTO employees (name, baseSalary, numberOfChildrenUnderFourteen, numberOfIncomeTaxDependents, wantMealVouchers) VALUES (?,?,?,?,?)',
            [
                req.body.name,
                req.body.baseSalary,
                req.body.numberOfChildrenUnderFourteen,
                req.body.numberOfIncomeTaxDependents,
                req.body.wantMealVouchers,
            ],
            (error, result, fields) => {
                conn.release()
                if (error) {
                    return res.status(500).send({ error: error })
                }
                res.status(201).send({
                    message: 'Funcionário inserido com sucesso',
                    idEmployee: result.insertId,
                })
            }
        )
    })
})

router.get('/:id_employee', (req, res, next) => {
    mysql.getConnection((error, conn) => {
        if (error) {
            return res.status(500).send({ error: error })
        }
        conn.query(
            'SELECT * FROM employees WHERE id =?',
            [req.params.id_employee],
            (error, result, fields) => {
                if (error) {
                    return res.status(500).send({ error: error })
                }
                return res.status(200).send({ employee: result })
            }
        )
    })
})
router.patch('/', (req, res, next) => {
    mysql.getConnection((error, conn) => {
        if (error) {
            return res.status(500).send({ error: error })
        }
        conn.query(
            `UPDATE employees SET name =?, baseSalary =?, numberOfChildrenUnderFourteen =?, numberOfIncomeTaxDependents =?, wantMealVouchers =? WHERE id = ?`,
            [
                req.body.name,
                req.body.baseSalary,
                req.body.numberOfChildrenUnderFourteen,
                req.body.numberOfIncomeTaxDependents,
                req.body.wantMealVouchers,
                req.body.id,
            ],
            (error, result, fields) => {
                conn.release()
                if (error) {
                    return res.status(500).send({ error: error })
                }
                res.status(202).send({
                    message: 'Funcionário alterado com sucesso',
                })
            }
        )
    })
})
router.delete('/', (req, res, next) => {
    mysql.getConnection((error, conn) => {
        if (error) {
            return res.status(500).send({ error: error })
        }
        conn.query(
            `DELETE FROM employees WHERE id = ?`,
            [req.body.id],
            (error, result, fields) => {
                conn.release()
                if (error) {
                    return res.status(500).send({ error: error })
                }
                res.status(202).send({
                    message: 'Funcionário removido com sucesso',
                })
            }
        )
    })
})

module.exports = router
