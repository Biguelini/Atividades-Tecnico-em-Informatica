/* eslint-disable import/no-anonymous-default-export */
import './Form.css'
import Field from './Field.jsx'
import Label from './Label.jsx'
import React from 'react'
import ButtonSubmit from './ButtonSubmit'
export default (props) => (
    <div>
        <h2 className="loginTextForm">Login</h2>
        <div className="formContainer">
            <form className="form">
                <Label />
                <Field />
                <Label />
                <Field />
            </form>
            <ButtonSubmit />
        </div>
    </div>
)
