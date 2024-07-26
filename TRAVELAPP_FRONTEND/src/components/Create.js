// import React from "react";

// import { useState } from "react";
// import BookingForm from "./BookingForm";
// import "../style/create.css";
// import Travel from "./create/Travel";

// import { toast, ToastContainer } from "react-toastify";
// import "react-toastify/dist/ReactToastify.css";

// const Create = () => {
//   const [showshowtoast, setshowshowtoast] = useState(false);
//   const [showFormDomestic, setShowFormDomestic] = useState(false);
//   const [showFormInternational, setShowFormInternational] = useState(false);
//   const [showFormhotel, setShowFormhotel] = useState(false);

//   const [travelFor, setTravelFor] = useState("business");
//   const [applyfor, setapplyfor] = useState("self");

//   if (showshowtoast == true) {
//     toast("Data Saved successfully");
//     setshowshowtoast(!showshowtoast);
//   }

//   const [formData, setFormData] = useState({
//     dateOfTravel: "",
//     travelFor: "",
//     project: "",
//     businessUnit: "",
//     organisation: "",
//     trip: "",
//     tripDescription: "",
//     location: "",
//     applyFor: "",
//     other: "",
//   });

//   const handleInputChange = (name, value) => {
//     setFormData((prevData) => ({
//       ...prevData,
//       [name]: value,
//     }));
//   };

//   // const saveData = async () => {
//   //   try {
//   //     console.log();
//   //     //   const response = await fetch('https://your-api-endpoint.com/save-data', {
//   //     const response = await fetch(
//   //       "https://localhost:9004/api/travel-requests/save",
//   //       {
//   //         method: "POST",
//   //         headers: {
//   //           "Content-Type": "application/json",
//   //         },
//   //         body: JSON.stringify(formData),
//   //       }
//   //     );

//   //     if (response.ok) {
//   //       toast("Data Saved successfully");
//   //       setshowshowtoast(!showshowtoast);
//   //     } else {
//   //       toast("Error saving data");
//   //     }
//   //   } catch (error) {
//   //     console.error("Error:", error);
//   //     toast("Error saving data");
//   //   }
//   // };

//   // const saveData = async () => {
//   //   try {
//   //     const response = await fetch("http://localhost:9004/api/travel-requests/save", {
//   //       method: "POST",
//   //       headers: {
//   //         "Content-Type": "application/json",
//   //       },
//   //       body: JSON.stringify(formData),
//   //     });
  
//   //     if (response.ok) {
//   //       toast("Data Saved successfully");
//   //       setshowshowtoast(true);
//   //       // Clear form data after successful submission
//   //       setFormData({
//   //         dateOfTravel: "",
//   //         travelFor: "",
//   //         project: "",
//   //         businessUnit: "",
//   //         organisation: "",
//   //         trip: "",
//   //         tripDescription: "",
//   //         location: "",
//   //         applyFor: "",
//   //         other: "",
//   //       });
//   //     } else {
//   //       toast("Error saving data");
//   //     }
//   //   } catch (error) {
//   //     console.error("Error:", error);
//   //     toast("Error saving data");
//   //   }
//   // };

//   const saveData = async () => {
//     try {
//       const response = await fetch("http://localhost:9004/api/data_travel-requests/save", {
//         method: "POST",
//         headers: {
//           "Content-Type": "application/json",
//         },
//         body: JSON.stringify(formData), // Send form data as JSON string
//       });
  
//       if (response.ok) {
//         toast("Data Saved successfully");
//         // Clear form data after successful submission
//         setFormData({
//           dateOfTravel: "",
//           travelFor: "",
//           project: "",
//           businessUnit: "",
//           organisation: "",
//           trip: "",
//           tripDescription: "",
//           location: "",
//           applyFor: "",
//           other: "",
//         });
//       } else {
//         toast("Error saving data");
//       }
//     } catch (error) {
//       console.error("Error:", error);
//       toast("Error saving data");
//     }
//   };
  
  

