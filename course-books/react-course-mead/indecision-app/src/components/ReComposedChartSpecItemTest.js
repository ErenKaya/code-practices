import React from "react";
import {
  Bar,
  CartesianGrid,
  ComposedChart,
  Legend,
  Line,
  Tooltip,
  XAxis,
  YAxis,
  ZAxis
} from "recharts";
const data = [
  {
    x: 50,
    y: 231,
    y10: 261,
    y11: 201,
    y12: 170,
    y20: 250
  },
  {
    x: 40,
    y: 444,
    y10: 0,
    y11: 414,
    y12: 375,
    y20: 100
  },
  {
    x: 55,
    y: 333,
    y10: 383,
    y11: 300,
    y12: 0,
    y20: 150
  },
  {
    x: 80,
    y: 222,
    y10: 252,
    y11: 0,
    y12: 170,
    y20: 125
  },
  {
    x: 75,
    y: 111,
    y10: 144,
    y11: 80,
    y12: 70,
    y20: 178
  },
  {
    x: 92,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y20: 0
  },
  {
    x: 102,
    y: 0,
    y10: 0,
    y11: 0,
    y12: 0,
    y20: 0
  }
];

const lineData = [
  {
    x: 50,
    lineSet10: 98
  },
  {
    x: 40,
    lineSet10: 70
  },
  {
    x: 80,
    lineSet10: 66
  },
  {
    x: 40,
    lineSet10: 90
  },
  {
    x: 55,
    lineSet10: 125
  },
  {
    x: 75,
    lineSet10: 60
  }
];

const lineData2 = [
  {
    x: 80,
    lineSet20: 25
  },

  {
    x: 92,
    lineSet20: 78
  },
  {
    x: 102,
    lineSet20: 78
  }
];

class ReComposedChartSpecItemTest extends React.Component {
  render() {
    const sortedComposedData = data.sort((a, b) => {
      return a.x - b.x;
    });
    const sortedLineData = lineData.sort((a, b) => {
      return a.x - b.x;
    });
    const sortedLineData2 = lineData2.sort((a, b) => {
      return a.x - b.x;
    });
    return (
      <ComposedChart
        width={600}
        height={400}
        margin={{ top: 90 }}
        data={sortedComposedData}
        layout={"horizontal"}
      >
        <XAxis dataKey={"x"} allowDuplicatedCategory={false} />
        <YAxis dataKey={"y"} domain={[0, 600]} />
        <ZAxis type="number" range={[200, 1800]} dataKey={"z"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Bar dataKey={"y10"} barSize={13} fill="#f5f5f5f5" />
        <Bar dataKey={"y11"} barSize={12} fill="red" />
        <Bar dataKey={"y12"} barSize={13} fill="gray" />
        <Bar dataKey={"y13"} barSize={12} fill="green" />
        <Bar dataKey={"y14"} barSize={13} fill="black" />
        <Bar dataKey={"y16"} barSize={13} fill="pink" />
        <Bar dataKey={"y20"} barSize={13} fill="blue" />
        <Line dataKey={"lineSet10"} data={sortedLineData} fill="red" />
        <Line dataKey={"lineSet20"} data={sortedLineData2} fill="blue" />
      </ComposedChart>
    );
  }
}
export default ReComposedChartSpecItemTest;
