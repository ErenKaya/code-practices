import React from "react";
import Konva from "konva";
import { Stage, Layer, Path, Text, Shape } from "react-konva";

export default class KonvaHorizontalCllynder extends React.Component {
   render() {
      return (
         <Stage width={500} height={600}>
            <Layer ref={ref => (this.layerRef = ref)}>
               <Shape
                  sceneFunc={(ctx, shape) => {
                    const X = 30,
                        Y = 40,
                        W = 150,
                        H = 100;
                     const widthPartConstant = 7;
                     const onePieceOfWidthPartAmount = W / widthPartConstant;
                     const beginPointY = 0;
                     ctx.beginPath();
                     ctx.moveTo(onePieceOfWidthPartAmount*2,beginPointY );
                     ctx.bezierCurveTo(beginPointY, onePieceOfWidthPartAmount * 3, H, onePieceOfWidthPartAmount * 3, H, onePieceOfWidthPartAmount*2);
                    //  ctx.moveTo(beginPointY, onePieceOfHeightPartAmount);
                    //  ctx.bezierCurveTo(beginPointY, onePieceOfHeightPartAmount * 0.09, W, onePieceOfHeightPartAmount * 0.09, W, onePieceOfHeightPartAmount);
                    //  ctx.moveTo(beginPointY, onePieceOfHeightPartAmount);
                    //  ctx.lineTo(beginPointY, onePieceOfHeightPartAmount*5);
                    //  ctx.bezierCurveTo(beginPointY, onePieceOfHeightPartAmount *5 * 1.5, W, onePieceOfHeightPartAmount *5* 1.5, W, onePieceOfHeightPartAmount*5);
                    //     ctx.lineTo(W, onePieceOfHeightPartAmount);
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
/**   
                     const R = 50;
                     const centerOfCircleX = 100;
                     const centerOfCircleY = 75;
                     context.beginPath();
                     context.arc(centerOfCircleX, centerOfCircleY, R, 0 * Math.PI, 2 * Math.PI);
                     const rightEdgeOfCircleX = centerOfCircleX + R;
                     const rightEdgeOfCircleY = centerOfCircleY + R;
                     context.moveTo(rightEdgeOfCircleX, centerOfCircleY);
                     context.lineTo(rightEdgeOfCircleX, rightEdgeOfCircleY + 20);
                     context.stroke();
                     context.closePath(); */
