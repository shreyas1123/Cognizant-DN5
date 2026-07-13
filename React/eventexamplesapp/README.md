# Event Examples React Project

This project is a React application built for the React Hands-On Lab. It showcases the use of stateful React event handling, passing arguments to handlers, multiple methods triggered by a single event, synthetic event properties, and a custom currency converter form.

## Implemented Features

1. **Stateful Counter**:
   - `Increment` button: Increases the counter value state and alerts a static message (`Hello! Member1`) in sequential handlers.
   - `Decrement` button: Decreases the counter value state.

2. **Parameter-driven Handlers**:
   - `Say welcome` button: Calls an event handler passing a custom string (`"welcome"`) to display as a browser alert.

3. **Synthetic Events**:
   - `Click on me` button: Triggers an onClick event calling a synthetic event handler displaying `"I was clicked"`.

4. **Currency Converter Component**:
   - Implements a form inside `CurrencyConvertor.js` with fields for `Amount` and `Currency`.
   - On submission, alerts the converted value (Rupees to Euro rate factor of 80) e.g., `Converting to : Euro Amount is 6400` when Amount is 80.

## Getting Started

To run the application locally:

1. Navigate to the project folder:
   ```bash
   cd React/eventexamplesapp
   ```
2. Install the dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
