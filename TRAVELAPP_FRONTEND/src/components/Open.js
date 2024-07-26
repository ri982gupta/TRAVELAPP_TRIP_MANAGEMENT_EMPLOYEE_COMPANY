import React, { useState } from "react";
import axios from "axios";
import { FaSearch } from "react-icons/fa";
import { Link } from "react-router-dom";

const Open = () => {
  const [travelData, setTravelData] = useState([]);
  const [openTravelId, setOpenTravelId] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(20);

  const handleOpen = async () => {
    try {
      const response = await axios.get(
        `http://localhost:9004/applyForFormData/byTravelId/${openTravelId}`
      );
      setTravelData(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = travelData.slice(indexOfFirstItem, indexOfLastItem);

  const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(travelData.length / itemsPerPage); i++) {
    pageNumbers.push(i);
  }

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <div>
      <div
        className="pageTitle"
        style={{
          border: "1px solid #ccc",
          height: "40px",
          backgroundColor: "#f7f8f9",
          color: "#ffffff",
          padding: "10px",
          marginBottom: "20px",
        }}
      >
        <div className="childOne"></div>
        <div className="childTwo">
          <h2 style={{ fontSize: "20px", margin: 0, color: "#295bac" }}>
            Travel Search Details
          </h2>
        </div>
        <div className="childThree"></div>
      </div>
      <div className="group mb-3 customCard">
        <div className="group-content row">
          <div className="col-md-6 mb-2">
            <div className="form-group row align-items-center">
              <label className="col-3" htmlFor="travelId">
                Search by Travel ID:
              </label>

              <div className="col-6">
                <input
                  type="text"
                  id="travelId"
                  value={openTravelId}
                  onChange={(e) => setOpenTravelId(e.target.value)}
                  className="form-control"
                  placeholder="Enter Travel ID"
                />
              </div>

              <div className="col-2">
                <button
                  type="button"
                  className="btn btn-primary"
                  title="Search"
                  onClick={handleOpen}
                  style={{ backgroundColor: "#06b6d4", borderColor: "#06b6d4" }}
                >
                  <FaSearch /> Search
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <table
          style={{
            width: "calc(99% - 8px)",
            borderCollapse: "collapse",
            marginLeft: "0.5%",
            tableLayout: "fixed",
            backgroundColor: "#e9ecef",
            fontSize: "0.9rem",
            border: "1px solid #ccc",
            borderRadius: "5px",
          }}
        >
          <thead>
            <tr>
              <th
                style={{
                  width: "2%",
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                S.No.
              </th>
              <th
                style={{
                  width: "14.28%",
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Travel_ID
              </th>
              <th
                style={{
                  width: "14.28%",
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Date_of_travel
              </th>
              <th
                style={{
                  width: "14.28%",
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Trip_Description
              </th>
              <th
                style={{
                  width: "14.28%",
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Status
              </th>
            </tr>
          </thead>
          <tbody>
            {travelData.length === 0 ? (
              <tr>
                <td colSpan="3">No results</td>
              </tr>
            ) : (
              currentItems.map((travel, index) => (
                <tr key={index}>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {index + 1}
                  </td>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.travelId !== null ? travel.travelId : "-"}
                  </td>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.dateOfTravel !== null ? travel.dateOfTravel : "-"}
                  </td>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.tripDescription !== null
                      ? travel.tripDescription
                      : "-"}
                  </td>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                    }}
                  >
                    {travel.approvalStatus ? travel.approvalStatus : "Pending"}
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Open;
