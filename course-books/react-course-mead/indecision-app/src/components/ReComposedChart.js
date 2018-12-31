import React from "react";
import {
  Area,
  Bar,
  CartesianGrid,
  ComposedChart,
  Legend,
  Line,
  Scatter,
  Tooltip,
  XAxis,
  YAxis,
  ZAxis
} from "recharts";
const data = [
  {
    x: "Page A",
    uv: 590,
    pv: 800,
    amt: 1400,
    prd: { x: 1480, y: 590, z: 70 }
  },
  {
    x: "Page B",
    uv: 868,
    pv: 967,
    amt: 1506,
    prd: { x: 800, y: 868, z: 111 }
  },
  {
    x: "Page C",
    uv: 1397,
    pv: 1098,
    amt: 989,
    prd: { x: 1098, y: 989, z: 1397 }
  },
  {
    x: "Page D",
    uv: 1480,
    pv: 1200,
    amt: 1228,
    prd: { x: 1228, y: 1200, z: 1480 }
  },
  {
    x: "Page E",
    uv: 1520,
    pv: 1108,
    amt: 1100,
    prd: { x: 1520, y: 1108, z: 1100 }
  },
  {
    x: "Page F",
    uv: 1400,
    pv: 680,
    amt: 1700,
    prd: { x: 680, y: 1400, z: 1700 }
  }
];

class ReComposedChart extends React.Component {
  render() {
    const scatterDat = data.map(entry => {
      return entry.prd;
    });
    return (
      <ComposedChart width={600} height={400} margin={{ top: 90 }} data={data}>
        <XAxis dataKey={"x"} />
        <YAxis dataKey={"y"} />
        <ZAxis type="number" range={[200, 1800]} dataKey={"z"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Area
          type="monotone"
          dataKey="amt"
          fill="#8884d8"
          stroke="#8884d8"
          isAnimationActive={false}
        />
        <Bar dataKey="pv" barSize={20} fill="#413ea0" />
        <Line type="monotone" dataKey="uv" stroke="#ff7300" />
        <Scatter
          isAnimationActive={false}
          key="start1"
          data={scatterDat}
          name="start"
          shape="star"
          stroke="#dddd"
        />
      </ComposedChart>
    );
  }
}
export default ReComposedChart;
