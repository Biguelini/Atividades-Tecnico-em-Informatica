/* eslint-disable import/no-anonymous-default-export */
import './Form.css'
import { loginUser } from '../../utils/login'
import React, { Component } from 'react'
import Swal from 'sweetalert2'
class Form extends Component {
    constructor(props) {
        super(props)
        this.state = { user: '', password: '' }
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }
    handleChange(event) {
        const name = event.target.name
        const value = event.target.value
        this.setState({ [name]: value })
    }
    async handleSubmit(event) {
        const logado = await loginUser(this.state.user, this.state.password)
        if (!logado) {
            return Swal.fire('Algo deu errado...', 'Usuário ou senha incorretos.', 'error')
        } 
        event.preventDefault()
        return console.log(`${this.state.user} logado`)
    }

    render() {
        return (
            <div>
                <h2 className="loginTextForm">Login</h2>
                <div className="formContainer">
                    <form>
                        <label>Usuário:</label>
                        <input
                            type="text"
                            name="user"
                            value={this.state.user}
                            onChange={this.handleChange}
                        />
                        <label>Senha:</label>
                        <input
                            type="password"
                            name="password"
                            value={this.state.password}
                            onChange={this.handleChange}
                        />
                    </form>
                    <button onClick={this.handleSubmit}>Enviar</button>
                </div>
            </div>
        )
    }
}
export default Form
