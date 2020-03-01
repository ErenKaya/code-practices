import { Breadcrumb, Icon, Layout, Menu } from "antd";
import React from "react";
import Child from "./Child";

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

class DrawerContainerTest extends React.Component {
   constructor() {
      super();
      const c = new Child();
      c.c();
   }
   state = {
      collapsed: false
   };

   onCollapse = collapsed => {
      console.log(collapsed);
      this.setState({ collapsed });
   };

   render() {
      return (
         <Layout>
            {" "}
            <Header className="header">
               <Menu theme="light" mode="horizontal" defaultSelectedKeys={["2"]} style={{ lineHeight: "64px" }}>
                  <Menu.Item key="1">nav 1</Menu.Item>
                  <Menu.Item key="2">nav 2</Menu.Item>
                  <Menu.Item key="3">nav 3</Menu.Item>
               </Menu>
            </Header>
            <Layout style={{ minHeight: "100vh" }}>
               <Sider collapsible collapsed={this.state.collapsed} onCollapse={this.onCollapse}>
                  <div className="logo" />
                  <Menu theme="light" defaultSelectedKeys={["1"]} mode="inline">
                     <Menu.Item key="1">
                        <Icon type="pie-chart" />
                        <span>Option 1</span>
                     </Menu.Item>
                     <Menu.Item key="2">
                        <Icon type="desktop" />
                        <span>Option 2</span>
                     </Menu.Item>
                     <SubMenu
                        key="sub1"
                        title={
                           <span>
                              <Icon type="user" />
                              <span>User</span>
                           </span>
                        }
                     >
                        <Menu.Item key="3">Tom</Menu.Item>
                        <Menu.Item key="4">Bill</Menu.Item>
                        <Menu.Item key="5">Alex</Menu.Item>
                     </SubMenu>
                     <SubMenu
                        key="sub2"
                        title={
                           <span>
                              <Icon type="team" />
                              <span>Team</span>
                           </span>
                        }
                     >
                        <Menu.Item key="6">Team 1</Menu.Item>
                        <Menu.Item key="8">Team 2</Menu.Item>
                     </SubMenu>
                     <Menu.Item key="9">
                        <Icon type="file" />
                        <span>File</span>
                     </Menu.Item>
                  </Menu>
               </Sider>
               <Layout>
                  <Header style={{ background: "#fff", padding: 0 }} />
                  <Content style={{ margin: "0 16px" }}>
                     <Breadcrumb style={{ margin: "16px 0" }}>
                        <Breadcrumb.Item>User</Breadcrumb.Item>
                        <Breadcrumb.Item>Bill</Breadcrumb.Item>
                     </Breadcrumb>
                     <div style={{ padding: 24, background: "#fff", minHeight: 360 }}>Bill is a cat.</div>
                  </Content>
                  <Sider collapsible collapsed={this.state.collapsed} onCollapse={this.onCollapse}>
                     {" "}
                     <div className="logo" />
                     <Menu theme="light" defaultSelectedKeys={["1"]} mode="inline">
                        <Menu.Item key="1">
                           <Icon type="pie-chart" />
                           <span>Option 1</span>
                        </Menu.Item>
                        <Menu.Item key="2">
                           <Icon type="desktop" />
                           <span>Option 2</span>
                        </Menu.Item>
                        <SubMenu
                           key="sub1"
                           title={
                              <span>
                                 <Icon type="user" />
                                 <span>User</span>
                              </span>
                           }
                        >
                           <Menu.Item key="3">Tom</Menu.Item>
                           <Menu.Item key="4">Bill</Menu.Item>
                           <Menu.Item key="5">Alex</Menu.Item>
                        </SubMenu>
                        <SubMenu
                           key="sub2"
                           title={
                              <span>
                                 <Icon type="team" />
                                 <span>Team</span>
                              </span>
                           }
                        >
                           <Menu.Item key="6">Team 1</Menu.Item>
                           <Menu.Item key="8">Team 2</Menu.Item>
                        </SubMenu>
                        <Menu.Item key="9">
                           <Icon type="file" />
                           <span>File</span>
                        </Menu.Item>
                     </Menu>
                  </Sider>
               </Layout>
            </Layout>
         </Layout>
      );
   }
}

export default DrawerContainerTest;
