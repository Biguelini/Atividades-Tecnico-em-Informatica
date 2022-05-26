/* eslint-disable import/no-anonymous-default-export */
import './Logo.css'
import React from 'react'
import { Link } from 'react-router-dom'

export default (props) => (
    <aside className="logo">
        <Link to="/" className="logo">
            <h1>BigChat</h1>
        </Link>
    </aside>
)
