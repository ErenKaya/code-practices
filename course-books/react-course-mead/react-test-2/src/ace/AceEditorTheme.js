ace.define("ace/theme/troia", ["require", "exports", "module", "ace/lib/dom"], function(acequire, exports, module) {
   exports.isDark = false;
   exports.cssClass = "ace-troia";
   exports.cssText =
      ".ace-troia .ace_gutter {\
    background: #ebebeb;\
    color: #333\
    }\
    .ace-troia .ace_print-margin {\
    width: 1px;\
    background: #e8e8e8\
    }\
    .ace-troia {\
    background-color: #FFFFFF;\
    color: #000000\
    }\
    .ace-troia .ace_cursor {\
    color: #000000\
    }\
    .ace-troia .ace_marker-layer .ace_selection {\
    background: #BDD5FC\
    }\
    .ace-troia.ace_multiselect .ace_selection.ace_start {\
    box-shadow: 0 0 3px 0px #FFFFFF;\
    }\
    .ace-troia .ace_marker-layer .ace_step {\
    background: rgb(255, 255, 0)\
    }\
    .ace-troia .ace_marker-layer .ace_bracket {\
    margin: -1px 0 0 -1px;\
    border: 1px solid #BFBFBF\
    }\
    .ace-troia .ace_marker-layer .ace_active-line {\
    background: #FFFBD1\
    }\
    .ace-troia .ace_gutter-active-line {\
    background-color : #dcdcdc\
    }\
    .ace-troia .ace_marker-layer .ace_selected-word {\
    border: 1px solid #BDD5FC\
    }\
    .ace-troia .ace_invisible {\
    color: #BFBFBF\
    }\
    .ace-troia .ace_keyword,\
    .ace-troia .ace_meta,\
    .ace-troia .ace_support.ace_constant.ace_property-value {\
    color: #AF956F\
    }\
    .ace-troia .ace_keyword.ace_operator.ace_troia {\
    color: yellow;\
    }\
    .ace-troia .ace_commands {\
      color: rgb(0, 57, 193);\
      }\
      .ace-troia .ace_functions.ace_deprecated {\
        color: rgb(255, 0, 0);\
        }\
        .ace-troia .ace_commands.ace_deprecated {\
          color: rgb(0, 0, 128);\
          }\
    .ace-troia .ace_commands.ace_keywords {\
    color: rgb(153, 0, 51);\
    }\
    .ace-troia .ace_functions {\
      color: rgb(0, 150, 0);\
      }\
    .ace-troia .ace_loopsconjuctions {\
    color: rgb(101, 0, 153);\
    }\
    .ace-troia .ace_keyword.ace_other.ace_unit {\
    color: #96DC5F\
    }\
    .ace-troia .ace_constant.ace_language {\
    color: #39946A\
    }\
    .ace-troia .ace_constant.ace_numeric {\
    color: #46A609\
    }\
    .ace-troia .ace_constant.ace_character.ace_entity {\
    color: #BF78CC\
    }\
    .ace-troia .ace_invalid {\
    background-color: #FF002A\
    }\
    .ace-troia .ace_fold {\
    background-color: #AF956F;\
    border-color: #000000\
    }\
    .ace-troia .ace_storage,\
    .ace-troia .ace_support.ace_class,\
    .ace-troia .ace_support.ace_function,\
    .ace-troia .ace_support.ace_other,\
    .ace-troia .ace_support.ace_type {\
    color: #C52727\
    }\
    .ace-troia .ace_string {\
    color: rgb(154,0,188)\
    }\
    .ace-troia .ace_comment {\
    color: #BCC8BA\
    }\
    .ace-troia .ace_entity.ace_name.ace_tag,\
    .ace-troia .ace_entity.ace_other.ace_attribute-name {\
    color: #606060\
    }\
    ";

   var dom = acequire("../lib/dom");
   dom.importCssString(exports.cssText, exports.cssClass);
});
