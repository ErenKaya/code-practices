import "normalize.css/normalize.css";
import "nprogress/nprogress.css";
import React from "react";
import ReactDOM from "react-dom";
import RePieChartActiveSector from "./components/RePieChartActiveSector";
import "./styles/styles.scss";

import ReChartBarTest from "./components/ReChartBarTest";
import ReComposedChart from "./components/ReComposedChart";
import ReComposedChartForBar from "./components/ReComposedChartForBar";
import ReComposedChartSpecItemTest from "./components/ReComposedChartSpecItemTest";

ReactDOM.render(
  <ReComposedChartSpecItemTest />,
  document.getElementById("app")
);
