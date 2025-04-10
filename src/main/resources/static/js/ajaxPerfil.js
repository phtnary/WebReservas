window.addEventListener("load",iniciar);


function iniciar(){
	gestionarMensajeTieneReserva();
	gestionarMensajeReservaOk();
}





function gestionarMensajeTieneReserva(){
	
	
	var xhr= new XMLHttpRequest();

	xhr.open("GET", "http://localhost:8080/comprobarTieneReservas", true);

	xhr.addEventListener("readystatechange",funcionMensajeTieneReserva);

	xhr.send();

	
}

function funcionMensajeTieneReserva(){
		if(this.readyState==4 & this.status==200){ 
			let response=this.responseText;
			if(response!="" && response!=null){
				alert(response);
				resetearMensajeTieneReservas();
			}
		}
	}

function resetearMensajeTieneReservas(){
	
	var xhr= new XMLHttpRequest();

		xhr.open("GET", "http://localhost:8080/resetearMensajeTieneReservas", true);
		
		xhr.send();
}

////////////////////////////////////////////////////////

// Llamada Ajax para obtener mensaje de la reserva ha sido confirmada.

function gestionarMensajeReservaOk(){
	
	
	var xhr= new XMLHttpRequest();

	xhr.open("GET", "http://localhost:8080/confirmarReservaOk", true);

	xhr.addEventListener("readystatechange",funcionMensajeReservaOk);

	xhr.send();

	
}

function funcionMensajeReservaOk(){
	
		if(this.readyState==4 & this.status==200){ 
			let response=this.responseText;
			if(response!="" && response!=null){
				alert(response);
				resetearMensajeReservaOk();
			}
		}
	}

function resetearMensajeReservaOk(){
	
	var xhr= new XMLHttpRequest();

		xhr.open("GET", "http://localhost:8080/resetearMensajeReservaOk", true);
		
		xhr.send();
}

 

