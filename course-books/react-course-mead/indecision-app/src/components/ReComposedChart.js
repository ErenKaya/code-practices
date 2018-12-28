import {
  ComposedChart,
  Area,
  Line,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  Scatter,
  ZAxis
} from "recharts";
const data = [
  {
    name: "Page A",
    uv: 590,
    pv: 800,
    amt: 1400,
    prd: { x: 23, y: 44, z: 70 }
  },
  {
    name: "Page B",
    uv: 868,
    pv: 967,
    amt: 1506,
    prd: { x: 32, y: 41, z: 111 }
  },
  {
    name: "Page C",
    uv: 1397,
    pv: 1098,
    amt: 989,
    prd: { x: 55, y: 113, z: 90 }
  },
  {
    name: "Page D",
    uv: 1480,
    pv: 1200,
    amt: 1228,
    prd: { x: 12, y: 78, z: 200 }
  },
  {
    name: "Page E",
    uv: 1520,
    pv: 1108,
    amt: 1100,
    prd: { x: 27, y: 45, z: 140 }
  },
  {
    name: "Page F",
    uv: 1400,
    pv: 680,
    amt: 1700,
    prd: { x: 49, y: 75, z: 100 }
  }
];

import React from "react";
import ScatterChart from "recharts/lib/chart/ScatterChart";

class ReComposedChart extends React.Component {
  render() {
    const scatterDat = data.map(entry => {
      console.log(entry.prd);
      return entry.prd;
    });
    return (
      <ComposedChart
        width={600}
        height={400}
        margin={{ top: 20, right: 80, bottom: 20, left: 20 }}
        data={data}
      >
        <XAxis
          xAxisId="1"
          dataKey="name"
          label={{ value: "Pages", position: "insideBottomRight", offset: 0 }}
        />
        <YAxis
          yAxisId="1"
          label={{ value: "Index", angle: -90, position: "insideLeft" }}
        />
        <XAxis xAxisId="0" type="number" dataKey={"x"} />
        <YAxis yAxisId="0" type="number" dataKey={"y"} />
        <ZAxis zAxisId="0" type="number" range={[40, 160]} dataKey={"z"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Area
          xAxisId="1"
          yAxisId="1"
          type="monotone"
          dataKey="amt"
          fill="#8884d8"
          stroke="#8884d8"
        />
        <Bar xAxisId="1" yAxisId="1" dataKey="pv" barSize={20} fill="#413ea0" />
        <Line
          xAxisId="1"
          yAxisId="1"
          type="monotone"
          dataKey="uv"
          stroke="#ff7300"
        />
        <Scatter
          xAxisId="0"
          yAxisId="0"
          zAxisId="0"
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
