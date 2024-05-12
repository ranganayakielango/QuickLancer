// create basic react components
import ProjectCard from '../../Shared/ProjectCard/ProjectCard';
import React, {useEffect, useState } from 'react';

const OnGoing = () => {
  const [data, setData] = useState([]);
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
}

export default OnGoing;