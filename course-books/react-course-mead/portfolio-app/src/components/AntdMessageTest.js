import React from "react";
import { message, Button } from "antd";

export default class AntdMessageTest extends React.Component {
   constructor() {
      super();
      this.messageContainer = null;
      this.MessageContainerRef = element => {
         this.messageContainer = element;
      };
   }
   success = () => {
      message.config({
         duration: 1,
         getContainer: () => this.messageContainer,
         top: window.innerHeight - Math.floor(window.innerHeight * 0.1)
      });
      message.success("Loading finished");
   };
   componentDidUpdate = () => {};
   render() {
      return (
         <div style={{ width: "500px", height: "300px" }}>
            <div style={{ width: "200px", height: "100px" }}>
               <p>Selam</p>
               <div
                  style={{
                     top: "100px",
                     left: "300px",
                     width: "10px",
                     height: "10px"
                  }}
               >
                  <Button
                     style={{
                        width: "inherit",
                        height: "inherit"
                     }}
                     onClick={this.success}
                  >
                     Display a sequence of message
                  </Button>
               </div>
               <div
                  style={{
                     top: "100px",
                     left: "300px",
                     width: "200px",
                     height: "300px"
                  }}
                  ref={this.MessageContainerRef}
               />
            </div>
         </div>
      );
   }
}
