import {BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, LabelList, Legend} from 'recharts';
import React from 'react'

const data = [
      {name: 'Page A', uv: 4000, pv: 2400, amt: 2400,trv: 1398},
      {name: 'Page B', uv: 3000, pv: 1398, amt: 2210,trv: 2000},
      {name: 'Page C', uv: 2000, pv: 8, amt: 2290,trv: 3908},
      {name: 'Page D', uv: 2780, pv: 3908, amt: 2000,trv: 4800},
      {name: 'Page E', uv: 18, pv: 4800, amt: 2181,trv: 2500},
      {name: 'Page F', uv: 2390, pv: 3800, amt: 2500,trv: 4300},
      {name: 'Page G', uv: 3490, pv: 4300, amt: 2100,trv: 4000},
];

const renderCustomizedLabel = (props) => {
  const { x, y, width, height, value } = props;
  const radius = 10;

  return (
    <g>
      <circle cx={x + width / 2} cy={y - radius} r={radius} fill="#8884d8" />
      <text x={x + width / 2} y={y - radius} fill="#fff" textAnchor="middle" dominantBaseline="middle">
        {value.split(' ')[1]}
      </text>
    </g>
  );
};

export default class ReChartBarTest extends React.Component{
	render () {
  	return (
    	<BarChart width={600} height={300} data={data}
            margin={{top: 5, right: 30, left: 20, bottom: 5}}>
       <CartesianGrid strokeDasharray="3 3"/>
       <XAxis dataKey="name"/>
       <YAxis/>
       <Tooltip/>
       <Legend />
       <Bar dataKey="pv" fill="#8884d8" minPointSize={5}>
          <LabelList dataKey="name" content={renderCustomizedLabel} />
        </Bar>
       <Bar dataKey="uv" fill="#82ca9d" minPointSize={10}/>
       <Bar dataKey="trv" fill="#c00000" minPointSize={10}/>
      </BarChart>
    );
  }
} 
