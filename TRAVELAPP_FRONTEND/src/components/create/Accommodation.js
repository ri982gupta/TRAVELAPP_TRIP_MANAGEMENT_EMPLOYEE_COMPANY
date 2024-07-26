import React, { useState } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import "../../style/accommodation.css";

const Accommodation = () => {
  const [travels, setTravels] = useState([]);

  const onAddTravel = () => {
    setTravels((prevTravels) => [
      ...prevTravels,
      { city: "", checkin: "", checkout: "", members: "" },
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
    <div className="accommodationcontainer">
      <h2>Accommodation</h2>
      <div className="Accommodationinitialattributes">
        <div className="row mb-1">
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              {" "}
              <button className="btn btn-primary" onClick={onAddTravel}>
                <AddIcon />
              </button>
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              {" "}
              <span className="col-1 p-0">City</span>
              <input type="text" className="form-control" placeholder="City" />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              {" "}
              <span className="col-5 p-0">Check-In</span>
              <input
                type="date"
                className="form-control"
                placeholder="Check-In Date"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              {" "}
              <span className="col-5 p-0">Check-Out</span>
              <input
                type="date"
                className="form-control"
                placeholder="Check-Out Date"
              />
            </div>
          </div>
        </div>
      </div>

      {travels.map((travel, index) => (
        <div className="row mb-3" key={index}>
          <div className="col-md-2 mb-1">
            <div className="accommodationinput"></div>
            <button
              className="btn btn-danger"
              onClick={() => onDeleteTravel(index)}
            >
              <DeleteIcon />
            </button>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              <input type="text" className="form-control" placeholder="City" />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              <input
                type="date"
                className="form-control"
                placeholder="Check-In Date"
              />
            </div>
          </div>
          <div className="col-md-2 mb-2">
            <div className="accommodationinput">
              <input
                type="date"
                className="form-control"
                placeholder="Check-Out Date"
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

export default Accommodation;
