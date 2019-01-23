let pointObjectArray = [
  { x: 10, y: 15, z: 20 },
  { x: 15, y: 20, z: 25 },
  { x: 20, y: 25, z: 30 },
  { x: 20, y: 35, z: 40 }
];
let uniqueXDataFromPointArray = [
  ...new Set(
    pointObjectArray.map(entry => {
      return entry.x;
    })
  )
];

let iasSubgroupArray = [];
const separatedPointList = uniqueXDataFromPointArray.forEach(point => {
  const filteredObject = pointObjectArray.filter(entry => entry.x === point);
  if (filteredObject.length > 1) {
    console.log(" " + filteredObject + " " + point);
  }
});

console.log(uniqueXDataFromPointArray);
