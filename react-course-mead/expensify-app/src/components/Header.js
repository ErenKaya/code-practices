
import React from 'react';

import { Link, NavLink } from 'react-router-dom';
const Header = () => {
    return (
        <div>
            <h1>Expensify</h1>
            <NavLink activeClassName="is-active" to="/">Home</NavLink><br />
            <NavLink to="/create" activeClassName="is-active">Create</NavLink><br />
            <NavLink to="/edit" activeClassName="is-active">Edit</NavLink><br />
            <NavLink to="/help" activeClassName="is-active">Help</NavLink><br />
        </div>
    )
};

export default Header;