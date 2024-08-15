const fadeSection = document.querySelector('.sliding-line');
const initialHeight = 40; // Initial height of the sliding-line element

// Function to handle the scroll effect
const handleScroll = () => {
    const scrollPosition = window.scrollY;
    const windowHeight = window.innerHeight;

    // Calculate the fade effect
    const fadeEffect = Math.min(scrollPosition / windowHeight, 1);

    // Calculate the height effect
    const heightEffect = Math.max(1 - fadeEffect, 0);

    // Apply styles with transitions for smooth effects
    fadeSection.style.opacity = 1 - fadeEffect;
    fadeSection.style.height = `${initialHeight * heightEffect}px`;

    // Use display instead of visibility if you want to remove the element from the layout
    fadeSection.style.display = fadeEffect === 1 ? 'none' : 'flex'; // Ensure display is 'flex' to preserve layout
};

// Add event listener for scroll event
window.addEventListener('scroll', () => {
    requestAnimationFrame(handleScroll);
});