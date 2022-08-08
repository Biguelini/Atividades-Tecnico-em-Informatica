/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Navigate } from 'react-router-dom'
import Swal from 'sweetalert2'
import Button from '../template/Button'
import './Admin.css'

export default (props) => {
    const [users, setUsers] = useState([])
    const [usuario, setUsuario] = useState([])
    const [nome, setNome] = useState([])
    const [senha, setSenha] = useState([])
    const [texto, setTexto] = useState('Cadastrar')
    const [isEditing, setIsEditing] = useState(false)
    const getUsers = async () => {
        const url = 'http://localhost:3030/user'
        axios.get(url).then((res) => {
            const data = res.data
            setUsers(data)
        })
    }
    const loadEditUser = async (usuario) => {
        setIsEditing(true)
        setTexto('Editar')
        const url = 'http://localhost:3030/user/' + usuario
        axios.get(url).then((res) => {
            setUsuario(res.data.usuario)
            setNome(res.data.nome)
            setSenha(res.data.senha)
            window.location.href = '#form'
            return res.data
        })
    }
    const saveUser = async () => {
        if (usuario !== '' && nome !== '' && senha !== '') {
            if (isEditing) {
                setTexto('Cadastrar')
                axios
                    .put('http://localhost:3030/user/' + usuario, {
                        nome: nome,
                        senha: senha,
                    })
                    .then(function (response) {
                        getUsers()
                        setNome('')
                        setSenha('')
                        setUsuario('')
                        setIsEditing(false)

                        return Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Usuário foi editado com sucesso',
                            showConfirmButton: false,
                            timer: 1500,
                        })
                    })
                    .catch(function (error) {
                        console.error(error)
                    })
            } else {
                if(senha.trim().length >= 5 && usuario.trim().length <= 10 && usuario.trim().length >=5 && usuario !== "lucio"){
                    axios
                        .post('http://localhost:3030/user/', {
                            nome: nome,
                            usuario: usuario.trim(),
                            senha: senha.trim(),
                        })
                        .then(function (response) {
                            getUsers()
                            setNome('')
                            setSenha('')
                            setUsuario('')
                            setIsEditing(false)
                            return Swal.fire({
                                position: 'top-end',
                                icon: 'success',
                                title: 'Usuário foi criado com sucesso',
                                showConfirmButton: false,
                                timer: 1500,
                            })
                        })
                        .catch(function (error) {
                            console.error(error)
                            return Swal.fire({
                                position: 'top-end',
                                icon: 'error',
                                title: 'Algo não ocorreu bem',
                                showConfirmButton: false,
                                timer: 1500,
                            })
                        })

                } else {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Algo não ocorreu bem',
                        showConfirmButton: false,
                        timer: 1500,
                    })
                }
            }
        } else {
            return Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: 'Preencha todos os campos',
                showConfirmButton: false,
                timer: 1500,
            })
        }
    }
    const clearForm = () => {
        setNome('')
        setSenha('')
        setUsuario('')
        setIsEditing(false)
    }
    const deleteUsers = async (usuario) => {
        const url = 'http://localhost:3030/user/' + usuario
        Swal.fire({
            title: 'Deseja deletar esse usuário?',
            showDenyButton: true,
            confirmButtonText: 'Excluir',
            denyButtonText: `Cancelar`,
        }).then((result) => {
            if (result.isConfirmed) {
                axios
                    .delete(url)
                    .then(function () {
                        getUsers()
                        return Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Usuário deletado',
                            showConfirmButton: false,
                            timer: 1500,
                        })
                    })
                    .catch(function (error) {
                        console.error(error)
                        return Swal.fire({
                            position: 'top-end',
                            icon: 'error',
                            title: 'Este usuário possui mensagens',
                            showConfirmButton: false,
                            timer: 1500,
                        })
                    })
            }
        })
    }
    useEffect(() => {
        getUsers()
    }, [])

    if (sessionStorage.getItem('usuario') === 'lucio') {
        return (
            <main className="content">
                <table className="tableUsers" id='tableUsers'>
                    <thead>
                        <tr>
                            <th>Usuário</th>
                            <th>Nome</th>
                            <th>Senha</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user) => {
                            return (
                                <tr key={user.usuario}>
                                    <td>{user.usuario}</td>
                                    <td>{user.nome}</td>
                                    <td>{'•'.repeat(user.senha.length)}</td>
                                    <td>
                                        <Button
                                            text="Deletar"
                                            classe="btnTable"
                                            acao={(e)=>deleteUsers(user.usuario)}
                                        />
                                        <Button
                                            text="Editar"
                                            classe="btnTable"
                                            acao={(e)=>loadEditUser(user.usuario)}
                                        />
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
                <div className="formContainer mb-5">
                    <h2>{texto}</h2>
                    <form className="formLogin" id="form">
                        <label>Usuário</label>
                        <input
                        
                            type="text"
                            value={usuario}
                            onChange={(e) => {
                                if (isEditing) {
                                    return Swal.fire({
                                        position: 'top-end',
                                        icon: 'error',
                                        title: 'Não pode editar o usuário',
                                        showConfirmButton: false,
                                        timer: 1500,
                                    })
                                }
                                setUsuario(e.target.value)
                            }}
                        />
                        <label>Nome</label>
                        <input
                            type="text"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                        />
                        <label>Senha</label>
                        <input
                            type="password"
                            value={senha}
                            onChange={(e) => setSenha(e.target.value)}
                        />
                    </form>
                    <Button
                        text="Salvar"
                        classe="btnFilled"
                        acao={(e)=>saveUser()}
                    />
                    <Button
                        text="Cancelar"
                        classe="btnFilled"
                        acao={(e)=>clearForm()}
                    />
                </div>
            </main>
        )
    } else if (sessionStorage.getItem('usuario')) {
        return <Navigate to="/user" />
    } else {
        return <Navigate to="/login" />
    }
}
