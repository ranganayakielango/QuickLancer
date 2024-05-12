import React, { useState } from "react";
import "./createJob.css"; // Import the CSS file for styling
import MultiSelectDropdown from "../MultiSelectDropDown/MultiSelectDropDown"; // Import the MultiSelectDropdown component

const CreateJob = () => {
  const languageOptions = [
    { value: "english", label: "English" },
    { value: "spanish", label: "Spanish" },
    { value: "french", label: "French" },
    { value: "german", label: "German" },
    { value: "italian", label: "Italian" },
    { value: "portuguese", label: "Portuguese" }
];

  const technologiesOptions = [
    { value: "python", label: "Python" },
    { value: "java", label: "Java" },
    { value: "csharp", label: "C#" },
    { value: "swift", label: "Swift" },
    { value: "flutter", label: "Flutter" },
    { value: "reactnative", label: "React Native" },
    { value: "javascript", label: "JavaScript" },
    { value: "html", label: "HTML" },
    { value: "css", label: "CSS" },
    { value: "python", label: "Python" },
    { value: "ruby", label: "Ruby" },
    { value: "java", label: "Java" }
];
  const [languagesKnown, setLanguagesKnown] = useState([]);
  const [technologiesSelected, setTechnologiesSelected] = useState([]);

  const [formData, setFormData] = useState({
    clientEmail: "example1212121232231d@ex11ample.com",
    domain: "",
    title: "",
    description: "",
    technology: [],
    budget: 5,
    negotiateBudget: false,
    noOfHours: 10.0,
    daysLimit: 2,
    comfortTimeFrom: "",
    comfortTimeTo: "",
    timezone: "",
    negotiateTime:""
  });

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    if (files) {
      setFormData({ ...formData, [name]: files[0] });
    } else {
      if(name === "negotiateBudget" || name === "negotiateTime")
        setFormData({ ...formData, [name]: value == "yes" ? true : false });
      else setFormData({ ...formData, [name]: value });
    }
  };

  const handleTechnologiesChange = (selectedOptions) => {
    setTechnologiesSelected(selectedOptions);
    
    let temp = []
    for(let i=0; i<selectedOptions.length; i++){
      temp.push(selectedOptions[i].value)
    }
    setFormData({ ...formData, technology: JSON.stringify(temp) });
    console.log(formData)
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Send form data to API
    fetch("https://6358-121-242-242-226.ngrok-free.app/project", {
      method: "POST",
      // mode: 'no-cors',
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <div className="form-container">
      <h2>Enter Your Details</h2>
      <form onSubmit={handleSubmit}>
        <label>Domain:</label>
        <select name="domain" value={formData.domain} onChange={handleChange}>
          <option value="web">Web Development</option>
          <option value="mobile">Mobile Development</option>
          <option value="data">Data Science</option>
          {/* Add more options as needed */}
        </select>
        {/* Title */}
        <label>Title:</label>
        <input
          type="text"
          name="title"
          value={formData.title}
          onChange={handleChange}
          required
        />

        <label>Description:</label>
        <textarea
          name="description"
          value={formData.description}
          onChange={handleChange}
        ></textarea>

        {/* Technologies */}
        <label>Technologies:</label>

        <MultiSelectDropdown
          options={technologiesOptions}
          value={technologiesSelected}
          onChange={handleTechnologiesChange}
          required
        />

        <label>Budget (in dollars):</label>
        <input
          type="number"
          name="budget"
          value={formData.budget}
          onChange={handleChange}
          required
        />

        <label>Negotiable:</label>
        <select
          name="negotiateBudget"
          value={formData.negotiateBudget}
          onChange={handleChange}
          required
        >
          <option value="yes">Yes</option>
          <option value="no">No</option>
        </select>

        <label>No Of Hours:</label>
        <input
          type="number"
          name="noOfHours"
          value={formData.noOfHours}
          onChange={handleChange}
          required
        />

        <label>Days Limit:</label>
        <input
          type="number"
          name="daysLimit"
          value={formData.daysLimit}
          onChange={handleChange}
          required
        />

        {/* Time Zone */}
        <label>Time Zone:</label>
        <input
          type="text"
          name="timezone"
          value={formData.timezone}
          onChange={handleChange}
        />

        {/* Preferred Work Time From */}
        <label>Preferred Work Time From:</label>
        <input
          type="time"
          name="comfortTimeFrom"
          value={formData.comfortTimeFrom}
          onChange={handleChange}
        />

        {/* Preferred Work Time To */}
        <label>Preferred Work Time To:</label>
        <input
          type="time"
          name="comfortTimeTo"
          value={formData.comfortTimeTo}
          onChange={handleChange}
        />
        
        <label>Negotiate time:</label>
        <select
          name="negotiateTime"
          value={formData.negotiateTime}
          onChange={handleChange}
          required
        >
          <option value="yes">Yes</option>
          <option value="no">No</option>
        </select>

        {/* Cancel and Submit Buttons */}
        <div>
          <button type="button">Cancel</button>
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  );
};

export default CreateJob;