//   const toggleFormDomestic = () => {
//     setShowFormDomestic(!showFormDomestic);
//     setShowFormInternational(false);
//     setShowFormhotel(false);
//   };
//   const toggleFormInternational = () => {
//     setShowFormDomestic(false);
//     setShowFormInternational(!showFormInternational);
//     setShowFormhotel(false);
//   };
//   const toggleFormhotel = () => {
//     setShowFormDomestic(false);
//     setShowFormInternational(false);
//     setShowFormhotel(!showFormhotel);
//   };

//   const [isPopUpVisible, setPopUpVisible] = useState(false);

//   const handleButtonClick = () => {
//     setPopUpVisible(true);
//   };

//   const closePopUp = () => {
//     setPopUpVisible(false);
//   };

//   const [travels, setTravels] = useState([
//     { fromCity: "", toCity: "", fromDate: "", toDate: "", mode: "" },
//   ]);

//   const handleAddTravel = (index) => {
//     const newTravels = [...travels];
//     newTravels.splice(index + 1, 0, {
//       fromCity: "",
//       toCity: "",
//       fromDate: "",
//       toDate: "",
//       mode: "",
//     });
//     setTravels(newTravels);
//   };

//   const handleDeleteTravel = (index) => {
//     const newTravels = [...travels];
//     newTravels.splice(index, 1);
//     setTravels(newTravels);
//   };

//   return (
//     <div className="create">
//       {/* <Domestic data="jhcsdgfu"/> */}
//       <div className="row">
//         <div className="status-container">
//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#cccccc"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//               style={{ color: "rgb(204, 204, 204)" }}
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Submitted
//           </span>

//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#e54c53"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Rejected
//           </span>

//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#CDE6FE"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Approved
//           </span>
//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#0080ff"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Approved To Pay
//           </span>
//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#D9FBB3"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Paid
//           </span>
//           <span className="status">
//             <svg
//               stroke="currentColor"
//               fill="currentColor"
//               strokeWidth="0"
//               viewBox="0 0 16 16"
//               color="#009933"
//               height="12"
//               width="12"
//               xmlns="http://www.w3.org/2000/svg"
//             >
//               <circle cx="8" cy="8" r="8"></circle>
//             </svg>
//             Received
//           </span>

//           {/* Repeat the pattern for other status types */}
//         </div>
//       </div>
//       <div className="upper-container">
//         <div>
//           <div className="row">
//             {/* Date Picker */}
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="date-input">
//                   Date of Travel :
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <div className="col-6">
//                   <div>
//                     <div>
//                       <input
//                         type="date"
//                         id="date-input"
//                         placeholder="Billing Start Date"
//                         className="form-control"
//                       />
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             </div>

//             {/* Travel For Input */}
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="travel-input">
//                   Travel For :
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select
//                   name="travel-input"
//                   id="travel-input"
//                   className="col-6"
//                   onChange={(e) => setTravelFor(e.target.value)}
//                 >
//                   <option value="business">Business unit</option>
//                   <option value="project">Project</option>
//                   <option value="organisation">Organisation</option>
//                 </select>
//               </div>
//             </div>

//             {/* Project Input */}
//             {travelFor === "project" && (
//               <div className="col-md-3 mb-2">
//                 <div className="form-group row">
//                   <label className="col-5" htmlFor="project">
//                     Project
//                   </label>
//                   <span className="col-1 p-0">:</span>
//                   <select name="project" id="project" className="col-6">
//                     <option value="innovation">"Please select"</option>
//                     <option value="innovation">Innovation</option>
//                     <option value="development">Development</option>
//                     <option value="research">Research</option>
//                   </select>
//                 </div>
//               </div>
//             )}

//             {/* Business Input */}
//             {travelFor === "business" && (
//               <div className="col-md-3 mb-2">
//                 <div className="form-group row">
//                   <label className="col-5" htmlFor="business">
//                     Business unit
//                   </label>
//                   <span className="col-1 p-0">:</span>
//                   <select name="business" id="business" className="col-6">
//                     <option value="innovation">"Please select"</option>
//                     <option value="client">client</option>
//                   </select>
//                 </div>
//               </div>
//             )}

//             {/* Organisation Input */}
//             {travelFor === "organisation" && (
//               <div className="col-md-3 mb-2">
//                 <div className="form-group row">
//                   <label className="col-5" htmlFor="organisation">
//                     organisation
//                   </label>
//                   <span className="col-1 p-0">:</span>
//                   <select
//                     name="organisation"
//                     id="organisation"
//                     className="col-6"
//                   >
//                     <option value="innovation">"Please select"</option>
//                     <option value="organisation">organisation</option>
//                   </select>
//                 </div>
//               </div>
//             )}

