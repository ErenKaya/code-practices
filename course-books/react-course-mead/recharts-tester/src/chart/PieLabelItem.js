export default class PieLabelItem {
   constructor() {
      this.sin;
      this.cos;
      this.sx;
      this.sy;
      this.mx;
      this.my;
      this.ex;
      this.ey;
      this.textAnchor;
   }

   static preparePieLabelPositionObject(midAngle, outerRadius, cx, cy) {
      const RADIAN = Math.PI / 180;
      this.sin = Math.sin(-RADIAN * midAngle);
      this.cos = Math.cos(-RADIAN * midAngle);
      this.sx = cx + outerRadius * this.cos;
      this.sy = cy + outerRadius * this.sin;
      this.mx = cx + (outerRadius + 30) * this.cos;
      this.my = cy + (outerRadius + 30) * this.sin;
      this.ex = this.mx + (this.cos >= 0 ? 1 : -1) * 22;
      this.ey = this.my;
      this.textAnchor = this.cos >= 0 ? "start" : "end";
      return this;
   }
}
