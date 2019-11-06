import React from "react";
import ReactDOM from "react-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import LandingPage from "./components/LandingPage";
import App from "./App";
import FileUploadContainer from "./components/FileUpload/FileUploadContainer";

ReactDOM.render(
  <BrowserRouter>
    <App>
      <Switch>
        <Route exact path="/" component={LandingPage} />
        <Route exact path="/upload" component={FileUploadContainer} />
      </Switch>
    </App>
  </BrowserRouter>,
  document.getElementById("root")
);
