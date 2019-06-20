import React from "react";
import Input from "antd/lib/input";

export default class InputComponent extends React.Component {
  constructor() {
    super();
    this.state = {
      antdInputValue: "",
      normalInputValue: ""
    };
  }

  onChange = (targetName, targetValue) => {
    this.setState(() => {
      return {
        [targetName]: targetValue
      };
    });
  };

  componentDidUpdate = () => {
    alert("state" + JSON.stringify(this.state, null, 4));
  };

  render() {
    return (
      <div>
        <div
          style={{
            margin: "20px 20px",
            width: "70%",
            display: "flex",
            flexDirection: "column"
          }}
        >
          <span>Test ui component input from state</span>
          <Input
            style={{ border: "solid 1px red" }}
            name={"antdInputValue"}
            onChange={e => {
              this.onChange(e.target.name, e.target.value);
            }}
          />
        </div>

        <div
          style={{
            margin: "20px 20px",
            width: "70%",
            display: "flex",
            flexDirection: "column"
          }}
        >
          <span>Test normal input from state</span>
          <input
            style={{ border: "solid 1px green" }}
            name={"normalInputValue"}
            onChange={e => {
              this.onChange(e.target.name, e.target.value);
            }}
          />
        </div>
      </div>
    );
  }
}
