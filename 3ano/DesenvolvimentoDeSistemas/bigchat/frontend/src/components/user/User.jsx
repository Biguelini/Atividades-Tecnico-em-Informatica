/* eslint-disable import/no-anonymous-default-export */
import React, { useState } from 'react'
import { Navigate } from 'react-router-dom'
import './User.css'
export default (props) => {
    if (sessionStorage.getItem('usuario') === 'lucio') {
        return <Navigate to="/admin" />
        
    } else if (sessionStorage.getItem('usuario')) {
        return (
            <main className="content">
                <h1>Usuário</h1>
            </main>
        )
    } else {
        return <Navigate to="/login" />
    }
}
