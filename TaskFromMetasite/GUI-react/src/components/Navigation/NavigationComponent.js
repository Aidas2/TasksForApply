import React, { Component } from "react";
import { Link } from "react-router-dom";

class NavigationComponent extends Component {
  render() {
    return (
      <div>
        <nav className="nav justify-content-end">
          <Link to={"/"} className="nav-link">
            Home page
          </Link>

          <Link to={"/upload"} className="nav-link">
            File upload
          </Link>
        </nav>
      </div>
    );
  }
}

export default NavigationComponent;
