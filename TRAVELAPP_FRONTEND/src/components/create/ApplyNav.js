import React from "react";
import "../../style/create.css";
import "../../style/ApplyNav.css";
import { useState } from "react";
import Travel from "./Travel";
import Accommodation from "./Accommodation";
import TravelandAccommodation from "./TravelandAccommodation";
import FlightIcon from "@mui/icons-material/Flight";
import HotelIcon from "@mui/icons-material/Hotel";

import { toast, ToastContainer } from "react-toastify";
const ApplyNav = () => {
  return (
    <div className="ApplyNav">
      <nav class="navbar navbar-expand-sm navbar-dark ">
        <div class="container-fluid">
          <div className="link" id="mynavbar" style={{ color: "black" }}>
            <ul class="navbar-nav">
              <li className="LinkButton">
                <a
                  class="nav-link"
                  href="/create/Travel"
                  activeClassName="active"
                  style={{ color: "black" }}
                >
                  Travel <FlightIcon />
                </a>
              </li>
              <li className="LinkButton">
                <a
                  class="nav-link"
                  href="/create/Accommodation"
                  activeClassName="active"
                  style={{ color: "black" }}
                >
                  Accommodation <HotelIcon />
                </a>
              </li>
              <li className="LinkButton">
                <a
                  class="nav-link"
                  href="/create/TravelandAccommodation"
                  activeClassName="active"
                  style={{ color: "black" }}
                >
                  Travel+Accommodation <FlightIcon />
                  <HotelIcon />
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default ApplyNav;
