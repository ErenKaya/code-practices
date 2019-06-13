import React from "react";
import ChartViewConfigHeader from "./ChartViewConfigHeader";
import ChartViewConfigItemContainer from "./ChartViewConfigItemContainer";
import ChartViewConfigToolbar from "./ChartViewConfigToolbar";

class ChartViewConfigPanel extends React.Component {
  constructor() {
    super();
  }
  render() {
    return (
      <div className={"cv-config-panel"}>
        <ChartViewConfigHeader />
        <ChartViewConfigItemContainer />
        <ChartViewConfigToolbar />
      </div>
    );
  }
}

export default ChartViewConfigPanel;
