import React from "react";
import CodeMirror from "codemirror";
// require("./Dart");
import "./Troia";
// import "../../node_modules/codemirror/theme/duotone-light.css";
require("codemirror/mode/fortran/fortran");
import * as DiffMatchPatch from "diff-match-patch";
import * as MergeViewCodeMirror from "merge-view-codemirror";
export default class CodeMirrorEditor extends React.Component {
   constructor() {
      super();
   }

   componentDidMount = () => {
      //   CodeMirror.defineMode("troia",(config,parserMode)=>{
      //     console.log("parserMode",parserMode);
      //   });
      console.log(this.editorRef);
      const config = {
         value: "main() {print('Hello, World!');}\n",
         origLeft: null,
         orig: "asdffdhgh",
         lineNumbers: true,
         mode: "troia",
         showDifferences: true,
         connect: "align",
         collapseIdentical: 2,
         highlightDifferences: true
      };
      MergeViewCodeMirror.init(CodeMirror, DiffMatchPatch);
      const dv = CodeMirror.MergeView(this.editorRef, config);
      console.log(dv);
   };

   render() {
      return <div ref={ref => (this.editorRef = ref)} />;
   }
}
