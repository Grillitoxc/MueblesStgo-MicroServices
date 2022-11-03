import React from 'react';
import { BrowserRouter, Navigate, Route, Routes} from 'react-router-dom'
import HomeComponent from './components/HomeComponent';
import UploadFileComponent from './components/UploadFileComponent';
import JustifierAndExtraHoursComponent from './components/JustifierAndExtraHoursComponent';

function App() {
  return (
    <div>
      <BrowserRouter>
          <Routes>
            <Route path="/" element={<HomeComponent />} />
            <Route path="/upload" element={<UploadFileComponent />} />
            <Route path="/justifier-and-extra-hours" element={<JustifierAndExtraHoursComponent />} />
            <Route path="*" element={<Navigate replace to="/" />} />
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
