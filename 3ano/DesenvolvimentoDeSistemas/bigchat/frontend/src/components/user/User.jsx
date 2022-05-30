/* eslint-disable import/no-anonymous-default-export */
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Navigate } from 'react-router-dom'
import './User.css'
export default (props) => {
    const [mensagens, setMensagens] = useState([])
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
                <h1>Usuário</h1>
                <button
                    onClick={() => {
                        console.log(mensagens)
                    }}
                >
                    Clica
                </button>
            </main>
        )
    } else {
        return <Navigate to="/login" />
    }
}
