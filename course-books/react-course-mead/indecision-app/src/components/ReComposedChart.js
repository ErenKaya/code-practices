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
    g: 590,
    pv: 800,
    amt: 1122,
    z: 70,
    bar: { name: "Page A", value: 231 },
    prd: { x: 1480, y: 590, z: 70 }
  },
  {
    x: "Page B",
    g: 868,
    pv: 967,
    amt: 1111,
    z: 111,
    bar: { name: "Page B", value: 555 },
    prd: { x: 800, y: 868, z: 111 }
  },
  {
    x: "Page C",
    g: 1397,
    pv: 1098,
    amt: 989,
    z: 1397,
    bar: { name: "Page C", value: 444 },
    prd: { x: 1098, y: 989, z: 1397 }
  },
  {
    x: "Page D",
    g: 1480,
    pv: 1200,
    amt: 1228,
    z: 1211,
    bar: { name: "Page D", value: 333 },
    prd: { x: 1228, y: 1200, z: 1480 }
  },
  {
    x: "Page E",
    g: 1520,
    pv: 1108,
    amt: 1100,
    z: 1100,
    bar: { name: "Page E", value: 222 },
    prd: { x: 1520, y: 1108, z: 1100 }
  },
  {
    x: "Page F",
    g: 1250,
    pv: 680,
    amt: 1233,
    z: 1323,
    bar: { name: "Page F", value: 111 },
    prd: { x: 680, y: 1400, z: 1700 }
  },
  {
    x: "Page F",
    g: 1400,
    pv: 680,
    amt: 1313,
    z: 1700,
    bar: { name: "Page F", value: 111 },
    prd: { x: 680, y: 1400, z: 1700 }
  }
];

class ReComposedChart extends React.Component {
  render() {
    const scatterDat = data.map(entry => {
      return entry.prd;
    });
    const barData = data.map(entry => {
      return entry.bar;
    });
    console.log(barData);
    const dataX = [
      ...new Set(
        data.map(entry => {
          return entry.x;
        })
      )
    ];
    const dataY = [
      ...new Set(
        data.map(entry => {
          return entry.g;
        })
      )
    ];
    console.log("Recomposed>>render");
    console.log(dataX + " " + dataY);
    return (
      <ComposedChart
        width={600}
        height={400}
        margin={{ top: 90 }}
        data={dataX.map((entry, index) => {
          return { name: entry, value: dataY[index] };
        })}
      >
        <XAxis dataKey={"x"} allowDuplicatedCategory={false} />
        <YAxis dataKey={"y"} />
        <ZAxis type="number" range={[200, 1800]} dataKey={"z"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Area
          type="monotone"
          data={data.map(entry => {
            return { name: "amt", value: entry.amt };
          })}
          dataKey="value"
          fill="#8884d8"
          stroke="#8884d8"
          isAnimationActive={false}
        />
        <Bar data={barData} dataKey={"value"} barSize={20} fill="#c0000" />
        <Line
          data={data.map(entry => {
            return { name: "g", value: entry.y };
          })}
          dataKey={"value"}
          type="monotone"
          stroke="#ff7300"
        />
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
