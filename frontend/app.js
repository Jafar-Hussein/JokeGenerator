const generateBtn = document.querySelector('#joke-generator');
const jokeElement = document.querySelector('#joke');

generateBtn.addEventListener('click', () => {
    fetch('http://localhost:8080/api/v1/joke/getJoke')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        jokeElement.textContent = data.joke;
      })
      .catch(error => {
        console.error('Error:', error);
      });
      
  });