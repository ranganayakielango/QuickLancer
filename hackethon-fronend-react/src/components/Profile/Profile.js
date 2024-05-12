import React, { useEffect, useState } from 'react';
import FreelancerDetails from './FreelancerDetails.js/FreelancerDetails';
import ClientDetails from './ClientDetails.js/ClientDetails';

const Profile = () => {
  const [isfreelnacer, setIsfreelnacer] = useState(true);
  const handleLogin = () => {
    setIsfreelnacer(true);
  };

  useEffect(() => {
    let role = localStorage.getItem('role');
    console.log(role);
    if(role === 'freelancer'){
      setIsfreelnacer(true)
    }
    else {
      setIsfreelnacer(false)
    }
  }, []);

  return (
    <div>
      {isfreelnacer ? <FreelancerDetails/> : <ClientDetails />}
    </div>
  );
};

export default Profile;
