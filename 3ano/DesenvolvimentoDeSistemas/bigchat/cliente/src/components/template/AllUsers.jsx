/* eslint-disable import/no-anonymous-default-export */
import './AllUsers.css'
import React, { useEffect, useState } from 'react'
import axios from 'axios'
import ModalCreateUser from './ModalCreateUser'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPenToSquare, faTrashCan } from '@fortawesome/free-solid-svg-icons'
export default function AllUsers(props) {
    const [users, setUsers] = useState([])

    const getUser = async () => {
        const url = 'http://localhost:3030/user'
        axios.get(url).then((res) => {
            const data = res.data
            setUsers(data)
        })
    }
    const delUser = async (usuario) => {
        const url = 'http://localhost:3030/user/' + usuario
        axios
            .delete(url)
            .then(function (response) {
                getUser()
            })
            .catch(function (error) {
                console.error(error)
            })
    }
    useEffect(() => {
        getUser()
    }, [])
    console.log(users)
    return (
        <div className="messages-container">
            <ModalCreateUser/>
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
                    {users.map((user) => {
                        return (
                            <tr>
                                <td>{user.usuario}</td>
                                <td>{user.nome}</td>
                                <td>{user.senha}</td>
                                <td>
                                    <button className="btnDel">
                                        <FontAwesomeIcon
                                            icon={faTrashCan}
                                            onClick={() => {
                                                console.log(
                                                    `Deletar ${user.usuario}`
                                                )
                                                delUser(user.usuario)
                                            }}
                                        />
                                    </button>
                                </td>
                                <td>
                                    <button className="btnEdit">
                                        <FontAwesomeIcon
                                            icon={faPenToSquare}
                                            onClick={() => {
                                                console.log(
                                                    `Editar ${user.usuario}`
                                                )
                                            }}
                                        />
                                    </button>
                                </td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </div>
    )
}
