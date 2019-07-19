export default {
  preparePieLabelPositionObject(midAngle, outerRadius, cx, cy, pieLabelItem) {
    const RADIAN = Math.PI / 180;
    pieLabelItem.sin = Math.sin(-RADIAN * midAngle);
    pieLabelItem.cos = Math.cos(-RADIAN * midAngle);
    pieLabelItem.sx = cx + (outerRadius + 10) * cos;
    pieLabelItem.sy = cy + (outerRadius + 10) * sin;
    pieLabelItem.mx = cx + (outerRadius + 30) * cos;
    pieLabelItem.my = cy + (outerRadius + 30) * sin;
    pieLabelItem.ex = mx + (cos >= 0 ? 1 : -1) * 22;
    pieLabelItem.ey = my;
    pieLabelItem.textAnchor = cos >= 0 ? "start" : "end";
  }
};
