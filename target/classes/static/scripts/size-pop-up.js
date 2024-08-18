// scripts.js
document.addEventListener("DOMContentLoaded", function() {
    var modal = document.getElementById("myModal");
    var btn = document.getElementById("showModalBtn");
    var span = document.getElementsByClassName("close")[0];
    var spantwo = document.getElementsByClassName("close")[1];
    var help = document.getElementById("measure-help");
    var helpModal = document.getElementById("modal-help");
    var width = document.getElementById("width");
    var length = document.getElementById("length");
    var height = document.getElementById("height");
    var widthField = document.getElementById("width-span");
    var lengthField = document.getElementById("length-span");
    var heightField = document.getElementById("height-span");

    btn.onclick = function() {
        modal.style.display = "block";
        modal.style.animation = "fadeIn 0.5s";
        document.body.classList.add("no-scroll");
        widthField.textContent=width.textContent;
        heightField.textContent=height.textContent;
        lengthField.textContent=length.textContent;
    }
    help.onclick = function(){
        closeModal();
        helpModal.style.display = "block";
        helpModal.style.animation = "fadeIn 0.5s";
        document.body.classList.add("no-scroll");
    }

    span.onclick = function() {
        closeModal();
    }
    spantwo.onclick = function() {
        closeHelp();
        modal.style.display = "block";
        modal.style.animation = "fadeIn 0.5s";
        document.body.classList.add("no-scroll");
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            closeModal();
        }
    }

    function closeModal() {
        modal.style.animation = "fadeOut 0.5s";
        setTimeout(function() {
            modal.style.display = "none";
            document.body.classList.remove("no-scroll");
        }, 500);
    }
    function closeHelp(){
        helpModal.style.animation = "fadeOut 0.5s";
        setTimeout(function() {
            helpModal.style.display = "none";
            document.body.classList.remove("no-scroll");
        }, 500);
    }
});
