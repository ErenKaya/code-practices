import React from 'react';

export default class Action extends React.Component {
    render() {
        return (
            <div>
                <button onClick={this.props.handlePick} disabled={!this.props.hasOptions}>
                    What should I Do</button>
            </div>
        );
    }
}