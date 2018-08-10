
import React from 'react';

import { Link, NavLink } from 'react-router-dom';
const Header = () => {
    return (
        <div>
            <h1>Portfolio App</h1>
            <NavLink activeClassName="is-active" to="/">Home</NavLink><br />
            <NavLink to="/portfolio" activeClassName="is-active">Portfolio</NavLink><br />
            <NavLink to="/contact" activeClassName="is-active">Contact</NavLink><br />
        </div>
    )
};

export default Header;