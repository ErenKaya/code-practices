class IndecisionApp extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        options: []
      };
      this.handleDeleteOptions = this.handleDeleteOptions.bind(this);
      this.handleAddOption = this.handleAddOption.bind(this);
      this.handlePick = this.handlePick.bind(this);
      this.handleDeleteOption = this.handleDeleteOption.bind(this);
    }
    handleDeleteOptions() {
      this.setState(() => ({ options: [] }));
    }
  
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
  
    handlePick() {
      const randNum = Math.floor(Math.random() * this.state.options.length);
      const option = this.state.options[randNum];
      alert(option);
    }
  
    handleDeleteOption(optionToRemove) {
      this.setState((prevState) => ({
        options: prevState.options.filter((option) => optionToRemove !== option)
      }));
    }
  
    handleAddOption(e) {
      e.preventDefault();
      const option = e.target.elements.option.value.trim();
      if (option) {
        this.setState((prevState) => ({ options: [...prevState.options, option] }))
      }
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
  
  class Header extends React.Component {
    render() {
      return (
        <div>
          <h1>{this.props.title}</h1>
          <h2>{this.props.subtitle}</h2>
        </div>
      )
    }
  }
  
  class Action extends React.Component {
    render() {
      return (
        <div>
          <button onClick={this.props.handlePick} disabled={!this.props.hasOptions}>
            What should I Do</button>
        </div>
      );
    }
  }
  
  class Options extends React.Component {
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
  
  class Option extends React.Component {
    render() {
      return (
        <div>
          {this.props.optionText}
          <button
            onClick={(e) => {
              this.props.handleDeleteOption(this.props.optionText);
            }}>
            remove
          </button>
        </div>
      );
    }
  }
  
  class AddOption extends React.Component {
  
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
  
  
  
  ReactDOM.render(<IndecisionApp />, document.getElementById('app'));