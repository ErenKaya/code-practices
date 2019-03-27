import React from "react";

class ImageSelector extends React.Component {
  constructor() {
    super();
    this.state = {
      imageShow: false,
      imgSrcList: [
        "images/eggbot_1.png",
        "images/eggbot_2.png",
        "images/eggbot_3.png",
        "images/eggbot_4.png",
        "images/eggbot_5.png",
        "images/eggbot_6.png"
      ]
    };
  }
  showImages = () => {
    this.setState(prevState => {
      if (prevState.imageShow) {
        return { imageShow: false };
      } else {
        return { imageShow: true };
      }
    });
  };

  //   componentDidUpdate = () => {
  //     console.log(this.state);
  //   };
  render() {
    return (
      <div style={this.props.style}>
        <div id={"preview"} style={{ display: "flex", flexDirection: "row" }}>
          <div id="previewer">asdgfhjgkhk</div>
          <button onClick={this.showImages}>SHOW</button>
        </div>

        <div style={{ display: this.state.imageShow ? "" : "none" }}>
          {this.state.imgSrcList.map(imgSrc => {
            <img src={imgSrc} />;
          })}
        </div>
      </div>
    );
  }
}
export default ImageSelector;
