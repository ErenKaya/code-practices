import React from "react";
import Konva from "konva";
import { Stage, Layer, Path, Text, Shape } from "react-konva";
export default class KonvaVerticalCllynder extends React.Component {
   render() {
      return (
         <Stage width={200} height={300}>
            <Layer ref={ref => (this.layerRef = ref)}>
               <Shape
                  sceneFunc={(ctx, shape) => {
                     const X = 30,
                        Y = 40,
                        W = 150,
                        H = 50;
                     const heightPartConstant = 7;
                     const widthPartConstant = 4;
                     const onePieceOfHeightPartAmount = H / heightPartConstant;
                     const onePieceOfWidthPartAmount = W / widthPartConstant;
                     const beginPointX = 0;
                     ctx.beginPath();
                     ctx.moveTo(beginPointX, onePieceOfHeightPartAmount);
                     ctx.bezierCurveTo(beginPointX, onePieceOfHeightPartAmount * 3, W, onePieceOfHeightPartAmount * 3, W, onePieceOfHeightPartAmount);
                     ctx.moveTo(beginPointX, onePieceOfHeightPartAmount);
                     ctx.bezierCurveTo(beginPointX, onePieceOfHeightPartAmount * 0.09, W, onePieceOfHeightPartAmount * 0.09, W, onePieceOfHeightPartAmount);
                     ctx.moveTo(beginPointX, onePieceOfHeightPartAmount);
                     ctx.lineTo(beginPointX, onePieceOfHeightPartAmount*5);
                     ctx.bezierCurveTo(beginPointX, onePieceOfHeightPartAmount *5 * 1.5, W, onePieceOfHeightPartAmount *5* 1.5, W, onePieceOfHeightPartAmount*5);
                        ctx.lineTo(W, onePieceOfHeightPartAmount);
                     //   ctx.bezierCurveTo(20, 160, 200, 160, 200, 120);
                     
                     ctx.stroke();
                  }}
                  fill={"#0000ff"}
                  stroke={"#ff0000"}
                  strokeWidth={1}
               />
            </Layer>
         </Stage>
      );
   }
}
