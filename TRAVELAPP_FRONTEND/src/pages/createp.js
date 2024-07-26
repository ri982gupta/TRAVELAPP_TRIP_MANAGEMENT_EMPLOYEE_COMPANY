// import React, { useState } from 'react';
// import Domestic from './Domestice';
// import International from './International';
// import BookingForm from './BookingForm';
// import { toast, ToastContainer } from 'react-toastify';
// import 'react-toastify/dist/ReactToastify.css';

// const Create = () => {
//   const [showshowtoast, setshowshowtoast] = useState(false);
//   const [showFormDomestic, setShowFormDomestic] = useState(false);
//   const [showFormInternational, setShowFormInternational] = useState(false);
//   const [showFormhotel, setShowFormhotel] = useState(false);

//   const [travelFor, setTravelFor] = useState('business');
//   const [applyfor, setapplyfor] = useState('self');
//   const [formData, setFormData] = useState({
//     dateOfTravel: '',
//     travelFor: '',
//     project: '',
//     businessUnit: '',
//     organisation: '',
//     trip: '',
//     tripDescription: '',
//     location: '',
//     applyFor: '',
//     other: '',
//   });

//   const handleInputChange = (name, value) => {
//     setFormData((prevData) => ({
//       ...prevData,
//       [name]: value,
//     }));
//   };

//   const saveData = async () => {
//     try {
//         console.log(formData)
//       const response = await fetch('https://your-api-endpoint.com/save-data', {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(formData),
//       });

//       if (response.ok) {
//         toast('Data Saved successfully');
//         setshowshowtoast(!showshowtoast);
//       } else {
//         toast('Error saving data');
//       }
//     } catch (error) {
//       console.error('Error:', error);
//       toast('Error saving data');
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

//   return (
//     <div className="create">
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
//               style={{ color: 'rgb(204, 204, 204)' }}
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
//           {/* Repeat for other status types */}
//         </div>
//       </div>
//       <div className="upper-container">
//         <div className="row">
//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="date-input">
//                 Date of Travel:
//               </label>
//               <span className="col-1 p-0">:</span>
//               <div className="col-6">
//                 <div>
//                   <div>
//                     <input
//                       type="date"
//                       id="date-input"
//                       placeholder="Billing Start Date"
//                       className="form-control"
//                       onChange={(e) => handleInputChange('dateOfTravel', e.target.value)}
//                     />
//                   </div>
//                 </div>
//               </div>
//             </div>
//           </div>

//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="travel-input">
//                 Travel For:
//               </label>
//               <span className="col-1 p-0">:</span>
//               <select
//                 name="travel-input"
//                 id="travel-input"
//                 className="col-6"
//                 onChange={(e) => handleInputChange('travelFor', e.target.value)}
//               >
//                 <option value="business">Business unit</option>
//                 <option value="project">Project</option>
//                 <option value="organisation">Organisation</option>
//               </select>
//             </div>
//           </div>

//           {travelFor === 'project' && (
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="project">
//                   Project
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select
//                   name="project"
//                   id="project"
//                   className="col-6"
//                   onChange={(e) => handleInputChange('project', e.target.value)}
//                 >
//                   <option value="innovation">"Please select"</option>
//                   <option value="innovation">Innovation</option>
//                   <option value="development">Development</option>
//                   <option value="research">Research</option>
//                 </select>
//               </div>
//             </div>
//           )}

//           {travelFor === 'business' && (
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="business">
//                   Business unit
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select
//                   name="business"
//                   id="business"
//                   className="col-6"
//                   onChange={(e) => handleInputChange('businessUnit', e.target.value)}
//                 >
//                   <option value="innovation">"Please select"</option>
//                   <option value="client">client</option>
//                 </select>
//               </div>
//             </div>
//           )}

//           {travelFor === 'organisation' && (
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="organisation">
//                   Organisation
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <select
//                   name="organisation"
//                   id="organisation"
//                   className="col-6"
//                   onChange={(e) => handleInputChange('organisation', e.target.value)}
//                 >
//                   <option value="innovation">"Please select"</option>
//                   <option value="organisation">Organisation</option>
//                 </select>
//               </div>
//             </div>
//           )}

//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="trip">
//                 Trip
//               </label>
//               <span className="col-1 p-0">:</span>
//               <div className="col-6">
//                 <div>
//                   <div>
//                     <input
//                       type="text"
//                       id="trip"
//                       className="form-control"
//                       onChange={(e) => handleInputChange('trip', e.target.value)}
//                     />
//                   </div>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>

//         <div className="row">
//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="trip-desc">
//                 Trip Description
//               </label>
//               <span className="col-1 p-0">:</span>
//               <div className="col-6">
//                 <div>
//                   <div>
//                     <input
//                       type="text"
//                       id="trip-desc"
//                       className="form-control"
//                       placeholder="type"
//                       onChange={(e) => handleInputChange('tripDescription', e.target.value)}
//                     />
//                   </div>
//                 </div>
//               </div>
//             </div>
//           </div>

//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="location">
//                 Travel
//               </label>
//               <span className="col-1 p-0">:</span>
//               <select
//                 name="location"
//                 id="location"
//                 className="col-6"
//                 onChange={(e) => handleInputChange('location', e.target.value)}
//               >
//                 <option value="domestic">Domestic</option>
//                 <option value="international">International</option>
//               </select>
//             </div>
//           </div>

