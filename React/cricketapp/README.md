# Cricket App React Project

This project is a React application built for the React Hands-On Lab. It showcases the use of various ES6 features within a React context.

## Implemented Features

1. **List of Players**:
   - Declares an array of 11 players.
   - Maps over the array and renders names and scores using the ES6 `map` feature.

2. **Filtered Player Scores**:
   - Filters players with scores less than or equal to 70 using ES6 arrow functions and mapping.

3. **Indian Players (Odd/Even Destructuring & Array Merging)**:
   - Destructures arrays using the ES6 Destructuring pattern for odd/even players (`OddPlayers` and `EvenPlayers` components).
   - Combines T20 and Ranji player lists using the ES6 Spread/Merge operator (`[...T20Players, ...RanjiTrophyPlayers]`).
   - Renders the merged team array using `ListofIndianPlayers`.

4. **Lab View Toggle**:
   - Conditional rendering utilizing the `flag` variable. An interactive header component enables switching between `flag = true` and `flag = false` to easily view both lab output states.

## Getting Started

To run the application locally:

1. Navigate to the project folder:
   ```bash
   cd React/cricketapp
   ```
2. Install the dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
4. Build for production:
   ```bash
   npm run build
   ```
