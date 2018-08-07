import React from 'react';


export default class AddOption extends React.Component {

    render() {
        return (
            <div>
                <form onSubmit={this.props.handleAddOption}>
                    <input type="text" name="option"></input>
                    <button>Add Option</button>
                </form>
            </div>
        );
    }
}
