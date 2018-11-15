class DataSource {
  constructor() {}

  controlValues = id => {
    return Object.keys({ com1: "a", com2: "b" }).filter(data => {
      id === data;
    });
  };

  addChangeListener = handleChange => {
    console.log(handleChange);
  };
  removeChangeListener = handleChange => {
    console.log(handleChange);
  };
}
export default DataSource;
