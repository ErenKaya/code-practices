import React from "react";
import {
  Bar,
  BarChart,
  CartesianGrid,
  Cell,
  Legend,
  Tooltip,
  XAxis,
  YAxis
} from "recharts";
import ComposedChart from "recharts/lib/chart/ComposedChart";

// const data = [
//   {
//     name: "Page A",
//     uv: 4000,
//     pv: 2400,
//     amt: 2400,
//     trv: 1398,
//     color: ""
//   },
//   {
//     name: "Page B",
//     uv: 3000,
//     pv: 1398,
//     amt: 2210,
//     trv: 2000,
//     color: "#04950c"
//   },
//   { name: "Page C", uv: 2000, pv: 8, amt: 2290, trv: 3908, color: "#020bf6" },
//   {
//     name: "Page D",
//     uv: 2780,
//     pv: 3908,
//     amt: 2000,
//     trv: 4800,
//     color: ""
//   },
//   { name: "Page E", uv: 18, pv: 4800, amt: 2181, trv: 2500, color: "#03640e" },
//   {
//     name: "Page F",
//     uv: 2390,
//     pv: 3800,
//     amt: 2500,
//     trv: 4300,
//     color: "#020bf6"
//   },
//   { name: "Page G", uv: 3490, pv: 4300, amt: 2100, trv: 4000, color: "#020fdf" }
// ];

const pureTroiaData = [
  {
    colorbar10: "red",
    bar10: 550,
    x: 45,
    colorbar14: "#0ab1b2",
    bar14: 600,
    colorbar20: "#000000",
    bar20: 550,
    key: "bar1030"
  },
  {
    colorbar10: "#000000",
    bar10: 270,
    x: 20,
    bar20: 270,
    colorbar20: "#046a09",
    colorbar12: "#0a5e20",
    bar12: 550,
    colorbar14: "#000000",
    bar14: 350,
    key: "bar1000"
  },
  {
    colorbar10: "#0299ed",
    bar10: 350,
    x: 30,
    colorbar11: "#0ab1b2",
    bar11: 600,
    colorbar20: "#05c60a",
    bar20: 350,
    key: "bar1010"
  },
  {
    colorbar10: "#0ca25f",
    bar10: 600,
    x: 35,
    colorbar14: "#0a5e20",
    bar14: 550,
    colorbar20: "#09938e",
    bar20: 600,
    key: "bar1020"
  },

  {
    colorbar13: "#eb144c",
    bar13: 550,
    x: 55,
    colorbar14: "#fcb900",
    bar14: 550,
    key: "bar1303"
  }
];

const subgroup1 = {
  color: "",
  name: "",
  pointList: [
    { x: 27, y: 475, z: 50, color: "", tooltip: "" },
    { x: 25, y: 515, z: 50, color: "", tooltip: "" },
    { x: 25, y: 600, z: 50, color: "", tooltip: "" },
    { x: 25, y: 750, z: 50, color: "", tooltip: "" },
    { x: 30, y: 200, z: 50, color: "", tooltip: "" },
    { x: 27, y: 425, z: 50, color: "", tooltip: "" },
    { x: 20, y: 375, z: 50, color: "", tooltip: "" },
    { x: 32, y: 475, z: 50, color: "", tooltip: "" }
  ]
};
const subGroupSectionPreparer = subgroup1 => {
  console.group("subGroupSectionPreparer");
  let uniqueXObjectFromSubgroupPointList = [
    ...new Set(
      subgroup1.pointList.map(entry => {
        return entry.x;
      })
    )
  ];
  let subGroupCount = findSubGroupCount(
    subgroup1.pointList.map(point => {
      return point.x;
    }),
    uniqueXObjectFromSubgroupPointList
  );
  console.log(subGroupCount);
  let pointListArray = [];
  let pointAppenderIndex = 0;
  let subGroupPointArr = subgroup1.pointList;
  console.log("subgroupPoint", subGroupPointArr);
  while (pointAppenderIndex < subGroupCount) {
    let pointList = [];
    for (
      let subGroupIndex = 0;
      subGroupIndex < subGroupPointArr.length;
      subGroupIndex++
    ) {
      const subgroupPointArray = subGroupPointArr;
      if (
        pointList
          .map(point => {
            return point.x;
          })
          .includes(Reflect.get(subgroupPointArray[subGroupIndex], "x"))
      ) {
        continue;
      } else {
        pointList.push(subgroupPointArray[subGroupIndex]);
      }
    }
    subGroupPointArr = subGroupPointArr.filter(point => {
      return !pointList.includes(point);
    });

    pointListArray.push(pointList);
    pointAppenderIndex++;
  }
  console.log("all points with separated", pointListArray);
  console.groupEnd();
};

