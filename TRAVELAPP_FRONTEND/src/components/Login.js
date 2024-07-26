//---------------------------------LOGIN USING EMAIL AND PASSWORD-----------------------------------------


// import React, { useState } from "react";
// import "../style/Login.css";
// import { loginAPI } from "../api/api";

// const Login = () => {
//   let [authMode, setAuthMode] = useState("signin");

//   const changeAuthMode = () => {
//     setAuthMode(authMode === "signin" ? "signup" : "signin");
//   };

//   const [email, setemail] = useState("");
//   const [password, setpassword] = useState("");

//   const handleSubmit = () => {
//     const data = { email, password };
//     loginAPI(data);
//   };

//   if (authMode === "signin") {
//     return (
//       <div className="Auth-form-container">
//         <form className="Auth-form">
//           <div className="Auth-form-content">
//             <h3 className="Auth-form-title">Sign In</h3>

//             <div className="form-group mt-3">
//               <label>Email address</label>
//               <input
//                 type="email"
//                 className="form-control mt-1"
//                 placeholder="Enter email"
//               />
//             </div>
//             <div className="form-group mt-3">
//               <label>Password</label>
//               <input
//                 type="password"
//                 className="form-control mt-1"
//                 placeholder="Enter password"
//               />
//             </div>
//             <div className="d-grid gap-2 mt-3">
//               <button
//                 type="submit"
//                 className="btn btn-primary"
//                 onClick={handleSubmit}
//               >
//                 Submit
//               </button>
//             </div>
//             <p className="text-center mt-2">
//               Forgot <a href="#">password?</a>
//             </p>
//           </div>
//         </form>
//       </div>
//     );
//   }
// };

// export default Login;


//------------------------------------------LOGIN USING EMAIL PASSWORD EMPID-----------------------------------------


// import React, { useState } from "react";
// import "../style/Login.css";
// import { loginAPI } from "../api/api";

// const Login = () => {
//   let [authMode, setAuthMode] = useState("signin");

//   const changeAuthMode = () => {
//     setAuthMode(authMode === "signin" ? "signup" : "signin");
//   };

//   const [email, setEmail] = useState("");
//   const [password, setPassword] = useState("");
//   const [empId, setEmpId] = useState("");

//   const handleSubmit = () => {
//     const data = { email, password, empId };
//     loginAPI(data)
//       .then(() => {
//         // Redirect to "/search" after successful login
//         window.location.href = "/search";
//       })
//       .catch((error) => {
//         console.error("Login failed:", error);
//       });
//   };

//   if (authMode === "signin") {
//     return (
//       <div className="Auth-form-container">
//         <form className="Auth-form">
//           <div className="Auth-form-content">
//             <h3 className="Auth-form-title">Sign In</h3>

//             <div className="form-group mt-3">
//               <label>Email address</label>
//               <input
//                 type="email"
//                 className="form-control mt-1"
//                 placeholder="Enter email"
//                 value={email}
//                 onChange={(e) => setEmail(e.target.value)}
//               />
//             </div>
//             <div className="form-group mt-3">
//               <label>Password</label>
//               <input
//                 type="password"
//                 className="form-control mt-1"
//                 placeholder="Enter password"
//                 value={password}
//                 onChange={(e) => setPassword(e.target.value)}
//               />
//             </div>
//             <div className="form-group mt-3">
//               <label>Employee ID</label>
//               <input
//                 type="text"
//                 className="form-control mt-1"
//                 placeholder="Enter Employee ID"
//                 value={empId}
//                 onChange={(e) => setEmpId(e.target.value)}
//               />
//             </div>
//             <div className="d-grid gap-2 mt-3">
//               <button
//                 type="button" // Change type to "button" to prevent form submission
//                 className="btn btn-primary"
//                 onClick={handleSubmit}
//               >
//                 Submit
//               </button>
//             </div>
//             <p className="text-center mt-2">
//               Forgot <a href="#">password?</a>
//             </p>
//           </div>
//         </form>
//       </div>
//     );
//   }
// };

// export default Login;


