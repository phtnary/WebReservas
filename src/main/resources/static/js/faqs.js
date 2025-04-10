
window.onload = function() {
  // Seleccionamos el elemento del mensaje
  const message = document.getElementById('message');

  // Agregamos la clase 'show' para mostrar el mensaje
  setTimeout(function() {
    message.classList.add('show');
  }, 1000); // El mensaje aparecerá después de 1 segundo (1000 ms)
};
