/* eslint-disable import/no-anonymous-default-export */
import './Messages.css'
import React, { Component } from 'react'
class Messages extends Component {
    constructor(props) {
        super(props)
        this.state = { user: sessionStorage.getItem('user') }
    }
    render() {
        return (
            <div className="messages-container">
                <h1>Sua caixa de entrada está vazia {this.state.user}...</h1>
            </div>
        )
    }
}
export default Messages
