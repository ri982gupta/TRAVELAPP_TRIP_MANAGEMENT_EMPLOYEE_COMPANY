import React, { useState } from "react";
import FlightIcon from "@mui/icons-material/Flight";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import "../../style/TravelandAccommodation.css";

const TravelandAccommodation = () => {
  const [travels, setTravels] = useState([]);

  const onAddTravel = () => {
    setTravels((prevTravels) => [
      ...prevTravels,
      {
        fromCity: "",
        toCity: "",
        fromDate: "",
        toDate: "",
        mode: "",
        stayingCity: "",
        checkIn: "",
        checkOut: "",
      },
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
    <div className="TravelandAccommodationcontainer">
      <h2>Travel and Accommodation </h2>
      <div className="TravelandAccommodationattributes">
        <div className="row mb-1">
          <div className="col-md-2 mb-2">
            <button className="btn btn-primary" onClick={onAddTravel}>
              <AddIcon />
            </button>
          </div>
          <div className="col-md-1 mb-2">
            <div className="TravelandAccommodationinput">
              <span className="col-1 p-0">FROM</span>
              <input
                type="text"
                className="form-control"
                placeholder="From City"
              />
            </div>
          </div>
          <div className="col-md-1 mb-1">
            <div className="TravelandAccommodationinput">
              <span className="col-1 p-0">TO</span>
              <input
                type="text"
                className="form-control"
                placeholder="To City"
              />
            </div>
          </div>
          <div className="col-md-1 mb-1">
            <div className="TravelandAccommodationinput">
              {" "}
              <span className="col-1 p-0">Departure</span>
              <input
                type="date"
                className="form-control"
                placeholder="From Date"
              />
            </div>
          </div>
          <div className="col-md-1 mb-1">
            <div className="TravelandAccommodationinput">
              <span className="col-1 p-0">Return</span>
              <input
                type="date"
                className="form-control"
                placeholder="To Date"
              />
            </div>
          </div>
          <div className="col-md-1 mb-2">
            <div className="TravelandAccommodationinput">
              <span className="col-15 p-0">Mode Of Travel</span>
              <input
                type="text"
                className="form-control"
                placeholder="Mode of Travel"
              />
            </div>
          </div>
          <div className="col-md-1 mb-2">
            <div className="TravelandAccommodationinput">
              {" "}
              <span className="col-15 p-0">Staying City</span>
              <input
                type="text"
                className="form-control"
                placeholder="Staying City"
              />
            </div>
          </div>
          <div className="col-md-1 mb-1">
            <div className="TravelandAccommodationinput">
              {" "}
              <span className="col-15 p-0">Check In</span>
              <input
                type="date"
                className="form-control"
                placeholder="Check In Date"
              />
            </div>
          </div>
          <div className="col-md-1 mb-1">
            <div className="TravelandAccommodationinput">
              {" "}
              <span className="col-15 p-0">Check Out</span>
              <input
                type="date"
                className="form-control"
                placeholder="Check Out Date"
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
            <input
              type="text"
              className="form-control"
              placeholder="From City"
            />
          </div>
          <div className="col-md-2 mb-2">
            <input type="text" className="form-control" placeholder="To City" />
          </div>
          <div className="col-md-2 mb-2">
            <input
              type="date"
              className="form-control"
              placeholder="From Date"
            />
          </div>
          <div className="col-md-2 mb-2">
            <input type="date" className="form-control" placeholder="To Date" />
          </div>
          <div className="col-md-2 mb-2">
            <input
              type="text"
              className="form-control"
              placeholder="Mode of Travel"
            />
          </div>

          <div className="col-md-2 mb-2">
            <input
              type="text"
              className="form-control"
              placeholder="Staying City"
            />
          </div>
          <div className="col-md-2 mb-2">
            <input
              type="date"
              className="form-control"
              placeholder="Check In Date"
            />
          </div>
          <div className="col-md-2 mb-2">
            <input
              type="date"
              className="form-control"
              placeholder="Check Out Date"
            />
          </div>
        </div>
      ))}
      <div className="text-center">
        <button className="btn btn-primary">Submit</button>
      </div>
    </div>
  );
};

export default TravelandAccommodation;
