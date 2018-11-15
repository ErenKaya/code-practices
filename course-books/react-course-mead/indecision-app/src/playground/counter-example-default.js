import React from "react";
import ClipLoader from "react-spinners/ClipLoader";
import { css } from "react-emotion";
import NProgress from "nprogress";
const override = css`
  display: block;
  margin: 0 auto;
  border-color: red;
`;
export default class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.handleAddOne = this.handleAddOne.bind(this);
    this.handleMinusOne = this.handleMinusOne.bind(this);
    this.handleReset = this.handleReset.bind(this);
    this.pleaseWaitClose = this.pleaseWaitClose.bind(this);
    this.pleaseWaitClose2 = this.pleaseWaitClose2.bind(this);
    this.state = {
      count: props.count,
      pleaseWait: false
    };
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("component did update");
    localStorage.setItem("count", this.state.count);
  }

  componentDidMount() {
    const count = localStorage.getItem("count");
    this.setState(() => ({ count }));
  }

  handleMinusOne() {
    this.setState(prevState => {
      return {
        count: prevState.count - 1,
        pleaseWait: true,
        clicked: true
      };
    }, this.pleaseWaitClose);
  }

  pleaseWaitClose() {
    console.log("pleasewait close executed");
    setTimeout(() => {
      this.setState(
        {
          clicked: false
        },
        this.pleaseWaitClose2
      );
    }, 2000);
  }
  pleaseWaitClose2() {
    this.setState(() => {
      return {
        pleaseWait: false
      };
    });
  }

  handleAddOne() {
    this.setState(prevState => {
      return {
        count: prevState.count + 1,
        pleaseWait: true,
        clicked: true
      };
    }, this.pleaseWaitClose);
  }

  handleReset() {
    // this.setState((prevState) => {
    //     return {
    //         count: 0
    //     };
    // });
    setTimeout(() => {
      NProgress.start();
      console.log("timeout running");
    }, 2000);
    console.log("timout done");
    NProgress.done();
    this.setState({
      count: 0
    });
  }
  render() {
    return (
      <div>
        <h1>Count: {this.state.count}</h1>
        <button onClick={this.handleAddOne}>+1</button>
        <button onClick={this.handleMinusOne}>-1</button>
        <button onClick={this.handleReset}>reset</button>
        <div className="sweet-loading">
          <ClipLoader
            className={override}
            sizeUnit={"px"}
            size={150}
            color={"#123abc"}
            loading={this.state.pleaseWait}
          />
        </div>
      </div>
    );
  }
}

Counter.defaultProps = {
  count: 0
};
