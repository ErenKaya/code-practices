import React from "react";
import { Responsive, WidthProvider } from "react-grid-layout";

const ResponsiveReactGridLayout = WidthProvider(Responsive);

class ChartViewComponentList extends React.Component {
  constructor() {
    super();
  }

  render() {
    const layout = [
      { i: "a", x: 0, y: 4, w: 1, h: 1, static: Math.random() < 0.05 },
      { i: "b", x: 1, y: 3, w: 2, h: 2, static: Math.random() < 0.05 },
      { i: "c", x: 4, y: 20, w: 1, h: 3, static: Math.random() < 0.05 }
    ];
    const divStyle = {
      border: "solid 1px red",
      display: "flex",
      flexDirection: "column",
      width: "100%"
    };
    return (
      <div className={"cv-component-list"}>
        <ResponsiveReactGridLayout
          layout={layout}
          col={{ lg: 12, md: 10, sm: 6, xs: 4, xxs: 2 }}
          rowHeight={30}
        >
          {layout.map((element, index) => {
            return <div key={element.i} style={divStyle} />;
          })}
        </ResponsiveReactGridLayout>
      </div>
    );
  }
}

export default ChartViewComponentList;
