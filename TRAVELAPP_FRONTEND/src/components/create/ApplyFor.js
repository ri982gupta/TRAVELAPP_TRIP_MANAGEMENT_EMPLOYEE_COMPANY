import React, { useState } from "react";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import OneWay from "./pages/OneWay";
import "../../style/ApplyFor.css";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";

//----------------------------------WITHOUT APPROVAL STATUS AND TRAVEL ID------------------------------

// const ApplyFor = ({ formData, setFormData }) => {
//   const handleInputChange = (name, value) => {
//     setFormData((prevData) => ({
//       ...prevData,
//       [name]: value,
//     }));
//   };

// -------------------------------- WITH APPROVAL STATUS AND GENRATE TRAVEL ID  ------------------------

const ApplyFor = ({ formData, setFormData }) => {
  // Initialize travelId when the component mounts
  useEffect(() => {
    setFormData((prevData) => ({
      ...prevData,
      travelId: generateTravelId(), // Generate the initial travelId
    }));
  }, []); // Empty dependency array ensures this effect runs only once, when the component mounts

  //GENERATE FOUR DIGIT TRAVEL ID

  const generateTravelId = () => {
    return Math.floor(1000 + Math.random() * 9000);
  };

  // APPROVAL IS DONE BY EMAIL

  // Replace 'specificEmail' with the email ID you want to enable the input for
  const specificEmail = "richagupta123.iimt@gmail.com";

  const currentUserEmail = "richagupta123.iimt@gmail.com"; // Set the current user's email here

  const handleInputChange = (name, value) => {
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  //----------------------------------------------------------------------------------------------------

  return (
    <div className="Applyfor">
      <div className="Applyfor-upper-container">
        <div className="Applyfor-input">
          <div className="row">
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="date-input">
                  Date of Travel
                </label>
                <span className="col-1 p-0">:</span>
                <div className="col-6">
                  <input
                    type="date"
                    id="date-input"
                    className="form-control"
                    min={new Date().toJSON().slice(0, 10)}
                    value={formData.dateOfTravel}
                    onChange={(e) =>
                      handleInputChange("dateOfTravel", e.target.value)
                    }
                  />
                </div>
              </div>
            </div>
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="travel-input">
                  Travel For
                </label>
                <span className="col-1 p-0">:</span>
                <select
                  name="travel-input"
                  id="travel-input"
                  className="col-6"
                  value={formData.travelFor}
                  onChange={(e) =>
                    handleInputChange("travelFor", e.target.value)
                  }
                >
                  <option value="business">Business unit</option>
                  <option value="project">Project</option>
                  <option value="organisation">Organisation</option>
                </select>
              </div>
            </div>
            {formData.travelFor === "project" && (
              <div className="col-md-3 mb-2">
                <div className="form-group row">
                  <label className="col-5" htmlFor="project">
                    Project
                  </label>
                  <span className="col-1 p-0">:</span>
                  <select
                    name="project"
                    id="project"
                    className="col-6"
                    value={formData.project}
                    onChange={(e) =>
                      handleInputChange("project", e.target.value)
                    }
                  >
                    <option value="innovation">Innovation</option>
                    <option value="development">Development</option>
                    <option value="research">Research</option>
                  </select>
                </div>
              </div>
            )}
            {formData.travelFor === "business" && (
              <div className="col-md-3 mb-2">
                <div className="form-group row">
                  <label className="col-5" htmlFor="business">
                    Business unit
                  </label>
                  <span className="col-1 p-0">:</span>
                  <select
                    name="business"
                    id="business"
                    className="col-6"
                    value={formData.businessUnit}
                    onChange={(e) =>
                      handleInputChange("businessUnit", e.target.value)
                    }
                  >
                    <option value="innovation">"Please select"</option>
                    <option value="client">client</option>
                  </select>
                </div>
              </div>
            )}
            {formData.travelFor === "organisation" && (
              <div className="col-md-3 mb-2">
                <div className="form-group row">
                  <label className="col-5" htmlFor="organisation">
                    Organisation
                  </label>
                  <span className="col-1 p-0">:</span>
                  <select
                    name="organisation"
                    id="organisation"
                    className="col-6"
                    value={formData.organisation}
                    onChange={(e) =>
                      handleInputChange("organisation", e.target.value)
                    }
                  >
                    <option value="innovation">"Please select"</option>
                    <option value="organisation">Organisation</option>
                  </select>
                </div>
              </div>
            )}
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="trip">
                  Trip
                </label>
                <span className="col-1 p-0">:</span>
                <div className="col-6">
                  <input
                    type="text"
                    id="trip"
                    className="form-control"
                    value={formData.trip}
                    onChange={(e) => handleInputChange("trip", e.target.value)}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="trip-desc">
                  Trip Description
                </label>
                <span className="col-1 p-0">:</span>
                <div className="col-6">
                  <input
                    type="text"
                    id="trip-desc"
                    className="form-control"
                    placeholder="type"
                    value={formData.tripDescription}
                    onChange={(e) =>
                      handleInputChange("tripDescription", e.target.value)
                    }
                  />
                </div>
              </div>
            </div>
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="location">
                  Travel
                </label>
                <span className="col-1 p-0">:</span>
                <select
                  name="location"
                  id="location"
                  className="col-6"
                  value={formData.location}
                  onChange={(e) =>
                    handleInputChange("location", e.target.value)
                  }
                >
                  <option value="domestic">Domestic</option>
                  <option value="international">International</option>
                </select>
              </div>
            </div>
            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="for">
                  Apply For
                </label>
                <span className="col-1 p-0">:</span>
                <select
                  name="for"
                  id="for"
                  className="col-6"
                  value={formData.applyFor}
                  onChange={(e) =>
                    handleInputChange("applyFor", e.target.value)
                  }
                >
                  <option value="self">Self</option>
                  <option value="other">Other</option>
                </select>
              </div>
            </div>

            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="travelId">
                  Travel ID
                </label>
                <span className="col-1 p-0">:</span>
                <div className="col-6">
                  <input
                    type="text"
                    id="travelId"
                    className="form-control"
                    value={formData.travelId}
                    onChange={(e) =>
                      handleInputChange("travelId", e.target.value)
                    }
                    //readOnly // Make it read-only so users can't modify it
                  />
                </div>
              </div>
            </div>

            <div className="col-md-3 mb-2">
              <div className="form-group row">
                <label className="col-5" htmlFor="approvalStatus">
                  Approval Status
                </label>
                <span className="col-1 p-0">:</span>
                <div className="col-6">
                  <input
                    type="text"
                    id="approvalStatus"
                    className="form-control"
                    value={formData.approvalStatus}
                    onChange={(e) =>
                      handleInputChange("approvalStatus", e.target.value)
                    }
                    disabled
                    //disabled={currentUserEmail !== specificEmail}
                  />
                </div>
              </div>
            </div>

            {formData.location === "international" && (
              <div className="col-md-3 mb-2">
                <div className="form-group row">
                  <label className="col-5" htmlFor="foreignExchange">
                    Foreign Exchange
                  </label>
                  <span className="col-1 p-0">:</span>
                  <div className="col-6">
                    <input
                      type="text"
                      id="foreignExchange"
                      className="form-control"
                      value={formData.foreignExchange}
                      placeholder="Foreign Exchange"
                      onChange={(e) =>
                        handleInputChange("foreignExchange", e.target.value)
                      }
                    />
                  </div>
                </div>
              </div>
            )}
            {formData.applyFor === "other" && (
              <div className="col-md-3 mb-2">
                <div className="form-group row">
                  <label className="col-5" htmlFor="other">
                    Other
                  </label>
                  <span className="col-1 p-0">:</span>
                  <div className="col-6">
                    <input
                      type="text"
                      id="other"
                      className="form-control"
                      placeholder="name"
                      value={formData.other}
                      onChange={(e) =>
                        handleInputChange("other", e.target.value)
                      }
                    />
                  </div>
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ApplyFor;
