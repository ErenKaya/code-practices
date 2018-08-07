import React from 'react';
import Option from './Option';

export default class Options extends React.Component {
    
    render() {
        return (
            <div>
                {this.props.options.map((option) => (
                    <Option
                        key={option}
                        optionText={option}
                        handleDeleteOption={this.props.handleDeleteOption} />
                )
                )}
                <button onClick={this.props.handleDeleteOptions} properties={this.props.options}>Remove All</button>
            </div>
        );
    }
}