//           <div className="col-md-3 mb-2">
//             <div className="form-group row">
//               <label className="col-5" htmlFor="for">
//                 Apply For
//               </label>
//               <span className="col-1 p-0">:</span>
//               <select
//                 name="for"
//                 id="for"
//                 className="col-6"
//                 onChange={(e) => handleInputChange('applyFor', e.target.value)}
//               >
//                 <option value="self">Self</option>
//                 <option value="other">Other</option>
//               </select>
//             </div>
//           </div>

//           {applyfor === 'other' && (
//             <div className="col-md-3 mb-2">
//               <div className="form-group row">
//                 <label className="col-5" htmlFor="other">
//                   Other
//                 </label>
//                 <span className="col-1 p-0">:</span>
//                 <div className="col-6">
//                   <div>
//                     <div>
//                       <input
//                         type="text"
//                         id="other"
//                         className="form-control"
//                         placeholder="name"
//                         onChange={(e) => handleInputChange('other', e.target.value)}
//                       />
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             </div>
//           )}
//         </div>
//       </div> 

//       <div className="col-md-3 mb-2">
//           <button type="button" className="btn btn-primary" onClick={saveData}>
//             Travel
//           </button>
//         </div>

//       <div className="row" style={{ margin: '20px 20px', background: 'rgb(215, 228, 238)' }}>
//         <div className="col-md-3 mb-2">
//           <button type="button" className="btn btn-primary" onClick={toggleFormDomestic}>
//             Travel
//           </button>
//         </div>
//         <div className="col-md-3 mb-2">
//           <button type="button" className="btn btn-primary" onClick={toggleFormInternational}>
//             Accommodation
//           </button>
//         </div>
//         <div className="col-md-3 mb-2">
//           <button type="button" className="btn btn-primary" onClick={toggleFormhotel}>
//             Travel+Accommodation
//           </button>
//         </div>
//         <div>
//           {showFormDomestic && (
//             <Domestic
//               handleInputChange={handleInputChange}
//               travelFor={travelFor}
//               applyfor={applyfor}
//               showshowtoast={showshowtoast}
//               setshowshowtoast={setshowshowtoast}
//               showFormDomestic={showFormDomestic}
//               setShowFormDomestic={setShowFormDomestic}
//             />
//           )}
//           {showFormInternational && (
//             <International
//               handleInputChange={handleInputChange}
//               travelFor={travelFor}
//               applyfor={applyfor}
//               showshowtoast={showshowtoast}
//               setshowshowtoast={setshowshowtoast}
//               showFormInternational={showFormInternational}
//               setShowFormInternational={setShowFormInternational}
//             />
//           )}
//           {showFormhotel && (
//             <BookingForm
//               handleInputChange={handleInputChange}
//               travelFor={travelFor}
//               applyfor={applyfor}
//               showshowtoast={showshowtoast}
//               setshowshowtoast={setshowshowtoast}
//               showFormhotel={showFormhotel}
//               setShowFormhotel={setShowFormhotel}
//             />
//           )}
//           {<ToastContainer />}
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Create; 





















// import React from 'react';

// const Travel = ({ travels = [], onAddTravel, onDeleteTravel }) => {
//   return (
//     <div>
//       <h2>Travel</h2>
//       <div className="row mb-3">
//         {/* Initial set of attributes */}
//         <div className="col-md-2 mb-2">
//           <input type="text" className="form-control" placeholder="From City" />
//         </div>
//         <div className="col-md-2 mb-2">
//           <input type="text" className="form-control" placeholder="To City" />
//         </div>
//         <div className="col-md-2 mb-2">
//           <input type="date" className="form-control" placeholder="From Date" />
//         </div>
//         <div className="col-md-2 mb-2">
//           <input type="date" className="form-control" placeholder="To Date" />
//         </div>
//         <div className="col-md-2 mb-2">
//           <input type="text" className="form-control" placeholder="Mode" />
//         </div>
//         <div className="col-md-2 mb-2">
//           <button className="btn btn-primary" onClick={onAddTravel}>
//             Add
//           </button>
//         </div>
//       </div>

//       {/* Dynamically rendered input fields */}
//       {travels.map((travel, index) => (
//         <div className="row mb-3" key={index}>
//           <div className="col-md-2 mb-2">
//             <input type="text" className="form-control" placeholder="From City" />
//           </div>
//           <div className="col-md-2 mb-2">
//             <input type="text" className="form-control" placeholder="To City" />
//           </div>
//           <div className="col-md-2 mb-2">
//             <input type="date" className="form-control" placeholder="From Date" />
//           </div>
//           <div className="col-md-2 mb-2">
//             <input type="date" className="form-control" placeholder="To Date" />
//           </div>
//           <div className="col-md-2 mb-2">
//             <input type="text" className="form-control" placeholder="Mode" />
//           </div>
//           <div className="col-md-2 mb-2">
//             <button className="btn btn-danger" onClick={() => onDeleteTravel(index)}>
//               Delete
//             </button>
//           </div>
//         </div>
//       ))}
//     </div>
//   );
// };

// export default Travel;

