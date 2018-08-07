import AddOption from './AddOption';
import Header from './Header';
import Action from './Action';
import Options from './Options'
import React from 'react';

export default class IndecisionApp extends React.Component {
    state = {
        options: []
    };
    handlePick = () => {
        const randNum = Math.floor(Math.random() * this.state.options.length);
        const option = this.state.options[randNum];
        alert(option);
    };

    handleDeleteOption = (optionToRemove) => {
        this.setState((prevState) => ({
            options: prevState.options.filter((option) => optionToRemove !== option)
        }));
    };

    handleAddOption = (e) => {
        e.preventDefault();
        const option = e.target.elements.option.value.trim();
        if (option) {
            this.setState((prevState) => ({ options: [...prevState.options, option] }))
        }
    };

    handleDeleteOptions = () => {
        this.setState(() => ({ options: [] }));
    };

    componentDidMount() {
        try {
            const json = localStorage.getItem('options');
            const options = JSON.parse(json);
            this.setState(() => ({ options }));
        } catch (e) {
            console.log('Bir Hata oluştu.');
        }

    }

    componentWillMount() {
        /**
         * First executed!
         */
        console.log('componentWillMount');
    }

    componentDidUpdate(prevProps, prevState) {
        /**
         * Component getting an object and updated
         */
        if (prevState.options.length !== this.state.options.length) {
            const json = JSON.stringify(this.state.options);
            localStorage.setItem("options", json);
        }
        console.log('saving data');
    }

    componentWillReceiveProps() {
        /**
         * i couldn't try.
         */
        console.log('componentWillReceiveProps')
    }

    componentWillUnmount() {
        /**
         * you should type console of browser.
         * ReactDOM.render(React.createElement('p'),document.getElementById('app')); 
         */

        console.log('componentwillunmount');
    }

    render() {
        const title = 'Indecision App';
        const subTitle = 'Put your life in the hands of computer';
        return (
            <div>
                <Header title={title} subtitle={subTitle} />
                <Action
                    hasOptions={this.state.options.length > 0}
                    handlePick={this.handlePick} />
                <Options options={this.state.options}
                    handleDeleteOptions={this.handleDeleteOptions}
                    handleDeleteOption={this.handleDeleteOption} />
                <AddOption

                    handleAddOption={this.handleAddOption}
                />
            </div>
        );
    }
}