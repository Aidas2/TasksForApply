import React from "react";
import {NavLink} from "react-router-dom";
import "./NavigationComponent.css";

const NavigationComponent = () => {
    return (
        <div>
            <ul>
                <li><NavLink to="/">Home Page</NavLink></li>
                <li>
                    <NavLink to="/banners">Currently showing/playing</NavLink>
                </li>         
            </ul>
        </div>
    );
};

export  default NavigationComponent;