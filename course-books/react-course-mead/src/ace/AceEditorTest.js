import React from "react";
import AceEditor from "react-ace";

import "./AceEditorMode";
import "./AceEditorTheme";
// import "brace/theme/clouds"
// import "brace/mode/abap";
// import "brace/mode/java"

export default class AceEditorTest extends React.Component {
   constructor() {
      super();
   }

   onChange = newValue => {
      console.log("change", newValue);
   };

   componentDidMount = () => {};

   render() {
      return (
         <div ref={ref => (this.editorRef = ref)}>
            <AceEditor
               mode="troia"
               theme="troia"
               onSelectionChange={(val, e) => {
                  console.log(e);
                  console.log(val.getRange());
               }}
               name="UNIQUE_ID_OF_DIV"
               editorProps={{ $blockScrolling: true }}
               value={`selamtroia /* troia'dan selamlar */ 
/*COMMANDS*/
CLOSEPORT
/*COMMANDS_KEYWORDS*/
OVERLAY
/*FUNCTIONS*/
FOOTER()
/*LOOPS_AND_CONJUCTIONS*/
MAXIMIZEFRAME
/*DEPRECATED_COMMANDS*/
GETPRINTERNAMES
/*DEPRECATED_FUNCTIONS*/
GETSET1X()
/*String*/
'selam'
"Selam"
`}
            />
         </div>
      );
   }
}
