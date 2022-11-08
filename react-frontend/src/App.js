import React from 'react';
import { BrowserRouter, Navigate, Route, Routes} from 'react-router-dom'
import UploadFileComponent from './components/UploadFileComponent';
import JustifierAndExtraHoursComponent from './components/JustifierAndExtraHoursComponent';
import SpreadsheetComponent from './components/SpreadsheetComponent';

function App() {
  return (
    <div>
      <BrowserRouter>
          <Routes>
            <Route path="/" element={<UploadFileComponent />} />
            <Route path="/justifier-and-extra-hours" element={<JustifierAndExtraHoursComponent />} />
            <Route path="/spreadsheet" element={<SpreadsheetComponent />} />
            <Route path="*" element={<Navigate replace to="/" />} />
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
