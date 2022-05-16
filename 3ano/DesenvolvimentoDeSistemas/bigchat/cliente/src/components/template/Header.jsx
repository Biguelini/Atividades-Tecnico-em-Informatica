/* eslint-disable import/no-anonymous-default-export */
import './Header.css'
import React from 'react'
import Nav from './Nav.jsx'
import Logo from './Logo.jsx'
export default (props) => (
    <div className="header">
        <Logo />
        <Nav />
    </div>
)
