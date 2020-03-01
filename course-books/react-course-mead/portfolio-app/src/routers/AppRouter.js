import React from "react";
import { BrowserRouter, Route, Switch, Link, NavLink } from "react-router-dom";
import NotFoundPage from "../components/NotFoundPage";
import Header from "../components/Header";
import HomePage from "../components/HomePage";
import Portfolio from "../components/Portfolio";
import PortfolioItem from "../components/PortfolioItem";
import Contact from "../components/Contact";
import DrawerContainerTest from "../components/DrawerContainerTest";

const AppRouter = () => (
   <BrowserRouter>
      <div>
         <Header />
         <Switch>
            <Route path="/" component={HomePage} exact={true} />
            <Route path="/portfolio" component={Portfolio} exact={true} />
            <Route path="/portfolio/:id" component={PortfolioItem} />
            <Route path="/contact" component={Contact} />
            <Route path="/messageTest" component={DrawerContainerTest} />
            <Route component={NotFoundPage} />
         </Switch>
      </div>
   </BrowserRouter>
);

export default AppRouter;
