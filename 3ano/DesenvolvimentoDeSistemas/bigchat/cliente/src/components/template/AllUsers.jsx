/* eslint-disable import/no-anonymous-default-export */
import './AllUsers.css'
import './ModalCreateUser.css'
import './ModalEditUser.css'
import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {
    faAdd,
    faClose,
    faPenToSquare,
    faTrashCan,
} from '@fortawesome/free-solid-svg-icons'
export default function AllUsers(props) {
    const [users, setUsers] = useState([])
    const [hidden, setHidden] = useState(true)
    const [createHidden, setCreateHidden] = useState(true)
    const [nome, setNome] = useState('')
    const [usuario, setUsuario] = useState('')
    const [senha, setSenha] = useState('')
    const [editNome, setEditNome] = useState('')
    const [editSenha, setEditSenha] = useState('')

    const newUser = async () => {
        setNome(nome)
        setUsuario(usuario)
        setSenha(senha)
        axios
            .post('http://localhost:3030/user/', {
                nome: nome,
                usuario: usuario,
                senha: senha,
            })
            .then(function (response) {
                getUsers()
            })
            .catch(function (error) {
                console.error(error)
            })
    }
    const getUser = async (usuario) => {
        const url = 'http://localhost:3030/user/' + usuario
        const data = await axios.get(url).then((res) => {
            defineUserToEdit(data.nome, data.senha)
            return res.data
        })
    }
    const defineUserToEdit = (nome, senha) =>{
        setEditNome(nome)
        setEditSenha(senha)
    }
    const getUsers = async () => {
        const url = 'http://localhost:3030/user'
        axios.get(url).then((res) => {
            const data = res.data
            setUsers(data)
        })
    }
    const editUser = () => {
        getUsers()
        if (hidden === true) {
            setHidden(false)
        } else {
            setHidden(true)
        }
    }
    const modalCreateShowHide = () => {
        if (createHidden === true) {
            setCreateHidden(false)
        } else {
            setCreateHidden(true)
        }
    }
    const delUser = async (usuario) => {
        const url = 'http://localhost:3030/user/' + usuario
        axios
            .delete(url)
            .then(function () {
                getUsers()
            })
            .catch(function (error) {
                console.error(error)
            })
    }
    useEffect(() => {
        getUsers()
    }, [])
    console.log(users)
    if (hidden === true) {
        if (createHidden === false) {
            return (
                <div className="messages-container">
                    <button
                        className="btnModalShow"
                        onClick={() => {
                            modalCreateShowHide()
                        }}
                    >
                        <FontAwesomeIcon icon={faAdd} />
                    </button>
                    <div className="createUserModal modal">
                        <button
                            className="closeBtnModalEditUser"
                            onClick={() => {
                                modalCreateShowHide()
                            }}
                        >
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                        <h1>Criar usuário</h1>
                        <div className="modalContainer">
                            <form>
                                <label>Usuário:</label>
                                <input
                                    type="text"
                                    name="usuário"
                                    onChange={(e) => setUsuario(e.target.value)}
                                    value={usuario}
                                />
                                <label>Nome:</label>
                                <input
                                    type="text"
                                    name="nome"
                                    onChange={(e) => setNome(e.target.value)}
                                    value={nome}
                                />
                                <label>Senha:</label>
                                <input
                                    type="password"
                                    name="password"
                                    onChange={(e) => setSenha(e.target.value)}
                                    value={senha}
                                />
                            </form>
                            <button
                                onClick={() => {
                                    newUser()
                                    modalCreateShowHide()
                                }}
                            >
                                Enviar
                            </button>
                        </div>
                    </div>
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
        } else {
            return (
                <div className="messages-container">
                    <button
                        className="btnModalShow"
                        onClick={() => {
                            modalCreateShowHide()
                        }}
                    >
                        <FontAwesomeIcon icon={faAdd} />
                    </button>
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
                                                        editUser()
                                                        getUser(user.usuario)
                                                        console.log(
                                                            `Editar ${user.usuario}`
                                                        )
                                                        console.log(editNome)
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
    } else {
        return (
            <div className="messages-container">
                <button
                    className="btnModalShow"
                    onClick={() => {
                        modalCreateShowHide()
                    }}
                >
                    <FontAwesomeIcon icon={faAdd} />
                </button>
                <div className="modal">
                    <button
                        className="closeBtnModalEditUser"
                        onClick={() => {
                            editUser()
                        }}
                    >
                        <FontAwesomeIcon icon={faClose} />
                    </button>
                    <h1>Editar usuário</h1>
                    <div className="modalContainer">
                        <form>
                            <label>Usuário:</label>
                            <input type="text" name="user" />
                            <label>Senha:</label>
                            <input type="password" name="password" />
                        </form>
                        <button>Enviar</button>
                    </div>
                </div>
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
}
