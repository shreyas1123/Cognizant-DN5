import React from 'react';
import styles from './CohortDetails.module.css';

export default function CohortDetails({ cohort }) {
  // Inline dynamic color style based on status: "ongoing" is green, others are blue
  const isOngoing = cohort.status.toLowerCase() === 'ongoing';
  const headingStyle = {
    color: isOngoing ? 'green' : 'blue',
    fontWeight: 'bold',
    fontSize: '18px',
    marginBottom: '15px'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{cohort.title}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        
        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>
        
        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>
        
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}
