import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomeComponent from './components/HomeComponent';
import UploadFileComponent from './components/UploadFileComponent';
import JustifierAndExtraHoursComponent from './components/JustifierAndExtraHoursComponent';

function App() {
  return (
    <div>
      <Router>
          <Routes>
            <Route path="/" element={<HomeComponent />} />
            <Route path="/upload" element={<UploadFileComponent />} />
            <Route path="/justifier-and-extra-hours" element={<JustifierAndExtraHoursComponent />} />
          </Routes>
      </Router>
    </div>
  );
}

export default App;
