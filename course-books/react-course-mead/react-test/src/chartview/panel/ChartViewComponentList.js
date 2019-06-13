import React from "react";
import { WidthProvider, Responsive } from "react-grid-layout";

const ResponsiveReactGridLayout = WidthProvider(Responsive);

class ChartViewComponentList extends React.Component {
  constructor() {
    super();
  }

  render() {
    const layout = [
      { i: "a", x: 0, y: 0, w: 1, h: 2 },
      { i: "b", x: 1, y: 0, w: 3, h: 2 },
      { i: "c", x: 4, y: 0, w: 1, h: 2 }
    ];
    const divStyle = {
      border: "solid 1px red",
      display: "flex",
      flexDirection: "column",
      width: "100%"
    };
    return (
      <div className={"cv-component-list"}>
        {" "}
        <ResponsiveReactGridLayout
          className="layout"
          layout={layout}
          col={12}
          rowHeight={30}
          width={1200}
        >
          <div style={divStyle} key="a">
            a
          </div>
          <div style={divStyle} key="b">
            b
          </div>
          <div style={divStyle} key="c">
            <div className={"header"}>Header</div>
            <div style={{ height: "100%" }} className={"body"}>
              body
            </div>
          </div>
        </ResponsiveReactGridLayout>
      </div>
    );
  }
}

export default ChartViewComponentList;
