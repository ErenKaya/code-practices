import React from "react";

class BaseComponent extends React.Component {
  constructor() {
    if (new.target === BaseComponent) {
      throw new TypeError("Cannot construct Abstract class instance directly");
    }
    if (this.setComponentName === "unsupported") {
      throw new TypeError(
        "You must override unbody method >> setComponentName"
      );
    }
    super();
  }

  setComponentName = () => {
    return "unsupported";
  };
}

export default BaseComponent;
