import React from "react";
import FormValidationTest from "./FormValidationTest.jsx";

export default class FormValidationApp extends React.Component {
  state = {
    showFormSuccess: false
  };

  /**
   * This method is the one that should handle your form submits.
   * Timpcally, it will send the form data with an ajax call to your server.
   * In react, you would usually use the axios lib for that.
   **/
  submit = () => {
    //Replace this code with a working request to your backend.
    //Now it just displays a success message.
    this.setState({ showFormSuccess: true });
    setTimeout(() => {
      this.setState({ showFormSuccess: false });
    }, 5000);
  };

  _renderSuccessMessage() {
    return (
      <div className={"alert alert-success mt-4"} role="alert">
        Form was successfully validated and is ready to be submitted!
      </div>
    );
  }
  componentDidUpdate = (prevProps, prevState) => {
    console.log(prevState);
  };

  /**
   * Renders the page UI. Uses the Form component defined above
   * instead of the usual html form.
   * Uses Bootstrap layout classes.
   **/
  render() {
    return (
      <div className={"container pt-4"}>
        <div className={"row justify-content-center"}>
          <div className={"card"}>
            <h5 className={"card-header"}>Validation Test Form</h5>
            <div className={"card-body"}>
              <FormValidationTest submit={this.submit}>
                <div className={"form-group"}>
                  <label htmlFor={"email"}>Email</label>
                  <input
                    id={"email"}
                    className={"form-control"}
                    required={true}
                    name={"email"}
                    type={"email"}
                  />
                  <div className="invalid-feedback" />
                </div>
                <div className={"form-group"}>
                  <label htmlFor={"password"}>Password</label>
                  <input
                    id={"password"}
                    className={"form-control"}
                    required={true}
                    name={"password"}
                    type={"password"}
                    minLength={6}
                    pattern="(?=.*\d)(?=.*[a-z]).{6,}"
                  />
                  <small className="form-text text-muted">
                    Must be at least 6 characters long, contain letters and
                    numbers
                  </small>
                  <div className="invalid-feedback" />
                </div>
                <div className={"row justify-content-md-center"}>
                  <div className={"col-sm-12"}>
                    <button type={"submit"} className={"btn btn-primary mb-2"}>
                      Test submit!
                    </button>
                  </div>
                </div>
              </FormValidationTest>
            </div>
          </div>
        </div>
        {this.state.showFormSuccess ? this._renderSuccessMessage() : null}
      </div>
    );
  }
}
