import React, { useState } from 'react';

export default function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const numAmount = parseFloat(amount) || 0;
    const convertedAmount = numAmount * 80; // conversion rate is 80
    alert(`Converting to : ${currency} Amount is ${convertedAmount}`);
  };

  return (
    <div className="converter-container">
      <div className="converter-title">Currency Convertor!!!</div>
      <form onSubmit={handleSubmit}>
        <div className="form-row">
          <label>Amount:</label>
          <input
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </div>
        <div className="form-row">
          <label>Currency:</label>
          <input
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
}
