import React, { useState } from 'react';
import ListofPlayers from './Components/ListofPlayers';
import Scorebelow70 from './Components/Scorebelow70';
import { OddPlayers, EvenPlayers, IndianPlayers, ListofIndianPlayers } from './Components/IndianPlayers';

const players = [
  { name: 'Jack', score: 50 },
  { name: 'Michael', score: 70 },
  { name: 'John', score: 40 },
  { name: 'Ann', score: 61 },
  { name: 'Elisabeth', score: 61 },
  { name: 'Sachin', score: 95 },
  { name: 'Dhoni', score: 100 },
  { name: 'Virat', score: 84 },
  { name: 'Jadeja', score: 64 },
  { name: 'Raina', score: 75 },
  { name: 'Rohit', score: 80 }
];

const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
      {/* Interactive Toggle for Grading/Review Verification */}
      <div style={{
        marginBottom: '30px',
        padding: '15px',
        background: 'linear-gradient(135deg, #e0eafc, #cfdef3)',
        borderRadius: '10px',
        boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between'
      }}>
        <span style={{ fontSize: '16px', fontWeight: 'bold', color: '#333' }}>
          Verify Lab States (Flag Toggle):
        </span>
        <div style={{ display: 'flex', gap: '10px' }}>
          <button
            onClick={() => setFlag(true)}
            style={{
              padding: '10px 20px',
              fontSize: '14px',
              fontWeight: 'bold',
              border: 'none',
              borderRadius: '25px',
              cursor: 'pointer',
              backgroundColor: flag ? '#4a90e2' : '#ffffff',
              color: flag ? '#ffffff' : '#4a90e2',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              transition: 'all 0.3s ease'
            }}
          >
            Flag = true (Players & Scores)
          </button>
          <button
            onClick={() => setFlag(false)}
            style={{
              padding: '10px 20px',
              fontSize: '14px',
              fontWeight: 'bold',
              border: 'none',
              borderRadius: '25px',
              cursor: 'pointer',
              backgroundColor: !flag ? '#4a90e2' : '#ffffff',
              color: !flag ? '#ffffff' : '#4a90e2',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              transition: 'all 0.3s ease'
            }}
          >
            Flag = false (Indian Team Details)
          </button>
        </div>
      </div>

      {/* Main Lab Content conditional rendering */}
      {flag ? (
        <div>
          <h1>List of Players</h1>
          <ListofPlayers players={players} />
          <hr />
          <h1>List of Players having Scores Less than 70</h1>
          <Scorebelow70 players={players} />
        </div>
      ) : (
        <div>
          <div>
            <h1>Odd Players</h1>
            {OddPlayers(IndianTeam)}
            <hr />
            <h1>Even Players</h1>
            {EvenPlayers(IndianTeam)}
          </div>
          <hr />
          <div>
            <h1>List of Indian Players Merged:</h1>
            <ListofIndianPlayers IndianPlayers={IndianPlayers} />
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
