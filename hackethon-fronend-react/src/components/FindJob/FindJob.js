import React, { useEffect, useState } from 'react';
import './findJob.css';
import ProjectCard from '../Shared/ProjectCard/ProjectCard';
const FindJob = () => {
  const [activeNav, setActiveNav] = useState('home'); // State to track active navigation
  const [data, setData] = useState([]); // State to store data from API
  const handleNavClick = (navItem) => {
    setActiveNav(navItem);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        let email = localStorage.getItem('email');
        email = "jackmandy@gmail.com"
        const response = await fetch(
          
          `https://f6ad-103-6-159-161.ngrok-free.app/matching-client?fid=${email}`,
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
            `https://6358-121-242-242-226.ngrok-free.app/project/${key}`
          );
          if (!response.ok) {
            throw new Error("Failed to fetch data");
          }
          console.log("before json conversion")
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

    fetchData();
  }, []);

  return (
    <div className='ongoing-container'>
      {/* looop through and build projectcard */}
      {data && Array.isArray(data) && data.map((project)=>{
        return <ProjectCard from="freelancer" project={project}  />
      })}
      </div>

  );
};

export default FindJob;
{/* <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer"heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/>
      <ProjectCard from="freelancer" heading="This is heading" description="I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json' 0I was stuck on same issue for hours now figure out exact solution for this as mentioned in documentation of expressjs @Quentin has pointed towards exact issue. Here I am posting some more details so it may help someone else to resolve this issue quickly. When you are posting JSON object with 'Content-Type':'application/json' fetch or any other method browser will request for CORS setting first for security reason then if it receives CORS options which is very easy to achieve. Then it will post original object to server as NodeJS server is waiting for 'Content-Type':'application/json'"/> */}
    