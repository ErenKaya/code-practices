import React from "react";
const withSecretToLife = WrappedComponent => {
  class HOC extends React.Component {
    render() {
      return <WrappedComponent {...this.props} secretToLife={42} />;
    }
  }
  return HOC;
};
export default withSecretToLife;
