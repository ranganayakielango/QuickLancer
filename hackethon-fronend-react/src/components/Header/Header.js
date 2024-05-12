import React, { useState } from 'react';
import './header.css'; // Import the CSS file for styling
import logo from '../../assets/logo.png'; // Import the logo image
import profile from '../../assets/profile.png'; // Import the profile image

const Header = () => {
  const [showOptions, setShowOptions] = useState(false);
  
  const toggleOptions = () => {
    setShowOptions(!showOptions);
  };

  const logout = () => {
    localStorage.clear();
    window.location.href = '/login';
  }

  return (
    <div className="header">
      <div className="logo">
        <img src={logo} alt="Logo" />
      </div>
      <div className="title">
        <h1>QuickLancer</h1>
      </div>
      <div className="profile" onClick={toggleOptions}>
        <img src={profile} alt="Profile" />
        {showOptions && (
          <div className="options">
            <ul>
              <li onClick={()=> logout()}>Logout</li>
            </ul>
          </div>
        )}
      </div>
    </div>
  );
};

export default Header;
