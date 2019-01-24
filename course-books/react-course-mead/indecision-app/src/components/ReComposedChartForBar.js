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
    y: 231,
    y10: 261,
    y11: 201,
    y12: 170,
    y20: 250
  },
  {
    x: "Page B",
    y: 555,
    y10: 525,
    y11: 0,
    y12: 500,
    y20: 475
  },
  {
    x: "Page C",
    y: 444,
    y10: 0,
    y11: 414,
    y12: 375,
    y20: 100
  },
  {
    x: "Page D",
    y: 333,
    y10: 383,
    y11: 300,
    y12: 0,
    y20: 150
  },
  {
    x: "Page E",
    y: 222,
    y10: 252,
    y11: 192,
    y12: 170,
    y20: 125
  },
  {
    x: "Page F",
    y: 111,
    y10: 144,
    y11: 80,
    y12: 70,
    y20: 178
  }
];
const dummyIasData = [
  {
    x: 20,
    y: 600,
    y10: 0,
    y11: 0,
    y12: 550,
    y13: 600,
    y14: 0,
    y15: 600,
    y16: 0,
    y20: 0
  },
  {
    x: 23,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y13: 0,
    y14: 0,
    y15: 525,
    y16: 0,
    y20: 0
  },
  {
    x: 25,
    y: 0,
    y10: 0,
    y11: 475,
    y12: 0,
    y13: 0,
    y14: 0,
    y15: 515,
    y16: 450,
    y20: 0
  },
  {
    x: 27,
    y: 0,
    y10: 400,
    y11: 0,
    y12: 0,
    y13: 0,
    y14: 0,
    y15: 425,
    y16: 0,
    y20: 0
  },
  {
    x: 30,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y13: 0,
    y14: 0,
    y15: 0,
    y16: 0,
    y20: 100
  },
  {
    x: 32,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y13: 0,
    y14: 450,
    y15: 400,
    y16: 0,
    y20: 425
  },
  {
    x: 35,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y13: 0,
    y14: 0,
    y15: 0,
    y16: 0,
    y20: 425
  }
];

class ReComposedChartForBar extends React.Component {
  render() {
    return (
      <ComposedChart
        width={600}
        height={400}
        margin={{ top: 90 }}
        data={dummyIasData}
        layout={"horizontal"}
      >
        <XAxis dataKey={"x"} allowDuplicatedCategory={false} />
        <YAxis dataKey={"y"} />
        <ZAxis type="number" range={[200, 1800]} dataKey={"z"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Bar dataKey={"y10"} barSize={13} fill="#f5f5f5f5" />
        <Bar dataKey={"y11"} barSize={12} fill="red" />
        <Bar dataKey={"y12"} barSize={13} fill="gray" />
        <Bar dataKey={"y13"} barSize={12} fill="green" />
        <Bar dataKey={"y14"} barSize={13} fill="black" />
        <Bar
          data={dummyIasData.map(data => {
            return data.y15;
          })}
          dataKey={"y15"}
          barSize={13}
          fill="purple"
        />
        <Bar dataKey={"y16"} barSize={13} fill="pink" />
        <Bar dataKey={"y20"} barSize={13} fill="blue" />
        <Line dataKey={"y20"} fill="blue" />
      </ComposedChart>
    );
  }
}
export default ReComposedChartForBar;
