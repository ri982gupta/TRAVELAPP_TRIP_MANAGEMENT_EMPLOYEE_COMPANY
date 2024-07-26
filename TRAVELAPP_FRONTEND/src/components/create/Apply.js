import React from "react";
import "../../style/create.css";
import { useState } from "react";
import Travel from "./Travel";
import Accommodation from "./Accommodation";
import TravelandAccommodation from "./TravelandAccommodation";
import { toast, ToastContainer } from "react-toastify";
import FlightIcon from "@mui/icons-material/Flight";
import HotelIcon from "@mui/icons-material/Hotel";

const Apply = () => {
  const [showshowtoast, setshowshowtoast] = useState(false);
  const [showFormDomestic, setShowFormDomestic] = useState(false);
  const [showFormInternational, setShowFormInternational] = useState(false);
  const [showFormhotel, setShowFormhotel] = useState(false);

  if (showshowtoast == true) {
    toast("Data Saved successfully");
    setshowshowtoast(!showshowtoast);
  }

  const toggleFormDomestic = () => {
    setShowFormDomestic(!showFormDomestic);
    setShowFormInternational(false);
    setShowFormhotel(false);
  };
  const toggleFormInternational = () => {
    setShowFormDomestic(false);
    setShowFormInternational(!showFormInternational);
    setShowFormhotel(false);
  };
  const toggleFormhotel = () => {
    setShowFormDomestic(false);
    setShowFormInternational(false);
    setShowFormhotel(!showFormhotel);
  };
  return (
    <div className="Apply">
      <div
        className="row"
        style={{ margin: "20px 20px", background: "rgb(215, 228, 238)" }}
      >
        <div className="col-md-3 mb-2">
          <button
            type="button"
            className="btn btn-primary"
            onClick={toggleFormDomestic}
          >
            Travel
            <FlightIcon />
          </button>
        </div>
        <div className="col-md-3 mb-2">
          <button
            type="button"
            className="btn btn-primary"
            onClick={toggleFormInternational}
          >
            Accommodation
          </button>
        </div>
        <div className="col-md-3 mb-2">
          <button
            type="button"
            className="btn btn-primary"
            onClick={toggleFormhotel}
          >
            Travel+Accommodation
          </button>
        </div>
        <div>
          {showFormDomestic && (
            <Travel
              showshowtoast={showshowtoast}
              setshowshowtoast={setshowshowtoast}
              showFormDomestic={showFormDomestic}
              setShowFormDomestic={setShowFormDomestic}
            />
          )}
          {showFormInternational && (
            <Accommodation
              showshowtoast={showshowtoast}
              setshowshowtoast={setshowshowtoast}
              showFormInternational={showFormInternational}
              setShowFormInternational={setShowFormInternational}
            />
          )}
          {showFormhotel && (
            <TravelandAccommodation
              showshowtoast={showshowtoast}
              setshowshowtoast={setshowshowtoast}
              showFormhotel={showFormhotel}
              setShowFormhotel={setShowFormhotel}
            />
          )}
          {<ToastContainer />}
        </div>
      </div>
    </div>
  );
};

export default Apply;
