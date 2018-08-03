var app = {
    title: "Indecision App",
    subtitle: "This is subtitle",
    options: []
  };
  const addOption = (e) => {
    e.preventDefault();
    const option = e.target.elements.option.value;
    app.options.push(option)
    reRender();
  };
  const removeAll = () => {
    app.options = [];
    reRender();
  }
  const makeADecision = () => {
    const randNum = Math.floor(Math.random() * app.options.length);
    const option = app.options[randNum];
    alert(option);
  
  }
  var appRoot = document.getElementById("app");
  const numbers = [55, 101, 1000];
  // const reRender = () => {
  //   const template = (
  
  //   );
  //   ReactDOM.render(template, appRoot);
  // }
  
  reRender();
  
  