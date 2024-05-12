import React, { useEffect, useState } from "react";
import logo from "../../../../../assets/logo.png";
import "./appliedPeople.css"; // Import CSS file

const AppliedPeople = ({ projectId, setExpandChoose }) => {
  const [data, setData] = useState([]);
  const freelancer_details = [
    {
      id: 1,
      userName: "John Doe",
      description:
        "I’m a developer experienced in building websites for small and medium-sized businesses. Whether you’re trying to win work, list your services, or create a new online store, I can help.Knows HTML and CSS3, PHP, jQuery, Wordpress, and SEOFull project management from start to finish",
    },
    {
      id: 2,
      userName: "Jane Doe",
      description:
        "I’m a developer experienced in building websites for small and medium-sized businesses. Whether you’re trying to win work, list your services, or create a new online store, I can help.Knows HTML and CSS3, PHP, jQuery, Wordpress, and SEOFull project management from start to finish",
    },
    {
      id: 3,
      userName: "John Smith",
      description:
        "I’m a developer experienced in building websites for small and medium-sized businesses. Whether you’re trying to win work, list your services, or create a new online store, I can help.Knows HTML and CSS3, PHP, jQuery, Wordpress, and SEOFull project management from start to finish",
    },
  ];
  const [freeLancer, setFreeLancer] = useState({});
  const choose = (id) => {
    console.log(id);
    alert("Wait for response from freelancer");
    setExpandChoose(false);
  };

  // get freelancers applied to project from backend
  useEffect((projectId) => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `https://f6ad-103-6-159-161.ngrok-free.app/matching-freelancers?pid=6`,
          {
            headers: {
              "ngrok-skip-browser-warning": "69420"
            }
          }
        );
        if (!response.ok) {
          throw new Error("Failed to fetch data");
        }
        const jsonData = await response.json();
        console.log("json data")
        console.log(jsonData);
        // fetch all keys in json data
        console.log(Object.keys(jsonData))
        // loop through keys
        for (const key in jsonData) {
          const response = await fetch(
            `https://6358-121-242-242-226.ngrok-free.app/freelance/${key}`
          );
          if (!response.ok) {
            throw new Error("Failed to fetch data");
          }
          const d = await response.json();
          console.log("ds",d)
          setData([...data, d])
          console.log('data')
          console.log(data)
        }
      } catch (error) {
        console.log(error);
      }
    };

    fetchData(projectId);
  }, []);

  return (
    <div className="popup-container">
      <div className="popup-content">
        <h2>Recommended Freelancers for your project</h2>
        <span className="close-btn" onClick={() => choose(null)}>
          &times;
        </span>
        <div className="applied-people">
          {data && Array.isArray(data) && data.map((freelancer) => {
            return (<div className="user-card" key={freelancer.id}>
              <div className="image-container">
                <img src={logo} alt="User" className="user-image" />
              </div>
              <div className="content">
                <h3 className="user-name">{freelancer.name}</h3>
                <p className="user-description">{freelancer.selfDescription} When serving the actual request you have to add one CORS header - otherwise the browser won't return the response to the invoking JavaScript code. Instead the request will fail on the client-side. Example with jsonify</p>
                <button
                  className="button"
                  onClick={() => choose(freelancer.id)}
                >
                  Request
                </button>
              </div>
            </div>)
})}
        </div>
      </div>
    </div>
  );
};

export default AppliedPeople;
