import React from "react";
class IasInput extends React.Component {
    constructor() {
        super();
        this.state = {
            focused: false
        };
    }
    onFocus = () => {
        this.setState({ focused: true });
    };

    render() {
        const iasInputContainer = {
            display: "flex",
            flexDirection: "column",
            LabelStyle: { fontFamily: "inherit", paddingLeft: "4px", fontSize: "12px", color: this.state.focused ? "#FAB807" : "#002033" },
            inputContainerStyle: {
                display: "flex", flexDirection: "row",
                fontFamily: "inherit",
                outlineStyle: "none",
                borderStyle: "solid",
                borderWidth: "0px",
                borderBottomWidth: "1px",
                borderBottomColor: this.state.focused ? "#FAB807" : "#262626",
                fontSize: "12px",
                backgroundColor: "#f7f7f7"
            },
            inputStyle: {
                fontSize: "inherit",
                width: "90%",
                outlineStyle: "none",
                fontFamily: "inherit",
                color: "#262626",
                border: "none",
                backgroundColor: "#f7f7f7",
                padding: "8px 6px 8px 6px"
            },
            suffixStyle: { width: "10%", textAlign: "center" }
        };
        let suffix = <div />;
        if (this.props.suffix && this.props.suffix != null) {
            suffix = this.props.suffix;
        }
        return (
            <div style={iasInputContainer}>
                <label style={iasInputContainer.LabelStyle}>{this.props.placeholder}</label>
                <div style={iasInputContainer.inputContainerStyle  }>
                    <input
                        name={this.props.name}
                        onFocus={this.onFocus}
                        onBlur={() => {
                            this.setState({ focused: false });
                        }}
                        onKeyPress={this.props.onKeyPress}
                        id={this.props.id}
                        type={this.props.type}
                        autoComplete={this.props.autoComplete}
                        onChange={this.props.onChange}
                        style={iasInputContainer.inputStyle}
                    />
                    <div style={iasInputContainer.suffixStyle}>{suffix}</div>
                </div>
            </div>
        );
    }
}

export default IasInput;
