/* eslint-disable import/no-anonymous-default-export */
import './App.css'
import React, { Component } from 'react'
import Header from '../components/template/Header'
import Form from '../components/template/Form'
import Messages from '../components/template/Messages'

class App extends Component {
    constructor(props) {
        super(props)
        this.state = { user: sessionStorage.getItem('user') }
    }

    render() {
        if (this.state.user) {
            return (
                <div className="app">
                    <Header />
                    <Messages />
                </div>
            )
        }
        return (
            <div className="app">
                <Header />
                <Form />
            </div>
        )
    }
}
export default App
