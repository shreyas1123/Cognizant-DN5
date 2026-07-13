import React, { useState } from 'react';
import CurrencyConvertor from './Components/CurrencyConvertor';
import './index.css';

function App() {
  const [counter, setCounter] = useState(5);

  // Method to increment counter and trigger static greeting alert
  const handleIncrement = () => {
    setCounter(prev => prev + 1);
    alert("Hello! Member1");
  };

  // Method to decrement counter
  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  // Method accepting argument message
  const handleSayWelcome = (msg) => {
    alert(msg);
  };

  // Method triggered on synthetic click event
  const handleSyntheticClick = (e) => {
    alert("I was clicked");
  };

  return (
    <div>
      {/* Counter Value Display */}
      <div className="counter-display">{counter}</div>
      
      {/* Event Buttons */}
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <button onClick={() => handleSayWelcome('welcome')}>Say welcome</button>
      <button onClick={handleSyntheticClick}>Click on me</button>
      
      {/* Currency Converter Component */}
      <CurrencyConvertor />
    </div>
  );
}

export default App;
