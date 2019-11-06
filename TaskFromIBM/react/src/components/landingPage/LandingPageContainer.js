import React, {Component} from "react";
import cover from '../landingPage/cover.png';
//import landingPage from '../landingPage/landingPage.css';

class LandingPageContainer extends React.Component {
    render () {
        return (
            <div>
                <div style={{padding: 10}}>
                    <h1> IBM Internship task</h1>
                    {/* <p>Hi, this is LandingPageContainer. It does ... nothing :)</p> */}
                    <p>Create a web page that displays what LRT is currently showing/playing. Your source of data is in <span> <a target="_blank" className="myref" href="https://www.lrt.lt/mediateka/tiesiogiai/lrt-televizija">THIS</a></span> page, a banner titled "Tiesiogiai".</p>                   
                    <img src={cover} alt={this.title} style={{width: "100%"} }></img>
                </div>
            </div>
        );
    }
}

export default LandingPageContainer;