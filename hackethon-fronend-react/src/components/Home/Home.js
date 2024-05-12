// src/components/HomePage.js

import React from 'react';
import './home.css';
// import freelancerImage from '../images/freelancer.jpg'; // Import an engaging image for the background

const Home = () => {
  return (
    <div className="homepage">
      <div className="homepage-content">
        <h1>Welcome to Your Freelance Platform</h1>
        <p>Connect with talented freelancers or find projects to work on!</p>
        <button className="btn">Get Started</button>
      </div>
      {/* <img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.com%2Ffree-photos-vectors%2Fgray-background&psig=AOvVaw0Tr2l_IgBtMbNRnMyZ3DlC&ust=1715526704202000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCICB6aXxhYYDFQAAAAAdAAAAABAE" alt="Freelancer" className="background-image" /> */}
    </div>
  );
};

export default Home;