//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="trip">
//                   Trip
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <div className="col-6">
//                   <div>
//                     <div>
//                       <input type="text" id="trip" className="form-control" />
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             </div>
//           </div>
//           <div className="row">
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="trip-desc">
//                   Trip Description
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <div className="col-6">
//                   <div>
//                     <div>
//                       <input
//                         type="text"
//                         id="trip-desc"
//                         className="form-control"
//                         placeholder="type"
//                       />
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             </div>

//             {/* {Domestic/International} */}
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="location">
//                   Travel
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select name="location" id="location" className="col-6">
//                   <option value="domestic">Domestic</option>
//                   <option value="international">international</option>
//                 </select>
//               </div>
//             </div>

//             {/* self/others */}
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="for">
//                   Apply For
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select
//                   name="for"
//                   id="for"
//                   className="col-6"
//                   onChange={(e) => setapplyfor(e.target.value)}
//                 >
//                   <option value="self">Self</option>
//                   <option value="other">Other</option>
//                 </select>
//               </div>
//             </div>

//             {/* Apply forOthers */}
//             {applyfor === "other" && (
//               <div className="col-md-3 mb-2">
//                 <div className="form-group row">
//                   <label className="col-5" htmlFor="other">
//                     Other
//                   </label>
//                   <span className="col-1 p-0">:</span>
//                   <div className="col-6">
//                     <div>
//                       <div>
//                         <input
//                           type="text"
//                           id="other"
//                           className="form-control"
//                           placeholder="name"
//                         />
//                       </div>
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             )}
//           </div>
//         </div>
//       </div>

//       <div
//         className="row"
//         style={{ margin: "20px 20px", background: "rgb(215, 228, 238)" }}
//       >
//         <div className="col-md-3 mb-2">
//           <button
//             type="button"
//             className="btn btn-primary"
//             onClick={toggleFormDomestic}
//           >
//             Travel
//           </button>
//           {/* {showFormDomestic && <Domestic showshowtoast={showshowtoast} setshowshowtoast={setshowshowtoast} showFormDomestic={showFormDomestic} setShowFormDomestic={setShowFormDomestic}  />} */}
//         </div>
//         <div className="col-md-3 mb-2">
//           <button
//             type="button"
//             className="btn btn-primary"
//             onClick={toggleFormInternational}
//           >
//             Accommodation
//           </button>
//           {/* {showFormInternational && <International showshowtoast={showshowtoast} setshowshowtoast={setshowshowtoast} showFormInternational={showFormInternational} setShowFormInternational={setShowFormInternational} />} */}
//         </div>
//         <div className="col-md-3 mb-2">
//           <button
//             type="button"
//             className="btn btn-primary"
//             onClick={toggleFormhotel}
//           >
//             Travel+Accommodation
//           </button>
//           {/* {showFormhotel && <BookingForm showshowtoast={showshowtoast} setshowshowtoast={setshowshowtoast} showFormhotel={showFormhotel} setShowFormhotel={setShowFormhotel} />} */}
//         </div>
//         <div>
//           {/* <button onClick={notify}>Notify!</button> */}

//           {showFormDomestic && (
//             <Travel
//               onAddTravel={handleAddTravel}
//               onDeleteTravel={handleDeleteTravel}
//               showshowtoast={showshowtoast}
//               setshowshowtoast={setshowshowtoast}
//               showFormDomestic={showFormDomestic}
//               setShowFormDomestic={setShowFormDomestic}
//             />
//           )}
//           {/* {showFormInternational && <International showshowtoast={showshowtoast} setshowshowtoast={setshowshowtoast} showFormInternational={showFormInternational} setShowFormInternational={setShowFormInternational} />}
//                     {showFormhotel && <BookingForm showshowtoast={showshowtoast} setshowshowtoast={setshowshowtoast} showFormhotel={showFormhotel} setShowFormhotel={setShowFormhotel} />} */}
//           {<ToastContainer />}
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Create;
