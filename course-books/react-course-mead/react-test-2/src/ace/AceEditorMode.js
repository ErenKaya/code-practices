ace.define("ace/mode/troia_highlight_rules", ["require", "exports", "module", "ace/lib/oop", "ace/mode/text_highlight_rules"], function(
   acequire,
   exports,
   module
) {
   "use strict";

   var oop = acequire("../lib/oop");
   var TextHighlightRules = acequire("./text_highlight_rules").TextHighlightRules;
   var DocCommentHighlightRules = function() {
      this.$rules = {
         start: [
            {
               token: "comment.doc.tag",
               regex: "@[\\w\\d_]+" // TODO: fix email addresses
            },
            DocCommentHighlightRules.getTagRule(),
            {
               defaultToken: "comment.doc",
               caseInsensitive: true
            }
         ]
      };
   };

   oop.inherits(DocCommentHighlightRules, TextHighlightRules);

   DocCommentHighlightRules.getTagRule = function(start) {
      return {
         token: "comment.doc.tag.storage.type",
         regex: "\\b(?:TODO|FIXME|XXX|HACK)\\b"
      };
   };

   DocCommentHighlightRules.getStartRule = function(start) {
      return {
         token: "comment.doc", // doc comment
         regex: "\\/\\*(?=\\*)",
         next: start
      };
   };

   var TroiaHighlightRules = function() {
      //KeyWordMapper class checks all keywords predefined before and points(".") are seperator for creating css class
      var keywordMapper = this.createKeywordMapper(
         {
            "commands.keywords": "OVERLAY",
            commands: "CLOSEPORT",
            functions: "FOOTER",
            loopsconjuctions: "MAXIMIZEFRAME",
            "commands.deprecated": "GETPRINTERNAMES",
            "functions.deprecated": "GETSET1X"
         },
         "text",
         true,
         " "
      );

      this.$rules = {
         start: [
            { token: "string", regex: "`", next: "string" },
            { token: "string", regex: "'", next: "qstring" },
            DocCommentHighlightRules.getStartRule("doc-start"),
            {
               token: "comment", // multi line comment
               regex: "\\/\\*",
               next: "comment"
            },
            { token: "invalid", regex: "\\.{2,}" },
            { token: "paren.lparen", regex: "[\\[({]" },
            { token: "paren.rparen", regex: "[\\])}]" },
            { token: "constant.numeric", regex: "[+-]?\\d+\\b" },
            { token: "variable.parameter", regex: /sy|pa?\d\d\d\d\|t\d\d\d\.|innnn/ },
            { token: "variable.parameter", regex: /\w+-\w+(?:-\w+)*/ },
            { token: keywordMapper, regex: "\\b\\w+\\b" },
            { caseInsensitive: true }
         ],
         qstring: [
            { token: "constant.language.escape", regex: "''" },
            { token: "string", regex: "'", next: "start" },
            { defaultToken: "string" }
         ],
         comment: [
            {
               token: "comment", // closing comment
               regex: "\\*\\/",
               next: "start"
            },
            {
               defaultToken: "comment"
            }
         ],
         string: [
            { token: "constant.language.escape", regex: "``" },
            { token: "string", regex: "`", next: "start" },
            { defaultToken: "string" }
         ]
      };
   };
   oop.inherits(TroiaHighlightRules, TextHighlightRules);

   exports.TroiaHighlightRules = TroiaHighlightRules;
});

ace.define("ace/mode/folding/coffee", ["require", "exports", "module", "ace/lib/oop", "ace/mode/folding/fold_mode", "ace/range"], function(
   acequire,
   exports,
   module
) {
   "use strict";

   var oop = acequire("../../lib/oop");
   var BaseFoldMode = acequire("./fold_mode").FoldMode;
   var Range = acequire("../../range").Range;

   var FoldMode = (exports.FoldMode = function() {});
   oop.inherits(FoldMode, BaseFoldMode);

   (function() {
      this.getFoldWidgetRange = function(session, foldStyle, row) {
         console.log("getFoldWidgetRange");
         var range = this.indentationBlock(session, row);
         if (range) return range;

         var re = /\S/;
         var line = session.getLine(row);
         var startLevel = line.search(re);
         if (startLevel == -1 || line[startLevel] != "#") return;

         var startColumn = line.length;
         var maxRow = session.getLength();
         var startRow = row;
         var endRow = row;

         while (++row < maxRow) {
            line = session.getLine(row);
            var level = line.search(re);

            if (level == -1) continue;

            if (line[level] != "#") break;

            endRow = row;
         }

         if (endRow > startRow) {
            var endColumn = session.getLine(endRow).length;
            return new Range(startRow, startColumn, endRow, endColumn);
         }
      };
      this.getFoldWidget = function(session, foldStyle, row) {
         var line = session.getLine(row);
         var indent = line.search(/\S/);
         var next = session.getLine(row + 1);
         var prev = session.getLine(row - 1);
         var prevIndent = prev.search(/\S/);
         var nextIndent = next.search(/\S/);

         if (indent == -1) {
            session.foldWidgets[row - 1] = prevIndent != -1 && prevIndent < nextIndent ? "start" : "";
            return "";
         }
         if (prevIndent == -1) {
            if (indent == nextIndent && line[indent] == "#" && next[indent] == "#") {
               session.foldWidgets[row - 1] = "";
               session.foldWidgets[row + 1] = "";
               return "start";
            }
         } else if (prevIndent == indent && line[indent] == "#" && prev[indent] == "#") {
            if (session.getLine(row - 2).search(/\S/) == -1) {
               session.foldWidgets[row - 1] = "start";
               session.foldWidgets[row + 1] = "";
               return "";
            }
         }

         if (prevIndent != -1 && prevIndent < indent) session.foldWidgets[row - 1] = "start";
         else session.foldWidgets[row - 1] = "";

         if (indent < nextIndent) return "start";
         else return "";
      };
   }.call(FoldMode.prototype));
});

ace.define(
   "ace/mode/troia",
   [
      "require",
      "exports",
      "module",
      "ace/mode/troia_highlight_rules",
      "ace/mode/folding/coffee",
      "ace/range",
      "ace/mode/text",
      "ace/lib/oop"
   ],
   function(acequire, exports, module) {
      "use strict";

      var Rules = acequire("./troia_highlight_rules").TroiaHighlightRules;
      var FoldMode = acequire("./folding/coffee").FoldMode;
      var Range = acequire("../range").Range;
      var TextMode = acequire("./text").Mode;
      var oop = acequire("../lib/oop");

      function Mode() {
         this.HighlightRules = Rules;
         this.foldingRules = new FoldMode();
      }

      oop.inherits(Mode, TextMode);

      (function() {
         this.lineCommentStart = '"';

         this.getNextLineIndent = function(state, line, tab) {
            var indent = this.$getIndent(line);
            return indent;
         };

         this.$id = "ace/mode/troia";
      }.call(Mode.prototype));

      exports.Mode = Mode;
   }
);
