import React from "react";
import Config from "../../../../public/configure.json";
export default class Header extends React.Component {
  constructor() {
    super();
  }
  render() {
    return (
      <div
        style={{
          backgroundColor: "grey",
          position: "fixed",
          width: "100%",
          top: "0px",
          height: "30px",
          zIndex: "90"
        }}
      >
        <div
          style={{
            display: "flex",
            flexDirection: "row",
            justifyContent: "space-between",
            height: "30px",
            alignItems: "center",
            margin: "0px 15px 0px 15px"
          }}
        >
          <div>{Config.headerTitle}</div>
          <a href="https://www.ias.com.tr">
            <img
              src="./images/logo.svg"
              height={"20px"}
              width="80px"
              style={{ marginRight: "15px" }}
            />
          </a>
        </div>
      </div>
    );
  }
}
