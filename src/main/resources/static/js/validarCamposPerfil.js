window.addEventListener("load",iniciar);


function iniciar(){
   confirmar.addEventListener("click",enviarForm);
}


function  enviarForm (e){
	
	//Resetear mensajes de error
	
	if ( errorTelefono.value!=""){
	      errorTelefono.innerHTML="";
	}
	if (  errorApellido.value!=""){
		     errorApellido.innerHTML="";
	}
	if ( errorNombre.value!=""){
		     errorNombre.innerHTML="";
	}

  let pasaValidacionNomApe=validarNombreApellido();
  let pasaValidacionTel=validarTelefono();
 
  

	 let pasaValidacion= pasaValidacionNomApe && pasaValidacionTel;
	       
	   
	   if (pasaValidacion){
	      return true;
	   }else {
	       e.preventDefault();
	       return false;
	   }
	   
}

function validarTelefono (){
	
	var patronTelefono= /^\d{9}$/;
	   
	   if (patronTelefono.test(telefono.value)==false){
	       telefono.focus();
	       errorTelefono.innerHTML+="Debe introducir un número de 9 cifras<br>";
	       return false;    
	           
	   }else{
	        return true;
	   }
}

function validarNombreApellido(){
    
              
    //patrón para la validación de campos.
    //Letras y espacios en blanco 
    var patron=/^[A-Za-zÑñáéíóú\s]+$/;
    
    var apellidoFlag;
    var nombreFlag;
    if (patron.test(apellidos.value)==false){
        errorApellido.innerHTML+="El apellido no es correcto<br>";
        apellidos.focus();
    } else {
        apellidoFlag =true;
        
    }
    
    if (patron.test(nombre.value)==false){
        errorNombre.innerHTML+="El nombre no es correcto<br>";
        nombre.focus();
    } else {
        nombreFlag =true;
    }
    
    
    if (apellidoFlag==true && nombreFlag==true){
        
        return true;
    }else{
        return false;
    }
    
}






