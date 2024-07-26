import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

import Create from "./components/create/Create";
import Navbar2 from "./components/Navbar2";
import Open from "./components/Open";
import Search from "./components/search";
import Status from "./components/create/Status";
import Travel from "./components/create/Travel";
import Accommodation from "./components/create/Accommodation";
import TravelandAccommodation from "./components/create/TravelandAccommodation";
import TableView from "./components/View";
import ApplyFor from "./components/create/ApplyFor"
import Login from "./components/Login";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar2 />
        <Routes>
          <Route path="/open" element={<Open />} />
          <Route path="/search" element={<Search />} />
          <Route path="/create" element={<Create />} />
          <Route path="/view" element={<TableView />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

