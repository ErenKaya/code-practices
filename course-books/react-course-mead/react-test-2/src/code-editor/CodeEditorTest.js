import React from "react";
import CodeMirrorEditor from "./CodeMirrorEditor";
export default class CodeEditorTest extends React.Component {
   constructor() {
      super();
   }

   render() {
      return (
         <div>
            <CodeMirrorEditor />
         </div>
      );
   }
}
