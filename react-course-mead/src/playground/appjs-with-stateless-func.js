class IndecisionApp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            options: []
        };
        this.handleDeleteOptions = this.handleDeleteOptions.bind(this);
        this.handleAddOption = this.handleAddOption.bind(this);
        this.handlePick = this.handlePick.bind(this);
        this.handleDeleteOption = this.handleDeleteOption(this);
    }
    handleDeleteOptions() {
        this.setState(() => {
            return {
                options: []
            };
        });
    }

    handlePick() {
        const randNum = Math.floor(Math.random() * this.state.options.length);
        const option = this.state.options[randNum];
        alert(option);
    }

    handleDeleteOption(option) {
        console.log('hdo', option)
    }

    handleAddOption(e) {
        e.preventDefault();
        const option = e.target.elements.option.value.trim();
        if (option) {
            this.setState((prevState) => {
                return {
                    options: [...prevState.options, option]
                };
            });
        }
    }
    render() {
        const title = 'Indecision App';
        const subTitle = 'Put your life in the hands of computer';
        return (
            <div>
                <Header subtitle={subTitle} />
                <Action
                    hasOptions={this.state.options.length > 0}
                    handlePick={this.handlePick} />
                <Options options={this.state.options}
                    handleDeleteOptions={this.handleDeleteOptions} />
                <AddOption
                    options={this.state.options}
                    handleAddOption={this.handleAddOption}
                />
            </div>
        );
    }
}

IndecisionApp.defaultProps = {
    options: []
};

const Header = (props) => {
    return (
        <div>
            <h1>{props.title}</h1>
            <h2>{props.subtitle}</h2>
        </div>
    )
}

Header.defaultProps = {
    title: 'Indecision'
};

// class Header extends React.Component {
//     render() {
//         return (
//             <div>
//                 <h1>{this.props.title}</h1>
//                 <h2>{this.props.subtitle}</h2>
//             </div>
//         )
//     }
// }

const Action = (props) => {
    return (
        <div>
            <button onClick={props.handlePick}
                disabled={!props.hasOptions}>
                What should I Do</button>
        </div>
    );
};

//   class Action extends React.Component {
//     render() {
//       return (
//         <div>
//           <button onClick={this.props.handlePick} disabled={!this.props.hasOptions}>
//             What should I Do</button>
//         </div>
//       );
//     }
//   }

const Options = (props) => {
    return (
        <div>
            {props.options.map((option) =>
                (<Option
                    key={option}
                    optionText={option}
                    handleDeleteOption={props.handleDeleteOption} />)

            )}
            <button onClick={props.handleDeleteOptions}
                properties={props.options}>Remove All</button>
        </div>
    );
}

// class Options extends React.Component {
//     render() {
//         return (
//             <div>
//                 {this.props.options.map((option) =>
//                     <Option key={option} optionText={option} />
//                 )}
//                 <Option />
//                 <button onClick={this.props.handleDeleteOptions} properties={this.props.options}>Remove All</button>
//             </div>
//         );
//     }
// }

const Option = (props) => {
    return (
        <div>
            {props.optionText}
            <button handleDeleteOption={props.handleDeleteOption}>remove</button>
        </div>
    );
}

// class Option extends React.Component {
//     render() {
//         return (
//             <div>
//                 {this.props.optionText}
//             </div>
//         );
//     }
// }

const AddOption = (props) => {
    return (
        <div>
            <form onSubmit={props.handleAddOption}>
                <input type="text" name="option"></input>
                <button>Add Option</button>
            </form>
        </div>
    );
}

// class AddOption extends React.Component {

//     render() {
//         return (
//             <div>
//                 <form onSubmit={this.props.handleAddOption}>
//                     <input type="text" name="option"></input>
//                     <button>Add Option</button>
//                 </form>
//             </div>
//         );
//     }
// }


ReactDOM.render(<IndecisionApp />, document.getElementById('app'));