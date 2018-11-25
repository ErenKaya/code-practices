import React from "react";
import ReactDOM from "react-dom";
import IndecisionApp from "./components/IndecisionApp";
import "normalize.css/normalize.css";
import "./styles/styles.scss";
import Test from "./components/Test";
import Counter from "./playground/counter-example-default";
import "nprogress/nprogress.css";
import TableFilterTest from "./components/TableFilterTest";

ReactDOM.render(<TableFilterTest />, document.getElementById("app"));
