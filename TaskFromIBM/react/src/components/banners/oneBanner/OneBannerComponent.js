import React from "react";
import {Link} from "react-router-dom" 
import image from './lrt.jpg';

const OneBannerComponent = (props) =>{
    return(
        <div className="col-sm-4">

          <div className="card" style={{width: "18rem"}}>
                <h5 className="card-header">{props.titleOfChannel}</h5>          
                <div className="card-body">
                    <img className="card-img-top" src={image} alt={props.titleOfChannel} style={{height: "200px"}}/>
                    <p className="card-text">{props.titleOfShow}</p>
                    <p className="card-text">{props.showingTime}</p> 

                </div>

          </div>
          
        </div>
    );
} 
export default OneBannerComponent;
