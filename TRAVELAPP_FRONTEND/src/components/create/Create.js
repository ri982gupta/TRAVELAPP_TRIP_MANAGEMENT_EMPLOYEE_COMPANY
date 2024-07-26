import {
  BrowserRouter as Router,
  Route,
  Routes,
  Outlet,
} from "react-router-dom";
import React, { useState, useEffect } from "react";
import Status from "./Status";
import "../../style/create.css";
import ApplyFor from "./ApplyFor";
import Apply from "./Apply";
import ApplyNav from "./ApplyNav";
import ExcelViewComponent from "./ExcelView";
import TravelOption from "./TravelOption";
import { useLocation } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Create() {
  const [showshowtoast, setshowshowtoast] = useState(false);
  const [selectedOption, setSelectedOption] = useState("oneWay");

  const [formData, setFormData] = useState({
    dateOfTravel: "",
    travelFor: "business",
    project: "",
    businessUnit: "",
    organisation: "",
    trip: "",
    tripDescription: "",
    location: "domestic",
    foreignExchange: "",
    applyFor: "self",
    other: "",
    travelId: "",
  });

  return (
    <div>
      <Status></Status>
      <ApplyFor formData={formData} setFormData={setFormData}></ApplyFor>
      <TravelOption
        selectedOption={selectedOption}
        setSelectedOption={setSelectedOption}
        ApplyForformData={formData}
      />
      <Outlet></Outlet>
    </div>
  );
}

export default Create;
