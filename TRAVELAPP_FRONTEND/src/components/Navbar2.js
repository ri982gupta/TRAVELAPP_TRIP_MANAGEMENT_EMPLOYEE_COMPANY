import React from "react";
import { FaUser } from "react-icons/fa";

const Navbar2 = () => {
  return (
    <div>
      <nav
        class="navbar navbar-expand-sm navbar-dark "
        style={{ background: "#CDE6FE" }}
      >
        <div class="container-fluid">
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#mynavbar"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="collapse navbar-collapse"
            id="mynavbar"
            style={{ color: "black" }}
          >
            <ul class="navbar-nav me-auto">
              <li class="nav-item">
                <a class="nav-link" href="/open" style={{ color: "black" }}>
                  open
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/search" style={{ color: "black" }}>
                  Search
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/create" style={{ color: "black" }}>
                  Create
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/view" style={{ color: "black" }}>
                  view
                </a>
              </li>
            </ul>
          </div>
          <h3 style={{ marginRight: "20px" }}>Travel</h3>{" "}
          <div className="navbar-nav">
            <li className="nav-item">
              <a
                className="nav-link"
                href="/profile"
                style={{ color: "black" }}
              >
                <FaUser size={24} />
              </a>
            </li>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default Navbar2;
