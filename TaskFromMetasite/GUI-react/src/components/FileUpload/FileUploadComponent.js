import React, { Component } from "react";
import PropTypes from "prop-types";

class FileUploadComponent extends Component {
  render() {
    return (
      <div className="container-fluid">
        <h3>File upload</h3>

        <form>
          <div className="input-group mb-3 mt-3 col-3  pl-2">
            <div className="input-group-prepend" />
            <div className="custom-file">
              <input
                type="file"
                onChange={this.props.onFile}
                className="custom-file-input "
                id="inputGroupFile01"
              />
              <label className="custom-file-label" form="inputGroupFile01">
                Choose the main document
              </label>
            </div>
          </div>
          <span className="m-2">{this.props.documentName}</span>
          <div className="input-group mb-3 mt-3 col-3  pl-2">
            <div className="input-group-prepend" />
            <div className="custom-file">
              <input
                type="file"
                multiple
                onChange={this.props.onFile}
                className="custom-file-input "
                id="inputGroupFile02"
              />
              <label className="custom-file-label" form="inputGroupFile01">
                Choose attachements
              </label>
            </div>
          </div>
          <span className="m-2">{this.props.attachmentsNames}</span>

          {/* <div className="m-2">
          <label>Pasirinkite paildomus failus</label>&nbsp;
          <br />
          <input type="file" multiple name="file" onChange={props.onFile} />
        </div>
        <br /> */}
          <button
            type="button"
            className="btn btn-info m-2"
            onClick={this.props.onUpload}
          >
            Upload
          </button>
        </form>
        <div className="container">{this.props.launchAlert}</div>
      </div>
    );
  }
}

export default FileUploadComponent;
