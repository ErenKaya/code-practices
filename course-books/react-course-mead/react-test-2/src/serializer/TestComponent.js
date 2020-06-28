import React from "react";

export default class TestComponent extends React.Component {
   beforUnload = event => {
     console.log("greetings from there");
      event.preventDefault();
      // Chrome requires returnValue to be set.
      event.returnValue = "";
   };
   render() {
      window.addEventListener("beforeunload", this.beforUnload);
      return <div>Eren</div>;
   }
}
