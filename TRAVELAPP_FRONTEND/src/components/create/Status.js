import React from "react";
import "../../style/create.css";

const Status = () => {
  return (
    <div className="status-parent">
      <div className="row">
        <div className="status-container">
          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#cccccc"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
              style={{ color: "rgb(204, 204, 204)" }}
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Submitted
          </span>

          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#e54c53"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Rejected
          </span>

          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#CDE6FE"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Approved
          </span>
          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#0080ff"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Approved To Pay
          </span>
          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#D9FBB3"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Paid
          </span>
          <span className="status">
            <svg
              stroke="currentColor"
              fill="currentColor"
              strokeWidth="0"
              viewBox="0 0 16 16"
              color="#009933"
              height="12"
              width="12"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle cx="8" cy="8" r="8"></circle>
            </svg>
            Received
          </span>
        </div>
      </div>
    </div>
  );
};

export default Status;
