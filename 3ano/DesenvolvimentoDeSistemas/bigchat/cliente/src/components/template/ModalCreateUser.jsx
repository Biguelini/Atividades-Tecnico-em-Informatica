/* eslint-disable import/no-anonymous-default-export */
import './ModalCreateUser.css'
import React, { Component } from 'react'
class ModalCreateUser extends Component {
    render() {
        return (
            <div className="modal">
                <h1>Editar usuário</h1>
                <div className="modalContainer">
                    <form>
                        <label>Usuário:</label>
                        <input
                            type="text"
                            name="user"
                        />
                        <label>Senha:</label>
                        <input
                            type="password"
                            name="password"
                        />
                    </form>
                    <button >Enviar</button>
                </div>
            </div>
        )
    }
}
export default ModalCreateUser
