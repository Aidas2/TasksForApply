import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import {Route, BrowserRouter, Switch} from "react-router-dom";

import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import NavigationContainer from "./components/navigation/NavigationContainer";
import FooterContainer from "./components/footer/FooterContainer";
import LandingPageContainer from "./components/landingPage/LandingPageContainer";
import ListOfBannersContainer from "./components/banners/listOfBanners/ListOfBannersContainer";
import OneBannerContainer from './components/banners/oneBanner/OneBannerContainer';

//ReactDOM.render(<App />, document.getElementById('root'));

ReactDOM.render(

    <div>
        <BrowserRouter>
            <div className="container myborders">

                <NavigationContainer />
            
                <Switch>
                <Route path = "/" exact component={LandingPageContainer} />
                <Route path = "/banners" exact component={ListOfBannersContainer} />
                </Switch>

                <FooterContainer className="myfooter" />
            </div>
        </BrowserRouter>
    </div>,
    
    document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
