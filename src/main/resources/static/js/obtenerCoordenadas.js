function mostrarDatosMapa (datosJson){
	
	let arrayDatosMapa =JSON.parse(datosJson);

	//Se centra el mapa con la primera posición del array de coordenadas 
	
	let map = L.map('map').setView([arrayDatosMapa[0].latitud, arrayDatosMapa[0].longitud], 13);
	
	L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
	    maxZoom: 19,
	    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
	}).addTo(map);
	
	
	
	 for(let i=0; i<arrayDatosMapa.length;i++){
		
		let marker = L.marker([arrayDatosMapa[i].latitud, arrayDatosMapa[i].longitud]).addTo(map);
		marker.bindPopup(arrayDatosMapa[i].nombreEmpresa).openPopup();
	 }
	 
}
