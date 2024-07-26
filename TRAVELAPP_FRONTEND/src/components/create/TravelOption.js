import React, { useState } from "react";

import OneWay from "./pages/OneWay";
import RoundTrip from "./pages/RoundTrip";
import MultiCity from "./pages/Multicity";
import "../../style/TravelOption.css";

const TravelOption = ({
  selectedOption,
  setSelectedOption,
  ApplyForformData,
}) => {
  const handleOptionChange = (event) => {
    setSelectedOption(event.target.id);
  };

  return (
    <div>
      <nav className="Traveloption">
        <input
          type="radio"
          id="oneWay"
          name="tripType"
          checked={selectedOption === "oneWay"}
          onChange={handleOptionChange}
        />
        <label htmlFor="oneWay">One Way</label>

        <input
          type="radio"
          id="roundTrip"
          name="tripType"
          checked={selectedOption === "roundTrip"}
          onChange={handleOptionChange}
        />
        <label htmlFor="roundTrip">Round Trip</label>

        <input
          type="radio"
          id="multiCity"
          name="tripType"
          checked={selectedOption === "multiCity"}
          onChange={handleOptionChange}
        />
        <label htmlFor="multiCity">Multi-City</label>
      </nav>
      <div>
        {selectedOption === "oneWay" && (
          <OneWay ApplyForformData={ApplyForformData} />
        )}
        {selectedOption === "roundTrip" && (
          <RoundTrip ApplyForformData={ApplyForformData} />
        )}
        {selectedOption === "multiCity" && (
          <MultiCity ApplyForformData={ApplyForformData} />
        )}
      </div>
    </div>
  );
};

export default TravelOption;
