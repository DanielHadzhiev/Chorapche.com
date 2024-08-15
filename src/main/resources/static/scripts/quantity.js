document.addEventListener('DOMContentLoaded', function() {
    // Get references to the elements
    const h1Element = document.getElementById('productName');
    const productInputElement = document.getElementById('productInput');
    const quantityInput = document.getElementById('quantity-input');

    // Synchronize the input field with the H1 text content
    productInputElement.value = h1Element.textContent;
    quantityInput.value=1;

});

document.addEventListener('DOMContentLoaded', function() {
    const quantitySpan = document.getElementById('quantity');
    const quantityInput = document.getElementById('quantity-input');
    const upButton = document.querySelector('.quantity-btn.up');
    const downButton = document.querySelector('.quantity-btn.down');

    upButton.addEventListener('click', function() {
        let currentQuantity = parseInt(quantitySpan.textContent);
        quantitySpan.textContent = currentQuantity + 1;
        quantityInput.value = quantitySpan.textContent;
    });

    downButton.addEventListener('click', function() {
        let currentQuantity = parseInt(quantitySpan.textContent);
        if (currentQuantity > 1) {
            quantitySpan.textContent = currentQuantity - 1;
            quantityInput.value = quantitySpan.textContent;
        }
    });
});
