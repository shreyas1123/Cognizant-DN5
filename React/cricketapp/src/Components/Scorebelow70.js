import React from 'react';

export default function Scorebelow70({ players }) {
  const players70 = [];
  
  // Filtering using arrow functions of ES6, as specified
  players.map((item) => {
    if (item.score <= 70) {
      players70.push(item);
    }
    return null;
  });

  return (
    <ul>
      {players70.map((item, index) => {
        return (
          <div key={index}>
            <li>Mr. {item.name}<span> {item.score}</span></li>
          </div>
        );
      })}
    </ul>
  );
}
