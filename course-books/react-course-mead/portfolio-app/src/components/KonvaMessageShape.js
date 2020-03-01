import React from "react";
import Konva from "konva";
import { Stage, Layer, Path, Text, Shape } from "react-konva";
export default class KonvaMessageShapeJs extends React.Component {
   render() {
      return (
         <Stage width={200} height={300}>
            <Layer ref={ref => (this.layerRef = ref)}>
               <Shape
                  sceneFunc={(context, shape) => {
                     const R = 50;
                     const centerOfCircleX = 100;
                     const centerOfCircleY = 75;
                     context.beginPath();
                     context.arc(centerOfCircleX, centerOfCircleY, R, 0 * Math.PI, 2 * Math.PI);
                     const rightEdgeOfCircleX = centerOfCircleX + R;
                     const rightEdgeOfCircleY = centerOfCircleY + R;
                     context.moveTo(centerOfCircleX, centerOfCircleY + R);
                     context.lineTo(rightEdgeOfCircleX + R / 2, rightEdgeOfCircleY);

                     context.lineTo(centerOfCircleX +14, rightEdgeOfCircleY - 3);
                     context.stroke();
                     context.closePath();
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
