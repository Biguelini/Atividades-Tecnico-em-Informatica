/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useState } from 'react'
import { Navigate } from 'react-router'
import Swal from 'sweetalert2'
import Button from '../template/Button'
import './Login.css'
export default (props) => {
    const [usuario, setUsuario] = useState([])
    const [senha, setSenha] = useState([])
    const usuarioLogado = sessionStorage.getItem('usuario')
    const loginUser = (e) => {
        e.preventDefault()
        if (usuario === 'lucio' && senha === 'root') {
            console.log('logado')
            sessionStorage.setItem('usuario', usuario)
            window.location.href = '/admin'
        } else {
            axios
                .post('http://localhost:3030/user/login', {
                    usuario: usuario,
                    senha: senha,
                })
                .then(function (response) {
                    sessionStorage.setItem('usuario', usuario)
                    window.location.href = '/admin'
                    return response.data.message
                })
                .catch(function (error) {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Login ou usuário incorretos',
                        showConfirmButton: false,
                        timer: 1500,
                    })
                    return console.error(error)
                })
        }
    }
    if (usuarioLogado === 'lucio') {
        return <Navigate to="/admin" />
    } else if (usuarioLogado) {
        return <Navigate to="/user" />
    } else {
        return (
            <main className="content">
                <div className="formContainer">
                    <h2>Login</h2>
                    <form className="formLogin" onSubmit={loginUser}>
                        <label>Usuário</label>
                        <input
                            type="text"
                            value={usuario}
                            onChange={(e) => setUsuario(e.target.value)}
                        />
                        <label>Senha</label>
                        <input
                            type="password"
                            value={senha}
                            onChange={(e) => setSenha(e.target.value)}
                        />
                        <Button text="Login" classe="btnFilled"></Button>
                    </form>
                </div>
            </main>
        )
    }
}
