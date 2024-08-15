window.onload = function() {
    // Select the loader and content elements
    const loader = document.getElementById('loader');
    const content = document.querySelector(".everything-without-loader")

    // Hide the loader and show the content
    loader.style.display = 'none';
    content.style.display = 'block';
};