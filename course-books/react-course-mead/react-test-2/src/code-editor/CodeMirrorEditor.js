import React from "react";
import CodeMirror from "codemirror";
require("codemirror/mode/jsx/jsx");
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
         value: "function myScript(){return 100;}\n",
         mode: "jsx"
      });
   };

   render() {
      console.log(this.codeMirror);
      return <div ref={ref => (this.editorRef = ref)} />;
   }
}
