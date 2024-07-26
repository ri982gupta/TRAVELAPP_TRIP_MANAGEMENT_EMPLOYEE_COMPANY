import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Search = () => {
  const [travelData, setTravelData] = useState([]);
  const [error, setError] = useState(null);
  const [currentPageApproved, setCurrentPageApproved] = useState(1);
  const [currentPagePending, setCurrentPagePending] = useState(1);
  const [itemsPerPagePending] = useState(5);
  const [itemsPerPageApproved] = useState(5);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get(
        "http://localhost:9004/applyForFormData/all"
      );
      setTravelData(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const approvalRequests = travelData.filter(
    (travel) => travel.approvalStatus === "approved"
  );
  const pendingRequests = travelData.filter(
    (travel) => travel.approvalStatus === null
  );

  const indexOfLastItemApproved = currentPageApproved * itemsPerPageApproved;
  const indexOfFirstItemApproved =
    indexOfLastItemApproved - itemsPerPageApproved;
  const currentItemsApproved = approvalRequests.slice(
    indexOfFirstItemApproved,
    indexOfLastItemApproved
  );

  const indexOfLastItemPending = currentPagePending * itemsPerPagePending;
  const indexOfFirstItemPending = indexOfLastItemPending - itemsPerPagePending;
  const currentItemsPending = pendingRequests.slice(
    indexOfFirstItemPending,
    indexOfLastItemPending
  );

  const pageNumbersPending = [];
  for (
    let i = 1;
    i <= Math.ceil(pendingRequests.length / itemsPerPagePending);
    i++
  ) {
    pageNumbersPending.push(i);
  }

  const paginatePending = (pageNumber) => setCurrentPagePending(pageNumber);

  const pageNumbersApproved = [];
  for (
    let i = 1;
    i <= Math.ceil(approvalRequests.length / itemsPerPageApproved);
    i++
  ) {
    pageNumbersApproved.push(i);
  }

  const paginateApproved = (pageNumber) => setCurrentPageApproved(pageNumber);



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
            Search Travel Details
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
            My Approved Requests
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
          }}
        >
          <colgroup>
            <col style={{ width: "3%" }} />
            <col style={{ width: "25%" }} />
            <col style={{ width: "25%" }} />
            <col style={{ width: "25%" }} />
          </colgroup>
          <thead>
            <tr>
              <th
                style={{
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                S.No
              </th>
              <th
                style={{
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
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Date_Of_travel
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
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            {approvalRequests.length === 0 ? (
              <tr>
                <td
                  colSpan="4"
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "3px",
                    verticalAlign: "middle",
                    textAlign: "center",
                  }}
                >
                  No Results Found
                </td>{" "}
              </tr>
            ) : (
              currentItemsApproved.map((travel, index) => (
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
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {(currentPageApproved - 1) * itemsPerPageApproved +
                      index +
                      1}
                  </td>{" "}
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.travelId !== null ? travel.travelId : "-"}
                  </td>{" "}
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.dateOfTravel !== null ? travel.dateOfTravel : "-"}
                  </td>{" "}
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      padding: "5px",
                      verticalAlign: "middle",
                      textAlign: "left",
                    }}
                  >
                    {travel.tripDescription !== null
                      ? travel.tripDescription
                      : "-"}
                  </td>{" "}
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    <Link to="/view" style={{ textDecoration: "none" }}>
                      View Trip
                    </Link>
                  </td>
                </tr>
              ))
            )}
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
            marginLeft: "8px",
            width: "calc(100% - 24px)",
          }}
        >
          {pageNumbersApproved.map((number, index) => (
            <li key={number} style={{ margin: "5px" }}>
              {number === 1 && (
                <span style={{ marginRight: "5px", color: "#333333" }}>
                  &#9664;
                </span>
              )}
              <a
                href="#"
                onClick={() => paginateApproved(number)}
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

      <br />

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
            My Pending Requests
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
          }}
        >
          <colgroup>
            <col style={{ width: "3%" }} />
            <col style={{ width: "25%" }} />
            <col style={{ width: "25%" }} />
            <col style={{ width: "25%" }} />
          </colgroup>
          <thead>
            <tr>
              <th
                style={{
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                S.No
              </th>
              <th
                style={{
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
                  border: "1px solid #ECF0F1",
                  backgroundColor: "#295bac",
                  color: "#ffffff",
                  padding: "5px",
                  verticalAlign: "middle",
                }}
              >
                Date_Of_Travel
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
            {pendingRequests.length === 0 ? (
              <tr>
                <td
                  colSpan="4"
                  style={{
                    border: "1px solid #ECF0F1",
                    padding: "3px",
                    verticalAlign: "middle",
                    textAlign: "center",
                  }}
                >
                  No Results Found
                </td>{" "}
              </tr>
            ) : (
              currentItemsPending.map((travel, index) => (
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
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {(currentPagePending - 1) * itemsPerPagePending + index + 1}
                  </td>

                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    <Link
                      to={{
                        pathname: "/create",
                        state: { travelId: travel.travelId },
                      }}
                      style={{ textDecoration: "none" }}
                    >
                      {travel.travelId !== null ? travel.travelId : "-"}
                    </Link>
                  </td>

                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
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
                      textAlign: "left",
                    }}
                  >
                    {travel.tripDescription !== null
                      ? travel.tripDescription
                      : "-"}
                  </td>
                  <td
                    style={{
                      border: "1px solid #ECF0F1",
                      borderRight: "1px solid #dbdcdc",
                      padding: "3px",
                      verticalAlign: "middle",
                      textAlign: "center",
                    }}
                  >
                    {travel.approvalStatus !== null
                      ? travel.approvalStatus
                      : "pending"}
                  </td>
                </tr>
              ))
            )}
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
            color: "#000000",
            padding: "10px",
            marginBottom: "20px",
            marginLeft: "8px",
            width: "calc(100% - 24px)",
          }}
        >
          {pageNumbersPending.map((number, index) => (
            <li key={number} style={{ margin: "5px" }}>
              {number === 1 && (
                <span style={{ marginRight: "5px", color: "#333333" }}>
                  &#9664;
                </span>
              )}

              <a
                href="#"
                onClick={() => paginatePending(number)}
                style={{ textDecoration: "none", color: "#000000" }}
              >
                {number}
              </a>

              {number === pageNumbersPending.length && (
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

export default Search;
