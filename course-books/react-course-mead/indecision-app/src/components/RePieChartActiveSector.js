import React from "react";
import { PieChart, Pie, Legend, Tooltip, Sector } from "recharts";

const data = [
  { name: "Group A", value: 400 },
  { name: "Group B", value: 300 },
  { name: "Group C", value: 300 },
  { name: "Group D", value: 200 }
];

const renderActiveShape = props => {
  const RADIAN = Math.PI / 180;
  const {
    cx,
    cy,
    midAngle,
    innerRadius,
    outerRadius,
    startAngle,
    endAngle,
    payload,
    percent,
    fill,
    value
  } = props;
  const sin = Math.sin(-RADIAN * midAngle);
  const cos = Math.cos(-RADIAN * midAngle);
  const sx = cx + (outerRadius / 7 + 10) * cos;
  const sy = cy + (outerRadius / 7 + 10) * sin;
  const mx = cx + (outerRadius / 7) * cos;
  const my = cy + (outerRadius / 7) * sin;
  const ex = mx + (cos >= 0 ? 1 : -1) * 22;
  const ey = my;
  const textAnchor = cos >= 0 ? "start" : "end";
  return (
    <g>
      <Sector
        cx={mx}
        cy={my}
        outerRadius={outerRadius}
        startAngle={startAngle}
        endAngle={endAngle}
        fill={fill}
      />
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
  render() {
    return (
      <PieChart width={800} height={400}>
        <Pie
          activeIndex={this.state.activeIndex}
          activeShape={renderActiveShape}
          data={data}
          cx={300}
          cy={200}
          outerRadius={80}
          fill="#8884d8"
          onClick={this.onPieEnter}
        />
      </PieChart>
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
