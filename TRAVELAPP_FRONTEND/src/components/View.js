import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const TableView = () => {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(20);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get("http://localhost:9004/api/data/all");
      setData(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = data.slice(indexOfFirstItem, indexOfLastItem);

  const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(data.length / itemsPerPage); i++) {
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
            View Travel Details
          </h2>
        </div>
        <div className="childThree"></div>
      </div>

      <div className="w-100 mt-5 ml-4">
        <div
          className="col-md-12 childTwo"
          style={{
            border: "1px solid #ECF0F1",
            marginTop: "50px",
            backgroundColor: "#e9ecef",
            width: "calc(100% - 28px)",
            marginLeft: "10px",
            textAlign: "left",
          }}
        >
          <h6
            style={{
              color: "#02277f",
              marginLeft: "10px",
              marginTop: "2px",
            }}
          >
            Table View
          </h6>
        </div>
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
                  width: "3%",
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
                Travel_Id
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
                Type
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
                From_Location
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
                To_Location
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
                Departure
              </th>
            </tr>
          </thead>
          <tbody>
            {currentItems.map((item, index) => (
              <tr
                key={index}
                style={{
                  backgroundColor: index % 2 === 0 ? "#ffffff" : "#f2f2f2",
                  border: "1px solid #bdc3c7",
                }}
              >
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "center",
                  }}
                >
                  {index + 1 + indexOfFirstItem}
                </td>
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "center",
                  }}
                >
                  {item.travelId !== null ? item.travelId : "-"}
                </td>
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "center",
                  }}
                >
                  {item.type !== null ? item.type : "-"}
                </td>
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "left",
                  }}
                >
                  {item.from !== null ? item.from : "-"}
                </td>
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "left",
                  }}
                >
                  {item.to !== null ? item.to : "-"}
                </td>
                <td
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "5px",
                    verticalAlign: "middle",
                    textAlign: "left",
                  }}
                >
                  {item.departure !== null ? item.departure : "-"}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <ul
          style={{
            listStyleType: "none",
            display: "flex",
            justifyContent: "flex-end",
            border: "1px solid #e9ecef",
            height: "40px",
            backgroundColor: "#ffffff",
            color: "#ffffff",
            padding: "10px",
            marginBottom: "20px",
            marginLeft: "10px",
            width: "calc(100% - 28px)",
          }}
        >
          {pageNumbers.map((number, index) => (
            <li key={number} style={{ margin: "5px" }}>
              {number === 1 && (
                <span style={{ marginRight: "5px", color: "#333333" }}>
                  &#9664;
                </span>
              )}
              <a
                href="#"
                onClick={() => paginate(number)}
                style={{ textDecoration: "none", color: "#000000" }}
              >
                {number}
              </a>

              {number === 2 && (
                <span style={{ marginLeft: "5px", color: "#333333" }}>
                  &#9654;
                </span>
              )}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default TableView;
