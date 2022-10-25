import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent';
import HomeComponent from './components/HomeComponent';

function App() {
  return (
    <div>
      <Router>
        <layout>
          <Routes>
            <Route path="/" element={<HomeComponent />} />
          </Routes>
        </layout>
      </Router>
    </div>
  );
}

export default App;
