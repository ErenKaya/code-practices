import React from "react";
import Konva from "konva";
import { Stage, Layer, Path, Text, Shape } from "react-konva";

export default class LinkComponent extends React.Component {
   drawArrowhead = (context, from1, to, radius) => {
      var x_center = to.x;
      var y_center = to.y;

      var angle;
      var x;
      var y;

      context.beginPath();

      angle = Math.atan2(to.y - from1.y, to.x - from1.x);
      x = radius * Math.cos(angle) + x_center;
      y = radius * Math.sin(angle) + y_center;

      context.moveTo(x, y);

      angle += (1.0 / 3.0) * (2 * Math.PI);
      x = radius * Math.cos(angle) + x_center;
      y = radius * Math.sin(angle) + y_center;

      context.lineTo(x, y);

      angle += (1.0 / 3.0) * (2 * Math.PI);
      x = radius * Math.cos(angle) + x_center;
      y = radius * Math.sin(angle) + y_center;

      context.lineTo(x, y);

      context.closePath();

      context.fill();
   };
   render() {
      return (
         <Stage width={500} height={600}>
            <Layer ref={ref => (this.layerRef = ref)}>
               <Shape
                  sceneFunc={(ctx, shape) => {
                     const margin = 3;
                     const X = 30,
                        Y = 40,
                        W = 150 - margin,
                        H = 100 - margin;
                     const halfOfWidth = W / 2;

                     ctx.beginPath();
                     ctx.moveTo(margin, margin);
                     ctx.lineWidth = 2;

                     ctx.lineTo(W, H);
                     ctx.stroke();
                     this.drawArrowhead(ctx, { x: margin, y: margin }, { x: W, y: H }, 3);
                     ctx.stroke();
                     this.drawArrowhead(ctx,  { x: W, y: H },{ x: margin, y: margin }, 3);
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
