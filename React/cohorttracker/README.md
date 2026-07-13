# Cohorts Tracker React Project

This project is a React application built for the React Hands-On Lab. It showcases the use of React CSS Modules and Inline styling rules.

## Implemented Features

1. **Cohorts Dashboard Container**:
   - Outlines and organizes ongoing and completed cohorts.
   
2. **Dynamic Inline Styles**:
   - Conditional coloring applied directly on the cohort title `<h3>`: uses a `green` font when the cohort status is `ongoing` and a `blue` font for all other statuses (`Scheduled`, etc.).

3. **CSS Modules styling**:
   - Employs `CohortDetails.module.css` scoping the `.box` class with specified styling for card boxes.
   - Leverages a top-level HTML `dt` tag selector within the CSS module to specify font weight for description lists.

4. **Structured Markup**:
   - Uses description lists (`<dl>`, `<dt>`, `<dd>`) for alignment of cohort metadata.

## Getting Started

To run the application locally:

1. Navigate to the project folder:
   ```bash
   cd React/cohorttracker
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
