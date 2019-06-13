import React from "react";

class ChartViewComponent extends React.Component {
  constructor() {
    super();
  }
  render() {
    return (
      <div
        key={this.props.key}
        style={this.props.style}
        x={this.props.x}
        y={this.props.y}
        h={this.props.h}
        w={this.props.w}
        static={this.props.static}
      />
    );
  }
}

export default ChartViewComponent;
