/* eslint-disable import/no-anonymous-default-export */
import './Header.css'
import React, { Component } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faArrowRightFromBracket } from '@fortawesome/free-solid-svg-icons'
class Header extends Component {
    constructor(props) {
        super(props)
        this.state = { user: sessionStorage.getItem('user') }
    }
    render() {
        if (this.state.user) {
            return (
                <div className="header">
                    <h1 className="logo">BigChat</h1>
                    <button
                        className="bSair"
                        onClick={() => {
                            sessionStorage.removeItem('user')
                            return window.location.reload()
                        }}
                    >
                        <p>Sair</p>
                        <FontAwesomeIcon icon={faArrowRightFromBracket} />
                    </button>
                </div>
            )
        }
        return (
            <div className="header">
                <h1 className="logo">BigChat</h1>
            </div>
        )
    }
}
export default Header
