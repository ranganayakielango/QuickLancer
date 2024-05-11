// src/components/Login.js

import React, { useState } from 'react';
import './login.css'; // Import the CSS file
import { Link } from 'react-router-dom'; // Import Link from react-router-dom

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [selectedOption, setSelectedOption] = useState('user'); // State for the selected option
  const [error, setError] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    if (email && password) {
      console.log('Logged in successfully');
    } else {
      setError('Please enter email and password');
    }
  };

  return (
    <div className="login-container"> {/* Use className instead of style */}
      <h2 className="login-heading">Login</h2>
      {error && <p className="error">{error}</p>}
      
      <form onSubmit={handleLogin} className="form">
        <div className="form-group">
          <label className="label">Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="input"
          />
        </div>
        <div className="form-group">
          <label className="label">Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="input"
          />
        </div>
        <div className="form-group">
          <label className="label">Select Role:</label>
          <select
            value={selectedOption}
            onChange={(e) => setSelectedOption(e.target.value)}
            className="input" // You can adjust the styling as needed
          >
            <option value="freelancer">Freelancer</option>
            <option value="admin">Admin</option>
          </select>
        </div>
        <button type="submit" className="button">Login</button>
      </form>

      <p>Don't Have an account? <Link to="/signup">Signup</Link></p>

    </div>
  );
};

export default Login;
