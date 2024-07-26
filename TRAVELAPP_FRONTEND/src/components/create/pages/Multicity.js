import React, { useState } from "react";
import { Dropdown, Button } from "react-bootstrap";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import { createAPI } from "../../../api/api";
import { travelAPI } from "../../../api/api";
import ContentCopyTwoToneIcon from "@mui/icons-material/ContentCopyTwoTone";
import "../../../style/ExcelView.css";
import { useEffect } from "react";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const MultiCity = ({ selectedOption, setSelectedOption, ApplyForformData }) => {
  const types = ["Travel", "Accommodation"];

  const [data, setData] = useState([
    {
      id: 1,
      type: "Travel",
      location: "",
      from: "",
      to: "",
      checkIn: "",
      checkOut: "",
      departure: "",
    },
    {
      id: 2,
      type: "Travel",
      location: "",
      from: "",
      to: "",
      checkIn: "",
      checkOut: "",
      departure: "",
    },
    {
      id: 3,
      type: "Travel",
      location: "",
      from: "",
      to: "",
      checkIn: "",
      checkOut: "",
      departure: "",
    },
  ]);

  const handleAddRow = () => {
    const newRow = {
      id: data.length + 1,
      type: "",
      location: "",
      from: "",
      to: "",
      checkIn: "",
      checkOut: "",
      departure: "",
    };
    setData([...data, newRow]);
  };

  const handleDeleteRow = (id) => {
    if (id === 1) {
      return;
    }

    const updatedData = data.filter((row) => row.id !== id);
    setData(updatedData);
  };

  const handleCopyRow = (id) => {
    const copiedRow = data.find((row) => row.id === id);
    console.log(copiedRow.id);
    const newRow = {
      id: data.length + 1,
      type: copiedRow.type,
      location: copiedRow.location,
      from: copiedRow.from,
      to: copiedRow.to,
      checkIn: copiedRow.checkIn,
      checkOut: copiedRow.checkOut,
      departure: copiedRow.departure,
    };
    setData([...data, newRow]);
  };

  const handleChange = (id, field, value) => {
    const updatedData = data.map((row) =>
      row.id === id ? { ...row, [field]: value } : row
    );

    if (field === "to" && data.length > id) {
      updatedData[id]["from"] = value;
    }

    setData(updatedData);
  };

  const handleSubmit = () => {
    toast("Data Saved successfully");

    const { travelId } = ApplyForformData;
    console.log("Travel ID:", travelId);

    const firstTripData = data.filter(
      (row) => row.type === "Travel" && row.id === 1
    )[0];
    const secondTripData = data.filter(
      (row) => row.type === "Travel" && row.id === 2
    )[0];
    const thirdTripData = data.filter(
      (row) => row.type === "Travel" && row.id === 3
    )[0];
    const forthTripData = data.filter(
      (row) => row.type === "Travel" && row.id === 4
    )[0];
    const fifthTripData = data.filter(
      (row) => row.type === "Travel" && row.id === 5
    )[0];
    createAPI(ApplyForformData)
      .then((response) => {
        console.log("API ApplyForformData response:", response);

        return travelAPI(firstTripData);
      })
      .then((response) => {
        console.log("First-trip API response:", response);

        return travelAPI(secondTripData);
      })
      .then((response) => {
        console.log("Second-trip API response:", response);

        return travelAPI(thirdTripData);
      })
      .then((response) => {
        console.log("Third-trip API response:", response);

        return travelAPI(forthTripData);
      })
      .then((response) => {
        console.log("forth-trip API response:", response);
        return travelAPI(fifthTripData);
      })
      .then((response) => {
        console.log("fifth-trip API response:", response);

        return fetch("http://localhost:8080/mail/send", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            mail: "richagupta123.iimt@gmail.com",
            mailStructure: {
              subject: `Travel request travelId - ${travelId}`, 
              message: "Received new travel request",
            },
          }),
        });
      })
      .then((emailResponse) => {
        if (emailResponse.ok) {
          toast.success("Data Saved successfully and email sent to supervisor");
        } else {
          toast.error("Failed to send email to supervisor");
        }
      })
      .catch((error) => {
        console.error("API error:", error);
        toast.error("Failed to save data");
      });
  };

  return (
    <div className="container">
      <table className="table">
        <thead>
          {types.includes(data[data.length - 1].type) &&
            data[data.length - 1].type === "Travel" && (
              <tr>
                <th>S.No</th>
                <th>Type</th>
                <th>From</th>
                <th>To</th>
                <th>Departure</th>
                <th>Actions</th>
              </tr>
            )}
          {types.includes(data[data.length - 1].type) &&
            data[data.length - 1].type === "Accommodation" && (
              <tr>
                <th>S.No</th>
                <th>Type</th>
                <th>Location</th>
                <th>Check In</th>
                <th>Check Out</th>
                <th>Actions</th>
              </tr>
            )}
        </thead>
        <tbody>
          {data.map((row) => (
            <tr key={row.id}>
              <td>{row.id}</td>
              <td>
                <Dropdown>
                  <Dropdown.Toggle
                    variant="secondary"
                    id={`dropdown-${row.id}`}>
                    {row.type || "Select Type"}
                  </Dropdown.Toggle>
                  <Dropdown.Menu>
                    {types.map((type, index) => (
                      <Dropdown.Item
                        key={index}
                        onClick={() => handleChange(row.id, "type", type)}>
                        {type}
                      </Dropdown.Item>
                    ))}
                  </Dropdown.Menu>
                </Dropdown>
              </td>
              {row.type === "Travel" ? (
                <>
                  <td>
                    <input
                      type="text"
                      className="form-control"
                      placeholder="From"
                      value={row.from}
                      onChange={(e) =>
                        handleChange(row.id, "from", e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <input
                      type="text"
                      className="form-control"
                      placeholder="To"
                      value={row.to}
                      onChange={(e) =>
                        handleChange(row.id, "to", e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <input
                      type="date"
                      className="form-control"
                      placeholder="Departure"
                      min={new Date().toJSON().slice(0, 10)}
                      value={row.departure}
                      onChange={(e) =>
                        handleChange(row.id, "departure", e.target.value)
                      }
                    />
                  </td>
                  <td className="ExcelButton">
                    <Button variant="success" onClick={handleAddRow}>
                      <AddIcon />
                    </Button>{" "}
                    <Button
                      variant="danger"
                      onClick={() => handleDeleteRow(row.id)}>
                      <DeleteIcon />
                    </Button>{" "}
                    <Button
                      variant="info"
                      onClick={() => handleCopyRow(row.id)}>
                      <ContentCopyTwoToneIcon />
                    </Button>
                  </td>
                </>
              ) : row.type === "Accommodation" ? (
                <>
                  <td>
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Location"
                      value={row.location}
                      onChange={(e) =>
                        handleChange(row.id, "location", e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <input
                      type="date"
                      className="form-control"
                      placeholder="Check In"
                      min={new Date().toJSON().slice(0, 10)}
                      value={row.checkIn}
                      onChange={(e) =>
                        handleChange(row.id, "checkIn", e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <input
                      type="date"
                      className="form-control"
                      placeholder="Check Out"
                      value={row.checkOut}
                      onChange={(e) =>
                        handleChange(row.id, "checkOut", e.target.value)
                      }
                    />
                  </td>
                  <td className="ExcelButton">
                    <Button variant="success" onClick={handleAddRow}>
                      <AddIcon />
                    </Button>{" "}
                    <Button
                      variant="danger"
                      onClick={() => handleDeleteRow(row.id)}>
                      <DeleteIcon />
                    </Button>{" "}
                    <Button
                      variant="info"
                      onClick={() => handleCopyRow(row.id)}>
                      <ContentCopyTwoToneIcon />
                    </Button>
                  </td>
                </>
              ) : (
                <td colSpan="7"></td>
              )}
            </tr>
          ))}
        </tbody>
      </table>
      <div className="text-center">
        <div>
          {" "}
          <ToastContainer />
        </div>
        <button className="btn btn-primary" onClick={handleSubmit}>
          Submit
        </button>
      </div>
    </div>
  );
};

export default MultiCity;
