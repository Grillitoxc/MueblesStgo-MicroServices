import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomeComponent from './components/HomeComponent';
import UploadFileComponent from './components/UploadFileComponent';

function App() {
  return (
    <div>
      <Router>
        <layout>
          <Routes>
            <Route path="/" element={<HomeComponent />} />
            <Route path="/upload" element={<UploadFileComponent />} />
            
          </Routes>
        </layout>
      </Router>
    </div>
  );
}

export default App;
