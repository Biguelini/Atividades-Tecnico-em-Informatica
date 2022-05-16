/* eslint-disable import/no-anonymous-default-export */
import './App.css'
import React from 'react'
import Header from '../components/template/Header'
import Form from '../components/template/Form'

export default (props) => (
    <div className="app">
        <Header />
        <Form></Form>
    </div>
)
