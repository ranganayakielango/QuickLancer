import React, { useState, useEffect } from "react";
import "./freelancerDetails.css"; // Import the CSS file for styling
import MultiSelectDropdown from "../../MultiSelectDropDown/MultiSelectDropDown"; // Import the MultiSelectDropdown component

const FreelancerDetails = () => {
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
  const domainOptions = [
    { value: "website", label: "Website" },
    { value: "mobile_devlopment", label: "Mobile Devlopment" },
    { value: "Blockchain", label: "French" },
    { value: "recommendation_system", label: "Recommendation System" },
    { value: "prediction_system", label: "Prediction System" },
    { value: "dektop_software", label: "Desktop Software" }

  ];
  const [languagesKnown, setLanguagesKnown] = useState([]);
  const [technologiesSelected, setTechnologiesSelected] = useState([]);
  const [domainSelected, setDomainSelected] = useState([]);

  const [formData, setFormData] = useState({
    name: "",
    phoneNumber: "",
    dob: "",
    emailId: "",
    experience: "",
    educationDetails: "",
    language: [],
    languageMatch: "",
    selfDescription: "",
    photo: "",
    negotiableTime: "",
    expSalaryPerHour: "",
    salaryNegotiable: "",
    preferredWorkTimeFrom: "",
    preferredWorkTimeTo: "",
    timeZone: "",
    domain: [],
    technology: [],
    projects: [{ header: "", description: "" }],
  });

  // const [formData, setFormData] = useState({
  //   name: "sdfsdf",
  //   phoneNumber: "sdfsdf",
  //   dob: "2001-10-10",
  //   emailId: "sankar@e11xa1mp111le.com",
  //   experience: "1",
  //   educationDetails: "sdfs",
  //   language: ["dsfsdf"],
  //   languageMatch: true,
  //   selfDescription: "dsfsdf",
  //   photo: "",
  //   negotiableTime: true,
  //   expSalaryPerHour: 1,
  //   salaryNegotiable: true,
  //   preferredWorkTimeFrom: "13:30",
  //   preferredWorkTimeTo: "13:30",
  //   timeZone: "sdf",
  //   domain: "asdfsdf",
  //   technology: ["sdfsd"],
  //   projects: [{ header: "dsfasdf", description: "dfasdf" }],
  // });

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    if (files) {
      setFormData({ ...formData, [name]: files[0] });
    } else {
      setFormData({ ...formData, [name]: value });
    }
  };
  
  const handleLanguagesChange = (selectedOptions) => {
    setLanguagesKnown(selectedOptions);
    let temp = []
    for(let i=0; i<selectedOptions.length; i++){
      temp.push(selectedOptions[i].value)
    }
    setFormData({ ...formData, language: JSON.stringify(temp) });
    console.log(formData)
  };

  const handleDomainChange = (selectedOptions) => {
    setDomainSelected(selectedOptions);
    let temp = []
    for(let i=0; i<selectedOptions.length; i++){
      temp.push(selectedOptions[i].value)
    }
    setFormData({ ...formData, domain: JSON.stringify(temp) });
    console.log(formData)
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

  const handleProjectChange = (index, field, value) => {
    const newProjects = [...formData.projects];
    newProjects[index][field] = value;
    setFormData({ ...formData, projects: newProjects });
    console.log(formData)
  };

  const addProject = () => {
    setFormData({
      ...formData,
      projects: [...formData.projects, { header: "", description: "" }],
    });
  };
  useEffect(() => {
    console.log('sdfjksdjf')
    let email = localStorage.getItem("email");
    setFormData({ ...formData, emailId: email });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    const formDataToSend = new FormData();
    // Append form data to FormData object
    for (let key in formData) {
      if(key === "languageMatch" || key === "negotiableTime" || key === "salaryNegotiable")
        formDataToSend.append(key, "yes" === formData[key] ? true : false);
      else if(key === "projects")
        formDataToSend.append(key, JSON.stringify(formData[key]));
      else
        formDataToSend.append(key, formData[key]);
    }
    // Send form data to API
    fetch('https://6358-121-242-242-226.ngrok-free.app/freelance', {
      method: 'POST',
      mode: 'no-cors',
      body: formDataToSend,
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  };

  return (
    <div className="form-container">
      <h2>Enter Your Details</h2>
      <form onSubmit={handleSubmit}>
        {/* Name */}
        <label>Name:</label>
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />

        {/* Phone Number */}
        <label>Phone Number:</label>
        <input
          type="tel"
          name="phoneNumber"
          value={formData.phoneNumber}
          onChange={handleChange}
          maxLength="10"
          required
        />

        {/* dob */}
        <label>Date of Birth:</label>
        <input
          type="date"
          name="dob"
          value={formData.dob}
          onChange={handleChange}
          required
        />

        {/* Email (Prepopulated) */}
        <label>Email:</label>
        <input type="email" value={formData.emailId} readOnly disabled />

        {/* Experience */}
        <label>Experience (in years):</label>
        <input
          type="number"
          name="experience"
          value={formData.experience}
          onChange={handleChange}
          required
        />

        {/* Education Details */}
        <label>Education Details:</label>
        <input
          type="text"
          name="educationDetails"
          value={formData.educationDetails}
          onChange={handleChange}
          required
        />

        {/* Languages Known (Multi-select dropdown) */}
        <label>Languages Known:</label>

        <MultiSelectDropdown
          options={languageOptions}
          value={languagesKnown}
          onChange={handleLanguagesChange}
          required
        />
        {/* Language Match */}
        <label>Language Match:</label>
        <select
          name="languageMatch"
          value={formData.languageMatch}
          onChange={handleChange}
          required
        >
          <option value="yes">Yes</option>
          <option value="no">No</option>  
        </select>

        {/* Self Description */}
        <label>Self Description:</label>
        <textarea
          name="selfDescription"
          value={formData.selfDescription}
          onChange={handleChange}
        ></textarea>

        {/* Photo (File upload) */}
        <label>Photo:</label>
        <input
          type="file"
          accept="image/jpeg, image/png"
          name="photo"
          onChange={handleChange}
        />

        {/* Negotiable Time */}
        <label>Negotiable Time:</label>
        <select
          name="negotiableTime"
          value={formData.negotiableTime}
          onChange={handleChange}
        >
          <option value="yes">Yes</option>
          <option value="no">No</option>
        </select>

        {/* Expected Salary per Hour in $ */}
        <label>Expected Salary per Hour ($):</label>
        <input
          type="number"
          name="expSalaryPerHour"
          value={formData.expSalaryPerHour}
          onChange={handleChange}
        />

        {/* Salary Negotiable */}
        <label>Salary Negotiable:</label>
        <select
          name="salaryNegotiable"
          value={formData.salaryNegotiable}
          onChange={handleChange}
        >
          <option value="yes">Yes</option>
          <option value="no">No</option>
        </select>

        {/* Preferred Work Time From */}
        <label>Preferred Work Time From:</label>
        <input
          type="time"
          name="preferredWorkTimeFrom"
          value={formData.preferredWorkTimeFrom}
          onChange={handleChange}
        />

        {/* Preferred Work Time To */}
        <label>Preferred Work Time To:</label>
        <input
          type="time"
          name="preferredWorkTimeTo"
          value={formData.preferredWorkTimeTo}
          onChange={handleChange}
        />

        {/* Time Zone */}
        <label>Time Zone:</label>
        <input
          type="text"
          name="timeZone"
          value={formData.timeZone}
          onChange={handleChange}
        />

        {/* Domain */}
        <label>Domain:</label>
        {/* <select name="domain" value={formData.domain} onChange={handleChange}>
          <option value="web">Web Development</option>
          <option value="mobile">Mobile Development</option>
          <option value="data">Data Science</option>
        </select> */}

        <MultiSelectDropdown
          options={domainOptions}
          value={domainSelected}
          onChange={handleDomainChange}
          required
        />

        {/* Technologies */}
        <label>Technologies:</label>
        {/* <select
          name="technologies"
          multiple
          value={formData.technologies}
          onChange={handleChange}
        >
          <option value="react">React</option>
          <option value="node">Node.js</option>
          <option value="python">Python</option>
        </select> */}
        <MultiSelectDropdown
          options={technologiesOptions}
          value={technologiesSelected}
          onChange={handleTechnologiesChange}
          required
        />
        {/* Projects */}
        <label>Projects:</label>
        <div className="all-projects">
          {formData.projects.map((project, index) => (
            <div key={index}>
              <label>Project Header:</label>
              <input
                type="text"
                value={project.header}
                onChange={(e) =>
                  handleProjectChange(index, "header", e.target.value)
                }
              />
              <label>Project Description:</label>
              <textarea
                value={project.description}
                onChange={(e) =>
                  handleProjectChange(index, "description", e.target.value)
                }
                size="4"
              ></textarea>
            </div>
          ))}
          <button className="add-project" type="button" onClick={addProject}>
            +
          </button>
        </div>

        {/* Cancel and Submit Buttons */}
        <div>
          <button type="button">Cancel</button>
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  );
};

export default FreelancerDetails;
