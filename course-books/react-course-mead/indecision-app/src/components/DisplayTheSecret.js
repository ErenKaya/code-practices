import withSecretToLife from "./Util";
import React from "react";

const DisplayTheSecret = props => (
  <div>The secret to life is {props.secretToLife}.</div>
);
const WrappedComponent = withSecretToLife(DisplayTheSecret);
export default WrappedComponent;
