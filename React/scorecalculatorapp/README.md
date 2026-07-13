# Score Calculator App

This project is a React application built as part of the React Hands-On Lab (Student Management Portal).

## Features
- **CalculateScore**: A functional component that accepts `Name`, `School`, `total`, and `goal` as props.
- **Score Calculation**: Automatically calculates the average percentage score of a student using the formula `total/goal` and formats it as a percentage with two decimal places (e.g. `94.67%`).
- **Styling**: Structured styles applied via a separate CSS stylesheet `mystyle.css` with color coding for different details (Name, School, Total, Score).

## Project Structure
- `src/Components/CalculateScore.js`: The functional component doing the calculation and rendering.
- `src/Stylesheets/mystyle.css`: Styling for the student details display.
- `src/App.js`: Root component that imports and renders `CalculateScore` with test props.

## How to Run
In the project directory, run:
```bash
npm start
```
This runs the app in development mode. Open [http://localhost:3000](http://localhost:3000) to view it in the browser.
