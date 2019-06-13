import React from "react";
import ChartViewComponentList from "./ChartViewComponentList";
import ChartViewTopToolbar from "./ChartViewTopToolbar";
class ChartViewPanel extends React.Component {
  constructor() {
    super();
  }
  render() {
    return (
      <div className={"cv-panel"}>
        <ChartViewTopToolbar  />
        <ChartViewComponentList />
      </div>
    );
  }
}

export default ChartViewPanel;
