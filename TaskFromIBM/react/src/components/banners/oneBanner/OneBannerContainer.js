import React, {Component} from "react";
import {Link} from "react-router-dom"; 
import axios from "axios";
import OneBannerComponent from "./OneBannerComponent";

class OneBannerContainer extends Component{
    constructor(props){
        super(props);
        this.state = {
            titleOfChannel: "ThisIsATitleFromConstructor",
            titleOfShow: "TheBestShow",
            showingTime: "Now",
        };
    }
      
    render() {
        return(
            <div>

                <OneBannerComponent
                    titleOfChannel={this.props.titleOfChannel}
                    titleOfShow={this.props.titleOfShow}
                    showingTime={this.props.showingTime}
                >
                </OneBannerComponent>
             
                    </div>
        );
    }
}

export default OneBannerContainer;
