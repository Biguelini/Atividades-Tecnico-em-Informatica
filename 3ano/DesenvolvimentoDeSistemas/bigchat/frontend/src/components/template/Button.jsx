/* eslint-disable import/no-anonymous-default-export */
import './Button.css'
import React from 'react'

export default (props) => (
    <button className={props.classe} onClick={props.acao}>
        {props.text}
    </button>
)
