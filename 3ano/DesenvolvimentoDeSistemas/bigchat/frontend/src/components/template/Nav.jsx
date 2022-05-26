/* eslint-disable import/no-anonymous-default-export */
import './Nav.css'
import React from 'react'
export default (props) => {
    const isLogged = sessionStorage.getItem('usuario') ? true : false
    const deslogar = () => {
        sessionStorage.removeItem('usuario')
        console.log('deslogado')
        window.location.reload()
    }
    if (isLogged) {
        return (
            <aside className="menu-area">
                <nav className="menu">
                    <button onClick={deslogar}>Sair</button>
                </nav>
            </aside>
        )
    } else {
        return (
            <aside className="menu-area">
                <nav className="menu"></nav>
            </aside>
        )
    }
}
