import React, { useEffect, useState } from 'react';
import './projectCard.css'; // Import CSS for styling
import ExpandProject from '../ExpandProject/ExpandProject'; // Import ExpandProject component
// import AppliedPeople from '../ExpandProject/Popups/AppliedPeople/AppliedPeople';
import AppliedPeople from '../ExpandProject/Popups/AppliedPeople/AppliedPeople';

const ProjectCard = ({ from, project }) => {
  const [expanded, setExpanded] = useState(false);
  const [expandApplied, setExpandApplied] = useState(false);
  const [expandChoose, setExpandChoose] = useState(false);
  const [projectData, setProjectData] = useState({});
  const [isclient, setisclient] = useState(false);
  const appliedPeople = () => {
    alert("List of people applied to project");
    console.log("List of people applied to project");
    setExpandApplied(true);
  };

  const choosePeople = () => {
    console.log("Choose people for project");
    setExpandChoose(true);
  };

//   const projectData = {
//     projectId: 1,
//     domain: "Web Development",
//     title: "E-commerce Website Development",
//     description: "Build a fully functional e-commerce website with features like product listings, shopping cart, user authentication, payment gateway integration, and admin dashboard.",
//     technology: ["React", "Node.js", "Express", "MongoDB"],
//     budget: 5000,
//     negotiateBudget: true,
//     noOfHours: 80,
//     daysLimit: 30,
//     comfortTimeFrom: "09:00:00",
//     comfortTimeTo: "17:00:00",
//     timezone: "GMT+5:30",
//     clientEmail: "client@example.com"
// };


  const toggleExpand = () => {
    setExpanded(!expanded);
  };

  useEffect(() => {
    console.log("from");
    console.log(project.technology);
    project.technology1 = JSON.parse(project.technology);
    setProjectData(project);
    localStorage.getItem("role") === "client" ? setisclient(true) : setisclient(false);
  }, []);

  return (
    <div className="widget">
      <h2>{projectData.title}</h2>
      <div className={`description`}>
        {projectData.description}
      </div>
      <div className='show-more-whole'>
        {isclient && <button onClick={appliedPeople} className="show-more">
          show Applied People
        </button> }
        {isclient && <button onClick={choosePeople} className="show-more">
          Show Recommendation
        </button>}
        <button onClick={toggleExpand} className="show-more">
          Show more
        </button>
        
      </div>
      {expanded && (
          <ExpandProject {...projectData} setExpanded={setExpanded} from={from}/>
        )}

        {expandApplied && 
          <AppliedPeople freelancer_details={[]} setExpandApplied={setExpandApplied} projectId={projectData.projectId}/>
        }

        {expandChoose && 
          <AppliedPeople freelancer_details={[]} setExpandChoose={setExpandChoose} projectId={projectData.projectId} />
        }
    </div>
  );
};

export default ProjectCard;
