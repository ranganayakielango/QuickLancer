// Sidebar.js

import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './sidebar.css';
import { useLocation } from 'react-router-dom';

const Sidebar = () => {
  const location = useLocation();
  const [relativeUrl, setRelativeUrl] = useState(location.pathname);
  const [isFreelancer, setIsFreelancer] = useState(false);

  useEffect(() => {
    setRelativeUrl(location.pathname);
  }, [location.pathname]);

  useEffect(() => {
    let role = localStorage.getItem('role');
    if (role === 'freelancer') {
      setIsFreelancer(true);
    }
    else {
      setIsFreelancer(false);
    }
  }, []);
  return (
    <div className="sidebar">
      <h2>Navigation</h2>
      <ul>
        <li className={relativeUrl == '/home'? "active" : ""}>
          {/* make class name conditional */}
          <Link to="/home" >Home</Link>
        </li>
        
      

       {isFreelancer ? 
        <li  className={relativeUrl == '/find-job'? "active" : ""}>
          <Link to="/find-job">Find Job</Link> 
        </li> 
        : 
        <li  className={relativeUrl == '/create-job'? "active" : ""}>
          <Link to="/create-job">Create Job</Link> 
        </li>
        }
        {
          !isFreelancer && 
          <li  className={relativeUrl == '/all-jobs'? "active" : ""}>
            <Link to="/all-jobs">All Posted Jobs</Link>
          </li>
        }
        <li  className={relativeUrl == '/history'? "active" : ""}>
          <Link to="/history">History</Link>
        </li>
        <li className={relativeUrl == '/profile'? "active" : ""}> 
          <Link to="/profile" >Profile</Link>
        </li>
        {/* Add more links as needed */}
      </ul>
    </div>
  );
};

export default Sidebar;
