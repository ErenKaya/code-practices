// A component (HOC) that renders  another component.
/**
 * it's a pattern
 */

import React from 'react';
import ReactDOM from 'react-dom';


const Info = (props) => {
    return (<div>
        <h1>Info</h1>
        <p>The info is: {props.info}</p>
    </div>)
};

const withAdminWarning = (WrappedComponent) => {
    // <Info info='Details from admin comp' />
    return (props) => (
        <div>
            {props.isAdmin && <p>This is the private info</p>}
            <WrappedComponent {...props} /></div>
    );
};

const requireAuthentication = (WrappedComponent) => {
    return (props) => (
        <div>
            {!props.isAuthenticated && <p>Please Log in</p>}
            {props.isAuthenticated && <WrappedComponent {...props} />}</div>
    );
}


const AdminInfo = withAdminWarning(Info);

const AuthInfo = requireAuthentication(Info);

ReactDOM.render(<AuthInfo isAuthenticated={false} info='The are the details' />, document.getElementById('app'));


//requireAuthentication

