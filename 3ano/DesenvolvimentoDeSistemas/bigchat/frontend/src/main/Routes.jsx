/* eslint-disable import/no-anonymous-default-export */
import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Admin from '../components/admin/Admin'
import Login from '../components/login/Login'
import User from '../components/user/User'

export default (props) => {
    return (
        <Routes>
            <Route exact path="/login" element={<Login />} />
            <Route exact path="/admin" element={<Admin />} />
            <Route exact path="/user" element={<User />} />
            <Route path="*" element={<Login />} />
        </Routes>
    )
}
