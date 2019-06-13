import React from "react";
import ChartViewConfigPanel from "./config-panel/ChartViewConfigPanel";
import ChartViewPanel from "./panel/ChartViewPanel";
import SplitPane from "react-split-pane";
class ChartViewContainer extends React.Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        <SplitPane
          split="vertical"
          defaultSize="15%"
          minSize={50}
          maxSize={window.innerWidth - 10}
        >
          <ChartViewConfigPanel />
          <ChartViewPanel />
        </SplitPane>
      </div>
    );
  }
}

export default ChartViewContainer;
