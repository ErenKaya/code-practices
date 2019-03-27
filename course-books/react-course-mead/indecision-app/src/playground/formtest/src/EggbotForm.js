import React from "react";
import ImagePicker from "react-image-picker";
import Header from "./Header";
import Footer from "./Footer";
import axios from "axios";
import IasInput from "./IasInput";

const imgSrcList = [
  { src: "images/eggbot_1.png", id: "eggbot_1" },
  { src: "images/eggbot_2.png", id: "eggbot_2" },
  { src: "images/eggbot_3.png", id: "eggbot_3" },
  { src: "images/eggbot_4.png", id: "eggbot_4" },
  { src: "images/eggbot_5.png", id: "eggbot_5" },
  { src: "images/eggbot_6.png", id: "eggbot_6" }
];
let Config = {};
class EggbotForm extends React.Component {
  constructor() {
    super();
    this.state = {
      image: null,
      name: "",
      loginObject: {
        sessionId: "",
        securityKey: ""
      },
      placeHolder:""
    };
  }
  componentWillMount = () => {
    this.prepareConfig();
  };

  prepareConfig = () => {
    axios
      .get(window.location + "/configure.json")
      .then(res => {
        console.log(res.data);
        Config = res.data;
        document.getElementById("title").textContent = Config.title
        this.setState({placeHolder:Config.inputPlaceHolder})
      })
      .catch(err => {
        console.log(err);
      });
  };

  requestForWebServiceLogin = () => {
    const iasWebServiceW1 = `<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
                                   <SOAP-ENV:Header/>
                                   <SOAP-ENV:Body>
                                       <login xmlns="http://web.ias.com">
                                           <p_strClient>${
                                             Config.client
                                           }</p_strClient>
                                           <p_strLanguage>${
                                             Config.language
                                           }</p_strLanguage>
                                           <p_strDBName>${
                                             Config.database
                                           }</p_strDBName>
                                           <p_strDBServer>${
                                             Config.dbserver
                                           }</p_strDBServer>
                                           <p_strAppServer>${
                                             Config.appserver
                                           }</p_strAppServer>
                                           <p_strUserName>${
                                             Config.username
                                           }</p_strUserName>
                                           <p_strPassword>${
                                             Config.password
                                           }</p_strPassword>
                                       </login>
                                   </SOAP-ENV:Body>
                                   </SOAP-ENV:Envelope>`;
    const uri = Config.baseUri + Config.wsdlUrl;
    console.log("requestUri", uri);
    axios
      .post(Config.baseUri + Config.wsdlUrl, iasWebServiceW1, {
        headers: {
          "Content-Type": "text/xml",
          SOAPAction: "",
          "Access-Control-Allow-Origin": "http://www.ias.com.tr:8080",
          "Access-Control-Allow-Methods": "POST",
          "Access-Control-Allow-Headers": "Content-Type, Authorization"
        }
      })
      .then(res => {
        return this.parseXmlDocument(res.data);
      })
      .catch(err => {
        console.log(err);
      });
  };

  parseXmlDocument = (data: String) => {
    let parser;
    let xmlDocument: HTMLElement;
    if (window.DOMParser) {
      parser = new DOMParser();
      xmlDocument = parser.parseFromString(data, "text/xml");
    } // Internet Explorer
    else {
      xmlDocument = new ActiveXObject("Microsoft.XMLDOM");
      xmlDocument.async = false;
      xmlDocument.loadXML(data);
    }
    const sessionId = xmlDocument.getElementsByTagName("loginReturn")[0]
      .textContent;
    // const securityKey = xmlDocument.getElementsByTagName("SecurityKey")[0]
    //   .textContent;
    let loginObject = {};
    loginObject["sessionId"] = sessionId;
    // loginObject["securityKey"] = securityKey;
    this.setState({ loginObject }, this.requestForCallService);
  };

  onPick = image => {
    this.setState(prevState => {
      const prevStateObj = Object.assign({}, prevState);
      let imageObj = Object.assign({}, image);
      const imageId = image.value + 1;
      imageObj["id"] = "eggbot_" + imageId;
      return {
        prevStateObj,
        image: imageObj
      };
    });
  };

  onSubmit = e => {
    if (this.state.name && this.state.image) {
      this.requestForWebServiceLogin();
    }
  };

  requestForCallService = () => {
    const soapTextForCallService = `<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <callIASService xmlns="http://web.ias.com">
            <sessionid>${this.state.loginObject.sessionId}</sessionid>
            <serviceid>CreateEggbotSaleOrd</serviceid>
            <args>${this.state.image.id},${this.state.name}</args>
            <returntype/>
            <Permanent>false</Permanent>
        </callIASService>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>`;
    axios
      .post(Config.baseUri + Config.wsdlUrl, soapTextForCallService, {
        headers: {
          "Content-Type": "text/xml",
          SOAPAction: "",
          "Access-Control-Allow-Origin": "http://www.ias.com.tr:8080",
          "Access-Control-Allow-Methods": "POST",
          "Access-Control-Allow-Headers": "Content-Type, Authorization"
        }
      })
      .then(res => {
        console.log(res);
      })
      .catch(err => {
        console.log(err);
      });
  };

  onChange = e => {
    this.setState({ name: e.target.value });
  };

  componentDidUpdate = () => {
    console.log(this.state);
  };

  render() {
    return (
      <div>
        <Header />
        <div
          style={{
            maxWidth: "380px",
            marginTop: "40px",
            marginBottom: "80px",
            marginLeft: "auto",
            marginRight: "auto",
            padding: "0 1.6rem",
            background: ""
          }}
        >
          <div style={{ marginTop: "1.6rem" }}>
            <ImagePicker
              images={imgSrcList.map((image, i) => ({
                src: image.src,
                value: i,
                id: image.id
              }))}
              onPick={this.onPick}
            />
          </div>
          <div
            style={{
              display: "flex",
              flexDirection: "column"
            }}
          ><div style={{ marginTop: "1.6rem" }}>
            <IasInput
              onChange={this.onChange}
              type="text"
              autoComplete={"off"}
              placeholder={Config.inputPlaceHolder}
              name={"name"}
            />
            </div>

            
            
            <div className="button_cont" align="center" style={{ marginTop: "1.6rem" }}>
            <input
            className="example_c"
              type="button"
              value={"select"}
              onClick={this.onSubmit}
              style={{height:"43px",width:"100%"}}
            />
            </div>
          </div>
        </div>
        <Footer />
      </div>
    );
  }
}
export default EggbotForm;
