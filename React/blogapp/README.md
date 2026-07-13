# Blog App

This project is a React application built as part of the React Hands-On Lab (Component Lifecycle & Fetch API).

## Features
- **Post Class**: A custom ES6 JavaScript data class `Post` to represent single posts.
- **Posts Component**: A class-based React component that:
  - Initializes state in its constructor.
  - Implements a custom `loadPosts()` method using the native Fetch API to call [https://jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts).
  - Triggers the fetch automatically in the `componentDidMount()` lifecycle hook.
  - Uses `componentDidCatch(error, info)` to capture any rendering errors and display them as alert messages.
  - Renders the fetched posts in a beautiful cards layout with headings and paragraphs.

## Project Structure
- `src/Post.js`: ES6 class model representing a Post.
- `src/Posts.js`: Class component loading, catching, and displaying posts.
- `src/Posts.css`: Styling for the blog posts layout (using rich, modern dark-themed aesthetics).
- `src/App.js`: Root React component containing the `<Posts />` layout.

## How to Run
In the project directory, run:
```bash
npm start
```
This runs the app in development mode. Open [http://localhost:3000](http://localhost:3000) to view it in the browser.
