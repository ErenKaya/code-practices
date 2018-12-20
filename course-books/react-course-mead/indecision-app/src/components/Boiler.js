import ClassEs from "./ClassEs";
import React from "react";
import ClassEsComposition from './ClassEsComposition';

export default class Boiler extends React.Component {
  render() {
    const classEs = new ClassEs("sd", new ClassEsComposition());
    console.log(classEs.name);
    console.log(classEs.object);
    return <div />;
  }
}
