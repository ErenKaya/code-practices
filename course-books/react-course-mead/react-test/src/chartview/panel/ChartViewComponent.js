import React from "react";

class ChartViewComponent extends React.Component {
  constructor() {
    super();
  }
  render() {
    return (
      <div
        key={this.props.key}
        style={{
          ...this.props.style,
          display: "flex",
          flexDirection: "column"
        }}
      >
        <div class={"header"} style={{ display: "flex" }}>
          <span>Header</span>
          <button
            onClick={e => {
              this.props.itemCancelClicked(e, this.props.index);
            }}
          >
            x
          </button>
          <button onClick={this.props.itemFullScreen}>+</button>
        </div>
      </div>
    );
  }
}

export default ChartViewComponent;