const findSubGroupCount = (
  subgroupAllXKeys,
  uniqueXObjectFromSubgroupPointList
) => {
  let count = 0;
  uniqueXObjectFromSubgroupPointList.forEach(xKey => {
    const xKeyLength = subgroupAllXKeys.filter((x, i) => {
      return x === xKey;
    }).length;
    if (count < xKeyLength) {
      count = xKeyLength;
    }
  });
  return count;
};

const renderCustomizedLabel = props => {
  const { x, y, width, height, value } = props;
  const radius = 10;

  return (
    <g>
      <circle cx={x + width / 2} cy={y - radius} r={radius} fill="#8884d8" />
      <text
        x={x + width / 2}
        y={y - radius}
        fill="#fff"
        textAnchor="middle"
        dominantBaseline="middle"
      >
        {value.split(" ")[1]}
      </text>
    </g>
  );
};

export default class ReChartBarTest extends React.Component {
  getBarList = () => {
    return [
      <Bar key="1" dataKey="uv" fill="black" minPointSize={10}>
        {data.map((entry, index) => {
          let obj = "";
          if (entry == "") {
            obj = "black";
          } else {
            obj = entry.color;
          }
          return <Cell fill={obj} />;
        })}
      </Bar>,
      <Bar key="2" dataKey="uv" fill="black" minPointSize={10}>
        {data.map((entry, index) => {
          let obj = "";
          if (entry == "") {
            obj = "black";
          } else {
            obj = entry.color;
          }
          return <Cell fill={obj} />;
        })}
      </Bar>,
      <Bar key="3" dataKey="pv" fill="black" minPointSize={10}>
        {data.map((entry, index) => {
          let obj = "";
          if (entry == "") {
            obj = "black";
          } else {
            obj = entry.color;
          }
          return <Cell fill={obj} />;
        })}
      </Bar>
    ];
  };

  render() {
    subGroupSectionPreparer(subgroup1);
    const result = (
      <ComposedChart
        width={900}
        height={300}
        data={pureTroiaData}
        margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
        barCategoryGap={35}
      >
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis orientation="bottom" dataKey="x" interval="preserveEnd" />
        <YAxis orientation="left" />
        <Tooltip />
        <Legend layout={"horizontal"} verticalAlign="top" />
        <Bar key={"bar10"} dataKey={"bar10"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar10" + index}
                fill={Reflect.get(point, "color" + "bar10")}
              />
            );
          })}
        </Bar>
        <Bar key={"bar11"} dataKey={"bar11"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar11" + index}
                fill={Reflect.get(point, "color" + "bar11")}
              />
            );
          })}
        </Bar>
        <Bar key={"bar12"} dataKey={"bar12"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar12" + index}
                fill={Reflect.get(point, "color" + "bar12")}
              />
            );
          })}
        </Bar>
        <Bar key={"bar13"} dataKey={"bar13"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar13" + index}
                fill={Reflect.get(point, "color" + "bar13")}
              />
            );
          })}
        </Bar>
        <Bar key={"bar14"} dataKey={"bar14"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar14" + index}
                fill={Reflect.get(point, "color" + "bar14")}
              />
            );
          })}
        </Bar>
        <Bar key={"bar20"} dataKey={"bar20"} barSize={5}>
          {pureTroiaData.map((point, index) => {
            return (
              <Cell
                key={"bar20" + index}
                fill={Reflect.get(point, "color" + "bar20")}
              />
            );
          })}
        </Bar>
      </ComposedChart>
    );
    console.log(result);
    return result;
  }
}
/**   <Bar dataKey="trv" fill="#c00000" minPointSize={10} />{" "}
        <Bar dataKey="pv" fill="#8884d8" minPointSize={5}>
          <LabelList dataKey="name" content={renderCustomizedLabel} />
        </Bar> */
