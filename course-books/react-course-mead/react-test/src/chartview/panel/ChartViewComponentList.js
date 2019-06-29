import React from "react";
import ChartViewComponent from "./ChartViewComponent";
import { Responsive, WidthProvider } from "react-grid-layout";

const ResponsiveReactGridLayout = WidthProvider(Responsive);

class ChartViewComponentList extends React.Component {
  constructor() {
    super();
    this.state = {
      layouts: []
    };
    this.clickCount = 0;
    this.timeoutFunction = null;
  }

  generateLayout = () => {
    let array = [];
    for (let j = 0; j < 5; j++) {
      let y = Math.ceil(Math.random() * 4) + 1;
      array.push({
        x: (Math.random(0, 5) * 2) % 15,
        y: Math.floor(j / 6) * y,
        w: 2,
        h: y,
        i: j.toString(),
        static: Math.random() < 0.05
      });
    }
    this.setState(() => {
      return {
        layouts: array
      };
    });
  };

  itemCancelClicked = (e, s) => {
    console.log(e);
    console.log("s", s);
  };

  itemFullScreen = () => {};

  doubleclick = (e, onsingle, ondouble, timeout) => {
    console.log("e", e);
    this.clickCount++;
    if (this.clickCount === 1) {
      timeoutFunction = setTimeout(() => {
        this.clickCount = 0;
        onsingle(e);
      }, timeout || 300);
    } else if (this.clickCount === 2) {
      clearTimeout(timeoutFunction);
      this.clickCount = 0;
      ondouble(e);
    }
  };

  doubleClickAction = () => {
    console.log("dc");
  };

  render() {
    const divStyle = {
      border: "solid 1px red",
      display: "flex",
      flexDirection: "column",
      width: "500px",
      height: "300px"
    };
    console.log("layout", this.state.layouts);
    return (
      <div className={"cv-component-list"}>
        <label
          onClick={e => {
            this.doubleclick(e, this.generateLayout, this.doubleClickAction);
          }}
        >
          Generate
        </label>
        <input className={"transform"} type={"text"} />
        <ResponsiveReactGridLayout
          className={"layout"}
          layout={this.state.layouts}
          col={{ lg: 24, md: 20, sm: 12, xs: 8, xxs: 4 }}
          measureBeforeMount={false}
          rowHeight={30}
        >
          {this.state.layouts.map((element, index) => {
            return (
              <div key={element.i} style={divStyle}>
                <ChartViewComponent
                  index={element.i}
                  itemFullScreen={this.itemFullScreen}
                  itemCancelClicked={this.itemCancelClicked}
                />
              </div>
            );
          })}
        </ResponsiveReactGridLayout>
      </div>
    );
  }
}

export default ChartViewComponentList;
