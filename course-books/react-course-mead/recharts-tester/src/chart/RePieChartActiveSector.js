import React from "react";
import { PieChart, Pie, Legend, Tooltip, Sector } from "recharts";
import PieLabelItem from "./PieLabelItem";

const data = [
  { name: "Group C", value: 300 },
  { name: "Group A", value: 4 },
  { name: "Group A", value: 3 },
  { name: "Group A", value: 1 },
  { name: "Group B", value: 35 },
  { name: "Group B", value: 42 },
  { name: "Group C", value: 300 }
];

const CustomizedPieLabel = props => {
  console.log("*********************");
  const RADIAN = Math.PI / 180;
  const {
    cx,
    cy,
    midAngle,
    innerRadius,
    outerRadius,
    startAngle,
    endAngle,
    fill,
    payload,
    percent,
    value
  } = props;
  let pieLabelItem = PieLabelItem.preparePieLabelPositionObject(
    midAngle,
    outerRadius,
    cx,
    cy,
    30
  );
  let textItemXPosition =
    pieLabelItem.ex + (pieLabelItem.cos >= 0 ? 1 : -1) * 12;
  let textItemYPosition = pieLabelItem.ey;
  const lastRenderedPieTextItemPosition = props.getLastRenderedPieTextItemPosition();
  let uint = number => Math.sqrt(Math.pow(number, 2));
  if (lastRenderedPieTextItemPosition) {
    if (
      uint(
        lastRenderedPieTextItemPosition.textItemYPosition - textItemYPosition
      ) < props.fontSize
    ) {
      console.log(
        "textItemXPos true",
        lastRenderedPieTextItemPosition,
        "&&nowX",
        textItemXPosition,
        "nowY",
        textItemYPosition,
        "pieCellValue",
        value
      );
      console.log("isOverLayActiveCxAndCyValue", ":", "Cx:", cx, "Cy:", cy);
      textItemYPosition += props.fontSize;
      pieLabelItem = PieLabelItem.preparePieLabelPositionObject(
        midAngle,
        outerRadius,
        cx,
        cy,
        30 - props.fontSize
      );
      textItemXPosition =
        pieLabelItem.ex + (pieLabelItem.cos >= 0 ? 1 : -1) * 12;
      textItemYPosition = pieLabelItem.ey;
      console.log(
        "textItemXPos true",
        lastRenderedPieTextItemPosition,
        "&&nowX",
        textItemXPosition,
        "nowY",
        textItemYPosition,
        "pieCellValue",
        value
      );
    }
  }
  props.setLastRenderedPieTextItemPosition(
    textItemXPosition,
    textItemYPosition
  );
  console.log("lastRenderedPieItem", lastRenderedPieTextItemPosition);

  return (
    <g>
      <text
        x={pieLabelItem.cx}
        y={pieLabelItem.cy}
        dy={8}
        textAnchor="middle"
        fill={fill}
      >
        {payload.name}
      </text>
      <Sector
        cx={pieLabelItem.cx}
        cy={pieLabelItem.cy}
        innerRadius={innerRadius}
        outerRadius={outerRadius}
        startAngle={startAngle}
        endAngle={endAngle}
        fill={fill}
      />
      <path
        d={`M${pieLabelItem.sx},${pieLabelItem.sy}L${pieLabelItem.mx},${
          pieLabelItem.my
        }L${pieLabelItem.ex},${pieLabelItem.ey}`}
        stroke={"red"}
        fill="none"
      />
      <circle
        cx={pieLabelItem.ex}
        cy={pieLabelItem.ey}
        r={2}
        fill={fill}
        stroke="none"
      />
      <text
        x={textItemXPosition}
        y={textItemYPosition}
        fontSize={9}
        textAnchor={pieLabelItem.textAnchor}
        fill="#333"
      >{` ${value}`}</text>
    </g>
  );
};

const TwoLevelPieChart = React.createClass({
  getInitialState() {
    return {
      activeIndex: undefined
    };
  },

  onPieEnter(data, index) {
    this.setState({
      activeIndex: index
    });
  },
  setLastRenderedPieTextItemPosition(textItemXPosition, textItemYPosition) {
    this.lastRenderedPieItem = {
      textItemXPosition: textItemXPosition,
      textItemYPosition: textItemYPosition
    };
  },
  getLastRenderedPieTextItemPosition() {
    return this.lastRenderedPieItem;
  },
  render() {
    return (
      <div>
        <PieChart width={800} height={400}>
          <Pie
            activeIndex={this.state.activeIndex}
            // activeShape={CustomizedPieLabel}
            data={data}
            cx={300}
            cy={200}
            outerRadius={80}
            fill="#8884d8"
            onClick={this.onPieEnter}
            labelLine={false}
            label={
              <CustomizedPieLabel
                fontSize={9}
                setLastRenderedPieTextItemPosition={
                  this.setLastRenderedPieTextItemPosition
                }
                getLastRenderedPieTextItemPosition={
                  this.getLastRenderedPieTextItemPosition
                }
              />
            }
          />
        </PieChart>
        <svg width={400} height={400} viewBox={"0 0 800 400"}>
          <path
            d={
              window.testD
                ? window.testD
                : "M221.23183269567244,164.77989696752485L202.61668440582184,150.1544049557157L180.61668440582184,150.1544049557157"
            }
            stroke={"red"}
            fill="none"
            strokeWidth="3px"
          />
        </svg>
      </div>
    );
  }
});
export default class RePieChartActiveSector extends React.Component {
  render() {
    return (
      <div>
        <TwoLevelPieChart />
      </div>
    );
  }
}
