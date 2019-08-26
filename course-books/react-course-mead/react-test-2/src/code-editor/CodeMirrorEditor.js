import React from "react";
import CodeMirror from "codemirror";
// require("./Dart");
import "./Troia";
import "../../node_modules/codemirror/theme/oceanic-next.css";
// require("codemirror/mode/jsx/jsx");
export default class CodeMirrorEditor extends React.Component {
   constructor() {
      super();
   }

   componentDidMount = () => {
      console.log(this.codeMirror);
      //   CodeMirror.defineMode("troia",(config,parserMode)=>{
      //     console.log("parserMode",parserMode);
      //   });
      CodeMirror(this.editorRef, {
         value: "main() {print('Hello, World!');}\n",
         mode: "troia",
         theme: "oceanic-next"
      });
   };

   render() {
      return <div ref={ref => (this.editorRef = ref)} />;
   }
}
