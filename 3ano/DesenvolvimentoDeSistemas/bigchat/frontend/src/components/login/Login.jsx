/* eslint-disable import/no-anonymous-default-export */
import React, { useState } from 'react'
import Header from '../templates/Header'
import './Login.css'
export default (props) => {
    const [nome, setNome] = useState([])
    const [senha, setSenha] = useState([])
    const loginUser = ()=>{
        console.log(nome, senha)
    }
    return (
        <React.Fragment>
            <Header />
            <main>
                <div className="formContainer">
                    <h2>Login</h2>
                    <form className="formLogin">
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
                    <button onClick={loginUser}>Enviar</button>
                </div>
            </main>
        </React.Fragment>
    )
}
