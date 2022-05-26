/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useState } from 'react'
import { Navigate } from 'react-router'
import Swal from 'sweetalert2'
import './Login.css'
export default (props) => {
    const [usuario, setUsuario] = useState([])
    const [senha, setSenha] = useState([])
    const usuarioLogado = sessionStorage.getItem('usuario')
    const loginUser = () => {
        if (usuario === 'lucio' && senha === 'root') {
            console.log('logado')
            sessionStorage.setItem('usuario', usuario)
            window.location.reload()
        } else {
            try {
                axios
                    .post('http://localhost:3030/user/login', {
                        usuario: usuario,
                        senha: senha,
                    })
                    .then(function (response) {
                        return response.data.message
                    })
                    .catch(function (error) {
                        console.error(error)
                    })
                sessionStorage.setItem('usuario', usuario)
                window.location.reload()
            } catch {
                Swal.fire(
                    'Usuário e/ou senha incorretos!',
                    'Confira suas credenciais...',
                    'error'
                )
            }
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
                    <form className="formLogin">
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
                    </form>
                    <button onClick={loginUser}>Enviar</button>
                </div>
            </main>
        )
    }
}
