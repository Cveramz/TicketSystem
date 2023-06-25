document.querySelector('form').addEventListener('submit', function(event) {
    var correoInput = document.getElementById('exampleInputEmail');
    var correo = correoInput.value;
    
    if (correo.indexOf('@usach.cl') === -1) {
      event.preventDefault();
      alert('No se ha detectado su correo institucional, recuerde que debe ser @usach.cl\nIngrese nuevamente su correo de forma correcta por favor');
    }
  });
  

  document.querySelector('form').addEventListener('submit', function(event) {
    var contrasenaInput = document.getElementById('examplePasswordInput');
    var contrasena = contrasenaInput.value;
    
    if (contrasena.length < 6) {
      event.preventDefault();
      alert('La contraseña debe tener al menos 6 caracteres por su seguridad.\nIngrese nuevamente su contraseña por favor');
    }
  });


//ahora verificaremos si son iguales las contraseñas
//el primer id de password es examplePasswordInput
//el segundo id de password es exampleRepeatPasswordInput

document.querySelector('form').addEventListener('submit', function(event) {
    var contrasenaInput = document.getElementById('examplePasswordInput');
    var contrasena = contrasenaInput.value;
    var contrasenaInput2 = document.getElementById('exampleRepeatPasswordInput');
    var contrasena2 = contrasenaInput2.value;
    
    if (contrasena != contrasena2) {
      event.preventDefault();
      alert('Las contraseñas no coinciden.\nIngrese nuevamente su contraseña por favor');
    }
  });
