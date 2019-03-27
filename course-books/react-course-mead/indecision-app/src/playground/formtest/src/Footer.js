import React from "react";
import Config from "../../../../public/configure.json";

class Footer extends React.Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div
        style={{
          position: "fixed",
          bottom: "0px",
          backgroundColor: "#fab807",
          width: "100%",
          height: "60px"
        }}
      >
        <div
          style={{
            display: "flex",
            flexDirection: "row",
            justifyContent: "space-between",
            alignItems: "center",
            margin: "0px 15px 0px 15px"
          }}
        >
          <div>
            <p style={{ fontSize: "12px",position: "relative" }}>{Config.footerTitle}</p>
          </div>
          <div style={{marginTop:"10px"}}>
            <img src="./images/ias-logo.png" width="100px" height="40px" />
          </div>
        </div>
      </div>
    );
  }
}

export default Footer;
