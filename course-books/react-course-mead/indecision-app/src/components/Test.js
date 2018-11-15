import React from "react";
import DisplayTheSecret from "./DisplayTheSecret";

export default class Test extends React.Component {
  render() {
    console.log("un wrapped");
    return <DisplayTheSecret />;
  }
}
