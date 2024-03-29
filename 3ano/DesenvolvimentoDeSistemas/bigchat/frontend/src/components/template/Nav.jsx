/* eslint-disable import/no-anonymous-default-export */
import './Nav.css'
import React from 'react'
export default (props) => {
    const isLogged = sessionStorage.getItem('usuario') ? true : false
    const deslogar = () => {
        sessionStorage.removeItem('usuario')
        window.location.href = '/login'
    }
    if (isLogged) {
        return (
            <aside className="menu-area">
                <button className="exitBtn" onClick={deslogar}>
                    Sair
                </button>
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
