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
  ZAxis,
  Area
} from "recharts";
import Scatter from "recharts/lib/cartesian/Scatter";

const data = [
  {
    x: 30,
    y10: 0,
    y11: 0,
    y12: 0,
    y20: 0,
    lineSet20: 70,
    bubbleSet30: 30
  },
  {
    x: 50,
    y10: 261,
    y11: 201,
    y12: 170,
    y20: 250,
    bubbleSet30: 40
  },
  {
    x: 40,
    y10: 0,
    y11: 414,
    y12: 375,
    y20: 100,
    bubbleSet30: 50
  },
  {
    x: 55,
    y10: 383,
    y11: 300,
    y12: 0,
    y20: 150,
    bubbleSet30: 60
  },
  {
    x: 80,
    y10: 252,
    y11: 0,
    y12: 170,
    y20: 125,
    bubbleSet30: 70
  },
  {
    x: 75,
    y10: 144,
    y11: 80,
    y12: 70,
    y20: 178,
    bubbleSet30: 20
  },
  {
    x: 92,
    y10: 0,
    y11: 0,
    y12: 0,
    y20: 0,
    lineSet20: 78,
    bubbleSet30: 10
  },
  {
    x: 102,
    y10: 0,
    y11: 0,
    y12: 0,
    y20: 0,
    lineSet20: 55,
    bubbleSet30: 55
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

const bubbleData2 = [
  {
    x: 40
  },
  {
    x: 80
  },
  {
    x: 75
  },
  {
    x: 55
  },
  {
    x: 50
  },
  {
    x: 92,
    y: 44,
    bubbleSet30: 55
  },
  {
    x: 102,
    y: 23,
    bubbleSet30: 32
  },
  {
    x: 30,
    y: 55,
    bubbleSet30: 300
  }
];

const bubbleData3 = [
  {
    x: 40,
    y: 12,
    bubbleSet30: 200
  },
  {
    x: 80
  },
  {
    x: 75,
    y: 85,
    bubbleSet30: 90
  },
  {
    x: 55
  },
  {
    x: 50,
    y: 120,
    bubbleSet30: 150
  },
  {
    x: 92
  },
  {
    x: 102
  },
  {
    x: 30
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
    const sortedLineData2 = bubbleData2.sort((a, b) => {
      return a.x - b.x;
    });
    console.log(sortedComposedData);
    console.log(A.default.sum2(4,5));
    console.log(A.default.A);
    console.log(A.default.sum3);
    return (
      <ComposedChart
        width={600}
        height={400}
        margin={{ top: 90 }}
        data={sortedComposedData}
        layout={"horizontal"}
      >
        <XAxis dataKey={"x"} allowDuplicatedCategory={false} />
        <YAxis dataKey={"y"} domain={[0, 500]} />
        <ZAxis type="number" range={[200, 800]} dataKey={"bubbleSet30"} />
        <Tooltip />
        <Legend />
        <CartesianGrid stroke="#f5f5f5" />
        <Area dataKey={"lineSet20"} fill="blue" connectNulls={true} />
        <Bar dataKey={"y10"} barSize={13} fill="#f5f5f5f5" />
        <Bar dataKey={"y11"} barSize={12} fill="red" />
        <Bar dataKey={"y12"} barSize={13} fill="gray" />
        <Bar dataKey={"y13"} barSize={12} fill="green" />
        <Bar dataKey={"y14"} barSize={13} fill="black" />
        <Bar dataKey={"y16"} barSize={13} fill="pink" />
        <Bar dataKey={"y20"} barSize={13} fill="blue" />
        <Scatter data={bubbleData2} dataKey={"bubbleSet30"} fill="yellow" />
        <Scatter data={bubbleData3} dataKey={"bubbleSet30"} fill="red" />
      </ComposedChart>
    );
  }
}
export default ReComposedChartSpecItemTest;
