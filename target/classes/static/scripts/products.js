 // Add event listeners to product cards
 document.querySelectorAll('.product-card').forEach(card => {
  card.addEventListener('mouseover', () => {
      // Animate product card on hover
      card.classList.add('animate');
  });

  card.addEventListener('mouseout', () => {
      // Remove animation on mouseout
      card.classList.remove('animate');
  });

  card.addEventListener('click', () => {
      // Animate product card on click
      card.classList.add('animate-click');
  });
});

// Add event listener to "Add to Cart" buttons
document.querySelectorAll('.product-card button').forEach(button => {
  button.addEventListener('click', () => {
      // Animate "Add to Cart" button on click
      button.classList.add('animate-add-to-cart');
  });
});

// Add event listener to newsletter form
document.querySelector('.newsletter-form').addEventListener('submit', () => {
  // Animate newsletter form on submit
  document.querySelector('.newsletter-form button[type="submit"]').classList.add('animate-submit');
});