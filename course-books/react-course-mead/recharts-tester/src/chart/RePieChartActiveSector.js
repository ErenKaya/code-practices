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
  { name: "Group C", value: 300 },
  { name: "Group A", value: 4 },
  { name: "Group A", value: 3 },
  { name: "Group A", value: 1 },
  { name: "Group C", value: 150 },
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
  let textItemXPosition = pieLabelItem.ex;
  let textItemYPosition = pieLabelItem.ey;
  const lastRenderedPieTextItemPositionList = props.getRenderedPieTextItemPositionList();
  let logObject = {
    currentTextYPos: textItemYPosition,
    value: value
  };
  let uint = number => Math.sqrt(Math.pow(number, 2));
  if (lastRenderedPieTextItemPositionList) {
    const mostClosestPoint = lastRenderedPieTextItemPositionList.filter(
      position => {
        return (
          uint(position.textItemYPosition - textItemYPosition) < props.fontSize
        );
      }
    );
    if (mostClosestPoint.length > 0) {
      const mostClosestObject = mostClosestPoint[0];
      logObject = {
        ...logObject,
        diffrence: mostClosestObject.textItemYPosition - textItemYPosition,
        lastRenderedTextYPos: mostClosestObject.textItemYPosition,
        mostClosestObject
      };
      if (
        uint(mostClosestObject.textItemYPosition - textItemYPosition) <
        props.fontSize
      ) {
        if (mostClosestObject.textItemYPosition - textItemYPosition > 0) {
          pieLabelItem.ey +=
            props.fontSize +
            uint(mostClosestObject.textItemYPosition - textItemYPosition);
        } else {
          pieLabelItem.ey += props.fontSize;
        }
        if (pieLabelItem.textAnchor !== "start") {
          pieLabelItem.ey += value;
          pieLabelItem.my += value * 2;
        } else {
          console.log("Value for right of svg", value);
          pieLabelItem.ey -= value;
          pieLabelItem.my -= value * 2;
        }
        textItemXPosition =
          pieLabelItem.ex + (pieLabelItem.cos >= 0 ? 1 : -1) * 2;
        textItemYPosition = pieLabelItem.ey;
        logObject["changesAndCurrent"] = textItemYPosition;
      }
      console.table(logObject);
    }
  }
  props.setLastRenderedPieTextItemPosition(
    textItemXPosition,
    textItemYPosition,
    pieLabelItem.textAnchor
  );
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
    this.renderedPieTextItemList = [];
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
    this.renderedPieTextItemList.push({
      textItemXPosition: textItemXPosition,
      textItemYPosition: textItemYPosition
    });
  },
  getRenderedPieTextItemPositionList() {
    return this.renderedPieTextItemList;
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
                getRenderedPieTextItemPositionList={
                  this.getRenderedPieTextItemPositionList
                }
              />
            }
          />
        </PieChart>
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
