import React, { useState } from "react";
import { Dropdown, Button } from "react-bootstrap";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import ContentCopyTwoToneIcon from "@mui/icons-material/ContentCopyTwoTone";
import "../../style/ExcelView.css";
import { useEffect } from "react";

const ExcelViewComponent = ({ selectedOption, setSelectedOption }) => {
  const types = ["Travel", "Accommodation"];

  const [additionalRowsAdded, setAdditionalRowsAdded] = useState(false);

  useEffect(() => {
    if (
      (selectedOption === "roundTrip" && !additionalRowsAdded) ||
      (selectedOption === "multiCity" && !additionalRowsAdded)
    ) {
      const newRow = {
        id: data.length + 1,
        type: "Travel",
        location: "",
        from: "",
        to: "",
        checkIn: "",
        checkOut: "",
        departure: "",
      };
      setData([...data, newRow]);

      setAdditionalRowsAdded(true);
    }
  }, [selectedOption, additionalRowsAdded]);

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
    if (selectedOption === "roundTrip" || selectedOption === "multiCity") {
      if (id !== 1 && id !== 2) {
        const updatedData = data.filter((row) => row.id !== id);
        setData(updatedData);
      }
    } else if (selectedOption === "oneWay" && id !== 1) {
      const updatedData = data.filter((row) => row.id !== id);
      setData(updatedData);
    }
  };

  const handleCopyRow = (id) => {
    const copiedRow = data.find((row) => row.id === id);
    console.log(copiedRow.id);
    const newRow = {
      id: copiedRow.id + 1,
      type: copiedRow.type,
      location: copiedRow.location,
      from: copiedRow.from,
      to: copiedRow.to,
      checkIn: "",
      checkOut: "",
      departure: copiedRow.departure,
    };
    setData([...data, newRow]);
  };

  const handleChange = (id, field, value) => {
    const updatedData = data.map((row) =>
      row.id === id ? { ...row, [field]: value } : row
    );
    if (selectedOption === "roundTrip" && additionalRowsAdded && id === 1) {
      setAdditionalRowsAdded(false);
      if (field === "from") {
        updatedData[1]["to"] = value;
      } else if (field === "to") {
        updatedData[1]["from"] = value;
      }
    } else if (selectedOption === "multiCity" && additionalRowsAdded) {
      if (field === "to") {
        updatedData[1]["from"] = value;
      }
    }

    if (selectedOption === "roundTrip" || selectedOption === "multiCity") {
      if (id === 1) {
        setAdditionalRowsAdded(false);
      }
    }

    setData(updatedData);
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
                    id={`dropdown-${row.id}`}
                  >
                    {row.type || "Select Type"}
                  </Dropdown.Toggle>
                  <Dropdown.Menu>
                    {types.map((type, index) => (
                      <Dropdown.Item
                        key={index}
                        onClick={() => handleChange(row.id, "type", type)}
                      >
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
                      onClick={() => handleDeleteRow(row.id)}
                    >
                      <DeleteIcon />
                    </Button>{" "}
                    <Button
                      variant="info"
                      onClick={() => handleCopyRow(row.id)}
                    >
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
                      onClick={() => handleDeleteRow(row.id)}
                    >
                      <DeleteIcon />
                    </Button>{" "}
                    <Button
                      variant="info"
                      onClick={() => handleCopyRow(row.id)}
                    >
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
        <button className="btn btn-primary">Submit</button>
      </div>
    </div>
  );
};

export default ExcelViewComponent;
