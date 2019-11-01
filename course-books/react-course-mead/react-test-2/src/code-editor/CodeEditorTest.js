import React from "react";
import CodeMirrorEditor from "./CodeMirrorEditor";
import TranslateConstants from "../js-source/TranslateConstants";
export default class CodeEditorTest extends React.Component {
   constructor() {
      super();
      TranslateConstants.SESSION_EXISTING
   }

   render() {
      return (
         <div>
            <CodeMirrorEditor />
         </div>
      );
   }
}
