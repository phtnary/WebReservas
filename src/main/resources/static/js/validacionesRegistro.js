window.addEventListener("load",iniciar);


function iniciar(){
   enviar.addEventListener("click",enviarForm);
   email.addEventListener("blur",confirmarExisteEmailServidor);
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
	if ( errorEmail.value!=""){
		     errorEmail.innerHTML="";
	}
	if ( errorEmail2.value!=""){
		   errorEmail2.innerHTML="";
	}
	
	
	if ( errorPassword.value!=""){
		 errorPassword.innerHTML="";
	}
	
	
	
	
  let pasaValidacionNomApe=validarNombreApellido();
  let pasaValidacionTel=validarTelefono();
  let pasaValidacionEmail=validarEmail();
  let pasaValidacionEmail2=verifEmail2();
  let pasaValidacionPassword=verificaPassword(); 
  
		
	

	 let pasaValidacion= pasaValidacionPassword
	 && pasaValidacionNomApe && pasaValidacionEmail && pasaValidacionTel 
	 && pasaValidacionEmail2;
	       
	   
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


function validarEmail(){
    var patronEmail=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/;
    
    if (patronEmail.test(email.value)==false){
        email.focus();
        errorEmail.innerHTML+="El email no es correcto<br>";
        return false;
    }else{
        return true;
    }  
}

function verifEmail2(){
	if(email.value != email2.value){
			errorEmail2.innerHTML+="Los emails no son iguales<br>";
			return false;                
	    }else{
	         return true;
	    }
	
}

function verificaPassword(){
	if(password.value != password2.value){
		errorPassword.innerHTML+="Las contraseñas no son iguales<br>";
		return false;                
    }else{
         return true;
    }
}

function confirmarExisteEmailServidor(){
	
	var emailIntroducido=email.value;
	
	var xhr= new XMLHttpRequest();

		xhr.open("GET", "http://localhost:8080/confirmarEmailServidor?email="+emailIntroducido, true);

		xhr.addEventListener("readystatechange",funcionAjax);


		function funcionAjax(){
			if(this.readyState==4 & this.status==200){ 
				errorEmailServidor.innerHTML=this.responseText;
				
			}		
		}
		
		xhr.send();
		
	}

