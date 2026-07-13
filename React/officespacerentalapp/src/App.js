import React from 'react';
import './index.css';

const officeSpaces = [
  { Name: "DBS", Rent: 50000, Address: "Chennai" },
  { Name: "Commons", Rent: 75000, Address: "Bangalore" },
  { Name: "Regus", Rent: 45000, Address: "Mumbai" }
];

function App() {
  const element = "Office Space";
  const sr = "office.png";
  const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;

  return (
    <div style={{ padding: '20px' }}>
      {/* Page Heading */}
      <h1>{element} , at Affordable Range</h1>
      
      <div style={{ display: 'flex', flexDirection: 'column', gap: '30px', marginTop: '20px' }}>
        {officeSpaces.map((item, index) => {
          // Conditional class selection based on the rent value
          const rentClass = item.Rent <= 60000 ? 'textRed' : 'textGreen';
          
          return (
            <div key={index} style={{ borderBottom: '1px solid #eaeaea', paddingBottom: '30px' }}>
              {jsxatt}
              <h1>Name: {item.Name}</h1>
              <h3 className={rentClass}>Rent: Rs. {item.Rent}</h3>
              <h3>Address: {item.Address}</h3>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;
