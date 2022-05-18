/* eslint-disable import/no-anonymous-default-export */
import './AllUsers.css'
import React, { Component } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPenToSquare, faTrashCan } from '@fortawesome/free-solid-svg-icons'
import { getUsers } from '../../utils/getUsers'
class AllUsers extends Component {
    constructor(props) {
        super(props)
    }
    async getAllUsers() {
        const users = await getUsers()
        users.map((user, i) => {
            console.log(user)
        })
    }
    render() {
        return (
            <div className="messages-container">
                <table>
                    <thead>
                        <tr>
                            <th>Usuário</th>
                            <th>Nome</th>
                            <th>Senha</th>
                            <th>Deletar</th>
                            <th>Alterar</th>
                        </tr>
                    </thead>
                    <tbody id="tableUsers">
                        <tr>
                            <td>bigue</td>
                            <td>João</td>
                            <td>123456</td>
                            <td>
                                <button onClick={this.getAllUsers}>
                                    <FontAwesomeIcon icon={faTrashCan} />
                                </button>
                            </td>
                            <td>
                                <button>
                                    <FontAwesomeIcon icon={faPenToSquare} />
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}
export default AllUsers
