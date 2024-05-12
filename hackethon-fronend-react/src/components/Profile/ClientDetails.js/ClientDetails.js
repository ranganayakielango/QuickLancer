import React, { useEffect, useState } from "react";
import "./clientDetails.css"; // Import the CSS file for styling
import MultiSelectDropdown from "../../MultiSelectDropDown/MultiSelectDropDown"; // Import the MultiSelectDropdown component

const ClientDetails = () => {
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
  const [domainSelected, setDomainSelected] = useState([]);

  const domainOptions = [
    { value: "website", label: "Website" },
    { value: "mobile_devlopment", label: "Mobile Devlopment" },
    { value: "Blockchain", label: "French" },
    { value: "recommendation_system", label: "Recommendation System" },
    { value: "prediction_system", label: "Prediction System" },
    { value: "dektop_software", label: "Desktop Software" }

  ];

  const [formData, setFormData] = useState({
    name: "",
    phoneNo: "",
    email: "",
    language: [],
    languageMatch: "",
    organization: "",
    organizationWebsite: "",
    timezone: "",
    domain: "",
  });
  const handleDomainChange = (selectedOptions) => {
    setDomainSelected(selectedOptions);
    let temp = []
    for(let i=0; i<selectedOptions.length; i++){
      temp.push(selectedOptions[i].value)
    }
    setFormData({ ...formData, domain: JSON.stringify(temp) });
    console.log(formData)
  };

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    if (files) {
      setFormData({ ...formData, [name]: files[0] });
    } else {
      if(name === 'languageMatch')
        setFormData({ ...formData, [name]: value=="yes"?true:false });
      else
      setFormData({ ...formData, [name]: value });
    }
  };

  useEffect(() => {
    console.log('skdljflj')
    let email = localStorage.getItem("email");
    console.log(email)
    setFormData({ ...formData, email: email });
  }, []);

  const handleLanguagesChange = (selectedOptions) => {
    setLanguagesKnown(selectedOptions);
    let temp = []
    for(let i=0; i<selectedOptions.length; i++){
      temp.push(selectedOptions[i].value)
    }
    setFormData({ ...formData, language: JSON.stringify(temp) });
    console.log(formData)
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    // Send form data to API
    fetch('https://6358-121-242-242-226.ngrok-free.app/client', {
      method: 'POST',
      // mode: 'no-cors',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      body: JSON.stringify(formData),
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
          name="phoneNo"
          value={formData.phoneNo}
          onChange={handleChange}
          maxLength="10"
          required
        />

        

        {/* Email (Prepopulated) */}
        <label>Email:</label>
        <input type="email" value={formData.email} readOnly disabled />


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

        {/* organization */}
        <label>organization</label>
        <input
          type="text"
          name="organization"
          value={formData.organization}
          onChange={handleChange}
          required
        />

        {/* link */}
        <label>Organization Website</label>
        <input
          type="text"
          name="organizationWebsite"
          value={formData.organizationWebsite}
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
        
        {/* Cancel and Submit Buttons */}
        <div>
          <button type="button">Cancel</button>
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  );
};

export default ClientDetails;
