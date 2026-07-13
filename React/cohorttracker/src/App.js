import React from 'react';
import CohortDetails from './Components/CohortDetails';

const cohorts = [
  {
    title: 'INTADMDF10 -.NET FSD',
    startDate: '22-Feb-2022',
    status: 'Scheduled',
    coach: 'Aathma',
    trainer: 'Jojo Jose'
  },
  {
    title: 'ADM21JF014 -Java FSD',
    startDate: '10-Sep-2021',
    status: 'Ongoing',
    coach: 'Apoorv',
    trainer: 'Elisa Smith'
  },
  {
    title: 'CDBJF21025 -Java FSD',
    startDate: '24-Dec-2021',
    status: 'Ongoing',
    coach: 'Aathma',
    trainer: 'John Doe'
  }
];

function App() {
  return (
    <div style={{ padding: '30px', backgroundColor: '#f0f2f5', minHeight: '100vh', fontFamily: 'Arial, sans-serif' }}>
      <div style={{
        maxWidth: '1000px',
        margin: '0 auto',
        border: '1px solid #dcdcdc',
        borderRadius: '8px',
        padding: '30px',
        backgroundColor: '#ffffff',
        boxShadow: '0 4px 6px rgba(0, 0, 0, 0.05)'
      }}>
        <h2 style={{
          marginTop: 0,
          marginBottom: '35px',
          fontSize: '28px',
          fontWeight: 'bold',
          color: '#000000',
          fontFamily: 'Segoe UI, Helvetica, Arial, sans-serif'
        }}>
          Cohorts Details
        </h2>
        
        {/* Standard block containing inline-block components */}
        <div style={{ textAlign: 'left' }}>
          {cohorts.map((cohort, index) => (
            <CohortDetails key={index} cohort={cohort} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
