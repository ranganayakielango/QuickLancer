import "./App.css";
import { Routes, Route } from "react-router-dom";
import Login from "./components/Login/Login";
import Header from "./components/Header/Header";
import Signup from "./components/Signup/Signup";
import Sidebar from "./components/Sidebar/Sidebar";
import Home from "./components/Home/Home";
import Profile from "./components/Profile/Profile";
import FindJob from "./components/FindJob/FindJob";
import CreateJob from "./components/CreateJob/CreateJob";
import AllJobs from "./components/AllJobs/AllJobs";
function App() {
  return (
    <div className="app">
      <Header />
      <div className="main-content">
        <Sidebar />
        <div className="sidebar-right">
          <Routes>
            <Route path="login" element={<Login />} />
            <Route path="signup" element={<Signup />} />
            <Route path="home" element={<Home />} />
            <Route path="profile" element={<Profile />} />
            <Route path="find-job" element={<FindJob />} />
            <Route path="create-job" element={<CreateJob />} />
            <Route path="all-jobs" element={<AllJobs />} />

          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
