const express = require('express')
const router = express.Router()
const mysql = require('../mysql').pool

function isFloat(x) {
    return !!(x % 1)
}

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
                            description:
                                'Returns the details of a specific employee',
                            url: 'localhost:3000/employee/' + employee.id,
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
                    const response = {
                        message: 'Employee registered successfully',
                        registeredEmployee: {
                            name: req.body.name,
                            baseSalary: req.body.baseSalary,
                            numberOfChildrenUnderFourteen:
                                req.body.numberOfChildrenUnderFourteen,
                            numberOfIncomeTaxDependents:
                                req.body.numberOfIncomeTaxDependents,
                            wantMealVouchers: req.body.wantMealVouchers,
                            request: {
                                type: 'GET',
                                description: 'Returns all employees',
                                url: 'localhost:3000/employees',
                            },
                        },
                    }
                    return res.status(201).send(response)
                }
            )
        }
)
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
                if (result.length == 0) {
                    return res
                        .status(404)
                        .send({ message: 'Employee not found' })
                }
                const response = {
                    Employee: {
                        id: result[0].id,
                        name: result[0].name,
                        baseSalary: result[0].baseSalary,
                        numberOfChildrenUnderFourteen:
                            result[0].numberOfChildrenUnderFourteen,
                        numberOfIncomeTaxDependents:
                            result[0].numberOfIncomeTaxDependents,
                        wantMealVouchers: result[0].wantMealVouchers,
                        request: {
                            type: 'GET',
                            description: 'Returns all employees',
                            url: 'localhost:3000/employees',
                        },
                    },
                }
                return res.status(200).send(response)
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
                const response = {
                    message: 'Employee successfully modified',
                    modifiedEmployee: {
                        id: req.body.id,
                        name: req.body.name,
                        baseSalary: req.body.baseSalary,
                        numberOfChildrenUnderFourteen:
                            req.body.numberOfChildrenUnderFourteen,
                        numberOfIncomeTaxDependents:
                            req.body.numberOfIncomeTaxDependents,
                        wantMealVouchers: req.body.wantMealVouchers,
                        request: {
                            type: 'GET',
                            description:
                                'Returns the details of a specific employee',
                            url: 'localhost:3000/employee/' + req.body.id,
                        },
                    },
                }
                return res.status(202).send(response)
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
                const responde = {
                    message: 'Employee successfully removed',
                    request: {
                        type: 'POST',
                        description: 'Register an employee',
                        url: 'localhost:3000/employees',
                        body: {
                            name: 'String',
                            baseSalary: 'Float',
                            numberOfChildrenUnderFourteen: 'Integer',
                            numberOfIncomeTaxDependents: 'Integer',
                            wantMealVouchers: 'Bool(1 or 0)',
                        },
                    },
                }
                res.status(202).send({
                    message: 'Employee successfully removed',
                })
            }
        )
    })
})

module.exports = router
