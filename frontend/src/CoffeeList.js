import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CoffeeList() {
  const [coffees, setCoffees] = useState([]);
  const [error, setError] = useState(null); // Add state to handle errors

  useEffect(() => {
    axios.get('http://localhost:8080/API/coffee')
      .then(response => {
        setCoffees(response.data);
        setError(null); // Clear any previous errors
      })
      .catch(error => {
        console.error('Error fetching coffee:', error);
        setError('Error fetching coffee. Please check if the server is running.'); 
      });
  }, []); 

  return (
    <div>
      <h2>Coffee List</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>} {/* Display error message */}
      <ul>
        {coffees.map(coffee => (
          <li key={coffee.id}>
            {coffee.name} ({coffee.size})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CoffeeList;
