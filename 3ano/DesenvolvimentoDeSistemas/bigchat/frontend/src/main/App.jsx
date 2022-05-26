/* eslint-disable import/no-anonymous-default-export */
import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.min.css'
import './App.css'
import { BrowserRouter } from 'react-router-dom'
import Routes from './Routes'
import Logo from '../components/template/Logo'
import Nav from '../components/template/Nav'

export default (props) => (
    <BrowserRouter>
        <div className="app">
            <Logo />
            <Nav />
            <Routes />
        </div>
    </BrowserRouter>
)
