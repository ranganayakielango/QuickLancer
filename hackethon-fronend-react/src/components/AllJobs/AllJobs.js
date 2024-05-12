// create basic react components

import React, {useState} from 'react';
import OnGoing from './Ongoing/Ongoing';
import InProgress from './InProgress/InProgress';
import Completed from './Completed/Completed';

const AllJobs = () => {
  const [activeNav, setActiveNav] = useState('home'); // State to track active navigation

  const handleNavClick = (navItem) => {
    setActiveNav(navItem);
  };

  
  return (
    <div className='find-job-body'>
      <nav className="navbar">
        <ul className="nav-list">
          <li>
            <a
              href="#ongoing"
              className={activeNav === 'ongoing' ? 'active' : ''}
              onClick={() => handleNavClick('ongoing')}
            >
              Ongoing
              
            </a>
          </li>
          <li>
            <a
              href="#inprogress"
              className={activeNav === 'inprogress' ? 'active' : ''}
              onClick={() => handleNavClick('inprogress')}
            >
              Inprogress
            </a>
          </li>
          <li>
            <a
              href="#Completed"
              className={activeNav === 'Completed' ? 'active' : ''}
              onClick={() => handleNavClick('Completed')}
            >
              Completed
            </a>
          </li>
        </ul>
      </nav>

      <div>
        {activeNav === 'ongoing' && (
          <OnGoing />
        )}
        {activeNav === 'Inprogress' && (
          <InProgress />
        )}
        {activeNav === 'completed' && (
          <Completed />
        )}
      </div>
    </div>

  );
}

export default AllJobs;