import React, { useState } from "react";
import FlightIcon from "@mui/icons-material/Flight";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import "../../style/travel.css";

const Travel = () => {
  const [travels, setTravels] = useState([]);
  const [oneWay, setOneWay] = useState("yes");

  const onAddTravel = () => {
    setTravels((prevTravels) => [
      ...prevTravels,
      { fromCity: "", toCity: "", fromDate: "", toDate: "", mode: "" },
    ]);
  };

  const onDeleteTravel = (index) => {
    setTravels((prevTravels) => {
      const updatedTravels = [...prevTravels];
      updatedTravels.splice(index, 1);
      return updatedTravels;
    });
  };

  return (
    <div style={{ background: "rgb(215, 228, 238)" }} className="Travel">
      <div className="Traveloptionway">
        <h2>Travel </h2>
       

        <span className="onewayspan">One Way</span>
        <div className="form-check form-check-inline">
          <input
            className="form-check-input"
            type="radio"
            name="oneWay"
            id="yes"
            value="yes"
            checked={oneWay === "yes"}
            onChange={() => setOneWay("yes")}
          />
          <label className="form-check-label" htmlFor="yes">
            Yes
          </label>
        </div>
        <div className="form-check form-check-inline">
          <input
            className="form-check-input"
            type="radio"
            name="oneWay"
            id="no"
            value="no"
            checked={oneWay === "no"}
            onChange={() => setOneWay("no")}
          />
          <label className="form-check-label" htmlFor="no">
            No
          </label>
        </div>
      </div>

      <div className="initialattributes">
        <div className="row mb-1">
        
          <div className="col-md-2 mb-2">
            <button
              className="btn btn-primary"
              onClick={onAddTravel}
              disabled={oneWay === "yes"}
            >
              <AddIcon />
            </button>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <span className="col-1 p-0">FROM</span>
              <input
                type="text"
                className="form-control"
                placeholder="From City"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <span className="col-1 p-0">TO</span>
              <input
                type="text"
                className="form-control"
                placeholder="To City"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <span className="col-1 p-0">Departure</span>
              <input
                type="date"
                className="form-control"
                placeholder="From Date"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <span className="col-1 p-0">Return</span>
              <input
                type="date"
                className="form-control"
                placeholder="To Date"
                disabled={oneWay === "yes"}
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <span className="col-5 p-0">Mode of Travel</span>
              <input
                type="text"
                className="form-control"
                placeholder="Mode of Travel"
              />
            </div>
          </div>
        </div>
      </div>

    
      {travels.map((travel, index) => (
        <div className="row mb-3" key={index}>
          <div className="col-md-2 mb-1">
            <button
              className="btn btn-danger"
              onClick={() => onDeleteTravel(index)}
            >
              <DeleteIcon />
            </button>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              {" "}
              <input
                type="text"
                className="form-control"
                placeholder="From City"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              {" "}
              <input
                type="text"
                className="form-control"
                placeholder="To City"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              {" "}
              <input
                type="date"
                className="form-control"
                placeholder="From Date"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              <input
                type="date"
                className="form-control"
                placeholder="To Date"
                disabled={oneWay === "yes"}
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="travelinput">
              {" "}
              <input
                type="text"
                className="form-control"
                placeholder="Mode of Travel"
              />
            </div>
          </div>
        </div>
      ))}
      <div className="text-center">
        <button className="btn btn-primary">Submit</button>
      </div>
    </div>
  );
};

export default Travel;
