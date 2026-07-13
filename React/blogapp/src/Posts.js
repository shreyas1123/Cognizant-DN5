import React from 'react';
import Post from './Post';
import './Posts.css';

// Helper component that throws an error when error state is set.
// This allows the parent component (Posts) to catch async errors using componentDidCatch.
const ErrorThrower = ({ error }) => {
    if (error) {
        throw error;
    }
    return null;
};

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Map the results to Post objects
                const postsList = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: postsList });
            })
            .catch(error => {
                // Set error state to trigger rendering throw which is caught by componentDidCatch
                this.setState({ error: error });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        // Display error message as alert as requested by the PDF
        alert('Error occurring in the component: ' + error.message);
    }

    render() {
        return (
            <div className="posts-container">
                {/* Under React's error boundary, if ErrorThrower throws, componentDidCatch below will catch it */}
                <ErrorThrower error={this.state.error} />
                <h1 className="blog-title">Blog Posts</h1>
                <div className="posts-list">
                    {this.state.posts.map(post => (
                        <div key={post.id} className="post-card">
                            <h3 className="post-title">{post.title}</h3>
                            <p className="post-body">{post.body}</p>
                        </div>
                    ))}
                </div>
            </div>
        );
    }
}

export default Posts;
