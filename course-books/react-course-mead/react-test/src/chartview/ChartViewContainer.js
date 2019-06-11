import React from "react";
import ChartViewConfigPanel from "./config-panel/ChartViewConfigPanel";
import ChartViewPanel from "./panel/ChartViewPanel";
import SplitPane from "react-split-pane";
const TABLE_WIDTH = 500;

const Wrapper = props => {
  return (
    <div
      style={{
        flex: 1,
        display: "flex",
        height: "100%",
        width: "100%",
        height: "70%",
        width: "70%",
        border: "1px solid red"
      }}
    />
  );
};

class ChartViewContainer extends React.Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        <SplitPane
          split="vertical"
          defaultSize="50%"
          minSize={50}
          maxSize={window.innerWidth - 50}
        >
          <ChartViewConfigPanel />
          <div>
            <ChartViewPanel />
          </div>
        </SplitPane>
      </div>
    );
  }
}

export default ChartViewContainer;
