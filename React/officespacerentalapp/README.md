# Office Space Rental React Project

This project is a React application built for the React Hands-On Lab. It showcases the use of JSX syntax, attributes, object lists, list mapping, and conditional inline/CSS styling.

## Implemented Features

1. **Heading Element**:
   - Renders a page header using JSX expression: `{element} , at Affordable Range`.

2. **Image Element**:
   - Loads a modern, generated office workspace image (`office.png`) with specified width and height attributes.

3. **Office List & Mapping**:
   - Loops through an array of office space objects containing `Name`, `Rent`, and `Address`.

4. **Conditional Styling**:
   - Rent is highlighted in **Red** if it is below or equal to 60,000 using the `.textRed` class.
   - Rent is highlighted in **Green** if it is above 60,000 using the `.textGreen` class.

## Getting Started

To run the application locally:

1. Navigate to the project folder:
   ```bash
   cd React/officespacerentalapp
   ```
2. Install the dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
