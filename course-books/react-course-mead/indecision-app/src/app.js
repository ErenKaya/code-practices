import "normalize.css/normalize.css";
import "nprogress/nprogress.css";
import React from "react";
import ReactDOM from "react-dom";
import RePieChartActiveSector from "./components/RePieChartActiveSector";
import "./styles/styles.scss";
import ReComposedChart from "./components/ReComposedChart";

ReactDOM.render(<ReComposedChart />, document.getElementById("app"));
