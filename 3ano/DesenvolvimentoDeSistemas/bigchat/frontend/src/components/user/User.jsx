/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Navigate } from 'react-router-dom'
import Swal from 'sweetalert2'
import './User.css'
export default (props) => {
    const [mensagens, setMensagens] = useState([])
    const [users, setUsers] = useState([])
    const [assunto, setAssunto] = useState([])
    const [destinatario, setDestinatario] = useState('')
    const [mensagem, setMensagem] = useState([])

    const getUsers = async () => {
        const url = 'http://localhost:3030/user'
        axios.get(url).then((res) => {
            const data = res.data
            setUsers(data)
        })
    }
    const showMessage = (mensagem) => {
        Swal.fire({
            title: `${mensagem.assunto}`,
            html:
                `<span class="remetente">De: ${mensagem.remetente}</span>` +
                `<span class="data">Enviado em: ${mensagem.data}</span>` +
                `<span class="mensagem">${mensagem.mensagem}</span>`,
            showCloseButton: true,
            showCancelButton: false,
            showDenyButton: true,
            denyButtonText: `Excluir`,
            focusConfirm: false,
            confirmButtonText: 'Fechar mensagem',
            showConfirmButton: false,
        }).then((result) => {
            if (result.isDenied) {
                deleteMessage(mensagem.id)
            }
        })
    }
    const deleteMessage = (id) => {
        const url = 'http://localhost:3030/messages/' + id
        Swal.fire({
            title: 'Deseja deletar essa mensagem?',
            showDenyButton: true,
            confirmButtonText: 'Excluir',
            denyButtonText: `Cancelar`,
        }).then((result) => {
            if (result.isConfirmed) {
                axios
                    .delete(url)
                    .then(function () {
                        getMessages()
                    })
                    .catch(function (error) {
                        console.error(error)
                    })
            }
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
    const sendMessage = () => {
        if (mensagem && destinatario && assunto) {
            axios
                .post('http://localhost:3030/messages', {
                    assunto: assunto,
                    destinatario: destinatario,
                    remetente: sessionStorage.getItem('usuario'),
                    mensagem: mensagem,
                })
                .then(function (response) {
                    Swal.fire('Enviado', 'Sua mensagem foi enviada', 'success')
                })
                .catch(function (error) {
                    Swal.fire(
                        'Erro :(',
                        'Algo não saiu como esperávamos',
                        'error'
                    )
                    return console.error(error)
                })
        } else {
            Swal.fire('Erro :(', 'Preencha corretamente os campos', 'error')
        }
        console.log(assunto, destinatario, mensagem)
    }
    useEffect(() => {
        getMessages()
        getUsers()
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
                        <label>Assunto</label>
                        <input
                            type="text"
                            onChange={(e) => setAssunto(e.target.value)}
                            value={assunto}
                        />
                        <label>Destinatario</label>
                        <select
                            value={destinatario}
                            onChange={(e) => setDestinatario(e.target.value)}
                        >
                            <option value={null}>Selecione</option>
                            {users.map((user, index) => (
                                <option key={user.usuario} value={user.usuario}>
                                    {user.usuario}
                                </option>
                            ))}
                        </select>
                        <label>Mensagem</label>
                        <textarea
                            cols="30"
                            rows="10"
                            onChange={(e) => setMensagem(e.target.value)}
                            value={mensagem}
                        ></textarea>
                    </form>
                    <button
                        onClick={() => {
                            sendMessage()
                        }}
                    >
                        Enviar
                    </button>
                </div>
            </main>
        )
    } else {
        return <Navigate to="/login" />
    }
}
