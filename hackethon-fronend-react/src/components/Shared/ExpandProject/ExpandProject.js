import React, { useState, useEffect } from "react";
import "./expandProject.css"; // Import CSS for styling

import { useLocation } from "react-router-dom";


const ExpandProject = ({
  porjectId,
  domain,
  title,
  description,
  technology1,
  budget,
  negotiateBudget,
  noOfHours,
  daysLimit,
  comfortTimeFrom,
  comfortTimeTo,
  timezone,
  clientEmail,
  setExpanded,
  from,
}) => {
  const listApplied = (projectId, setExpanded) => {
    alert("List of people applied to project");
    console.log("List of people applied to project");
    setExpanded(false);
  };
  
  const choosePeople = (projectId, setExpanded) => {
    alert("Choose people for project");
    console.log("Choose people for project");
    setExpanded(false);
  };
  
  const complete = (projectId, setExpanded) => {
    alert("Project completed");
    console.log("Project completed");
    setExpanded(false);
  };
  
  const review = (projectId, setExpanded) => {
    alert("Review project");
    console.log("Review project");
    setExpanded(false);
    setExpanded(false);
  
  };
  
  const apply = () => {
    alert("Applied to project");
    console.log("Applied to project");
      setExpanded(false);
  
  };
  
  const [selectedOption, setSelectedOption] = useState("");
  const options = ["Option 1", "Option 2", "Option 3", "Option 4"];

  const handleChange = (e) => {
    setSelectedOption(e.target.value);
  };

  const sendRequest = (projectId, setExpanded) => {
    alert("Request sent");
    console.log("Request sent");
    setExpanded(false);
  };
  const location = useLocation();
  const [relativeUrl, setRelativeUrl] = useState(location.pathname);
  useEffect(() => {
    console.log(location.pathname);
    setRelativeUrl(location.pathname.split("#")[1]);
  }, [location.pathname]);
  return (
    <div className="project-details-container">
      <div className="header">
        <h1>Project Details</h1>
      </div>
      <div className="content">
        <div className="left-column">
          <h2 className="sub-heading">Integration</h2>
          <div className="show-group">
            <p className="label">Domain:</p>
            <p>{domain}</p>
          </div>

          <div className="show-group">
            <p className="label">Title:</p>
            <p>{title}</p>
          </div>

          <div className="show-group">
            <p className="label">Description:</p>
            <p>{description}</p>
          </div>

          <div className="show-group">
            <p className="label">Technology:</p>
            <div className="technology-list">
              {technology1.map((item, index) => (
                <div key={index} className="technology-item">
                  {item}
                </div>
              ))}
            </div>
          </div>
        </div>
        <div className="right-column">
          <div className="section">
            <h2 className="sub-heading">Project Information</h2>
            <div className="show-group">
              <p className="label">Budget:</p>
              <p>${budget}</p>
            </div>
            <div className="show-group">
              <p className="label">Negotiate Budget:</p>
              <p>{negotiateBudget ? "Yes" : "No"}</p>
            </div>
            <div className="show-group">
              <p className="label">Number of Hours:</p>
              <p>{noOfHours}</p>
            </div>
            <div className="show-group">
              <p className="label">Days Limit:</p>
              <p>{daysLimit} days</p>
            </div>
            <div className="show-group">
              <p className="label">Comfort Time From:</p>
              <p>{comfortTimeFrom}</p>
            </div>
            <div className="show-group">
              <p className="label">Comfort Time To:</p>
              <p>{comfortTimeTo}</p>
            </div>

            <div className="show-group">
              <p className="label">Timezone:</p>
              <p>{timezone}</p>
            </div>

            <div className="show-group">
              <p className="label">Client Email:</p>
              <p>{clientEmail}</p>
            </div>
          </div>
          <div className="button-container">
            {from == "ongoing" && (
              <div>
                <div>
                  <div style={{ width: "100%" }}>
                    <h3>Select an option:</h3>
                    <select
                      value={selectedOption}
                      onChange={handleChange}
                      style={{ width: "100%" }}
                    >
                      <option value="">Select an option</option>
                      {options.map((option, index) => (
                        <option key={index} value={option}>
                          {option}
                        </option>
                      ))}
                    </select>
                    <button
                      className="button"
                      onClick={() => sendRequest(porjectId, setExpanded)}
                      style={{ marginTop: "10px" }}
                    >
                      Submit
                    </button>
                    {selectedOption && <p>You selected: {selectedOption}</p>}
                  </div>
                  <button
                    className="button"
                    onClick={() => listApplied(porjectId, setExpanded)}
                  >
                    Show Applied People
                  </button>
                </div>
                <button
                  className="button"
                  onClick={() => choosePeople(porjectId, setExpanded)}
                >
                  {" "}
                 Show Recommendation
                </button>
              </div>
            )}
            {from == "inprogress" && (
              <button
                className="button"
                onClick={() => complete(porjectId, setExpanded)}
              >
                {" "}
                Complete{" "}
              </button>
            )}
            {from == "completed" && (
              <button
                className="button"
                onClick={() => review(porjectId, setExpanded)}
              >
                {" "}
                Review{" "}
              </button>
            )}

            {from == "freelancer" && 
              <button className="button" onClick={apply}> Apply </button>
            }
            <button className="button" onClick={() => setExpanded(false)}>
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ExpandProject;
