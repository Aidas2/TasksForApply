import React, { Component } from "react";
import axios from 'axios';
import OneBannerContainer from "../oneBanner/OneBannerContainer";

class ListOfBannersContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
        banners: []
    };
  }

  componentDidMount() {
      axios
          //.get("https://vod.lrt.lt/mcache/_definst_/lrt/mp4:VIDEO/Block/VISUR.mp4/playlist.m3u8")
          //.get("https://srautas.lrt.lt/lrt_televizija/smil:lrt_televizija.smil/playlist.m3u8?tokenhash=5alVGz7Bx9V_NSKYHfQbAr4Vu8k8SjgIF26d7RBLjHzuWOyjRfuRUz8j9wTUtUfXBRwkCSbc2h8K8sCYXO4OWA==&tokenendtime=1561818871")
          //.get("https://www.lrt.lt/mediateka/tiesiogiai/lrt-televizija")
          .get("http://localhost:8081/api/banners")
          .then((response) => {
              console.log(response.data);
              this.setState({ banners: response.data });
          })
          .catch((error) => {
              console.log(error);
          });
  }

  render() {

    const bannersList = this.state.banners.map((banner) => (
      
      <OneBannerContainer
        id={banner.id}
        key={banner.titleOfChannel}
        titleOfChannel={banner.titleOfChannel}
        titleOfShow={banner.titleOfShow}
        showingTime={banner.showingTime}
        >
      </OneBannerContainer>
    ));

    return (
      <div className="container-fluid">
        <h1>Currently showing/playing:</h1>
        {/* <p>Hi, this is ListOfBannersContainer</p> */}
        <div className="row">{bannersList}</div>
      </div>
    );

  }

}

export default ListOfBannersContainer;
