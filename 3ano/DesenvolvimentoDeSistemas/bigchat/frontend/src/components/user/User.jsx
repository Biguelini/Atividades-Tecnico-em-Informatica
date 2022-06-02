/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Navigate } from 'react-router-dom'
import Swal from 'sweetalert2'
import './User.css'
export default (props) => {
    const [mensagens, setMensagens] = useState([])
    const showMessage = (mensagem) => {
        Swal.fire({
            title: `${mensagem.assunto}`,
            html:
                `<span class="remetente">De: ${mensagem.remetente}</span>` +
                `<span class="data">Enviado em: ${mensagem.data}</span>` +
                `<span class="mensagem">${mensagem.mensagem}</span>`,
            showCloseButton: true,
            showCancelButton: false,
            focusConfirm: false,
            confirmButtonText: 'Fechar mensagem',
            showConfirmButton: false,
        })
    }
    const getMessages = () => {
        const url =
            'http://localhost:3030/messages/' +
            sessionStorage.getItem('usuario')
        axios.get(url).then((res) => {
            const data = res.data
            setMensagens(data)
        })
    }
    useEffect(() => {
        getMessages()
    }, [])
    if (sessionStorage.getItem('usuario') === 'lucio') {
        return <Navigate to="/admin" />
    } else if (sessionStorage.getItem('usuario')) {
        return (
            <main className="content">
                <table className="tableUsers">
                    <thead>
                        <tr>
                            <th>Remetente</th>
                            <th>Mensagem</th>
                            <th>Data</th>
                        </tr>
                    </thead>
                    <tbody>
                        {mensagens.map((mensagem) => {
                            return (
                                <tr
                                    key={mensagem.id}
                                    onClick={() => {
                                        showMessage(mensagem)
                                    }}
                                >
                                    <td>{mensagem.remetente}</td>
                                    <td>{mensagem.assunto}</td>
                                    <td>{mensagem.data}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
                <div className="formContainer MsgForm">
                    <h2>Escreva uma mensagem</h2>
                    <form className="formLogin">
                        <label>Usuário</label>
                        <input
                            type="text"
                        />
                        <label>Senha</label>
                        <input
                            type="password"
                        />
                        <label>Mensagem</label>
                        <textarea name="" id="" cols="30" rows="10"></textarea>
                    </form>
                    <button >Enviar</button>
                </div>
            </main>
        )
    } else {
        return <Navigate to="/login" />
    }
}
