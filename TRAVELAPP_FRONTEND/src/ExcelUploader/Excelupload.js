import React, { useState } from "react";

const ExcelUpload = () => {
  const [file, setFile] = useState(null);

  // Function to handle file selection
  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    setFile(selectedFile);
  };

  // Function to handle file drop
  const handleFileDrop = (event) => {
    event.preventDefault();
    const droppedFile = event.dataTransfer.files[0];
    setFile(droppedFile);
  };

  // Prevent default behavior for file drop events
  const preventDefault = (event) => {
    event.preventDefault();
    event.stopPropagation();
  };

  return (
    <div>
      <h2>Upload </h2>
      <div>
        <input type="file" accept=".xlsx, .xls" onChange={handleFileChange} />
      </div>
      <div
        onDrop={handleFileDrop}
        onDragOver={preventDefault}
        onDragEnter={preventDefault}
        style={{
          border: "2px dashed #ccc",
          borderRadius: "4px",
          padding: "20px",
          marginTop: "20px",
        }}
      >
        <p>Drag and drop </p>
      </div>
      {file && (
        <div>
          <h3>Selected File:</h3>
          <p>{file.name}</p>
        </div>
      )}
    </div>
  );
};

export default ExcelUpload;
