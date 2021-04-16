function crearConjunto(){
	
	var nombre_conjunto = document.getElementsByName("nombre-conjunto")[0].value;
	var descripcion_conjunto = document.getElementsByName("descripcion-conjunto")[0].value;
	var tipo_conjunto = document.getElementsByName("tipo-conjunto")[0].value;
	
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", 'https://console.kaleido.io/api/v1/consortia/u0vzvm7abo/contracts', true);

	//Send the proper header information along with the request
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.setRequestHeader("Authorization", "Bearer u0wa11zpqc-4eYOgpcwADI6V9j/7kLC9VG+/+P5MzuG9UL8K+qkO2U=");

	xhr.onreadystatechange = function() { // Call a function when the state changes.
	    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
	        // Request finished. Do processing here.
	    }
	}
	//xhr.send("foo=bar&lorem=ipsum");
	console.log(JSON.stringify({ "name": nombre_conjunto, "description": descripcion_conjunto, "membership_id": "u0n0gp0o9z",  "type": tipo_conjunto}));
	//console.log("{\"name\": \""+ nombre_conjunto +"\", \"description\": \""+ descripcion_conjunto +"\", \"membership_id\": \"u0n0gp0o9z\", \"type\": \""+ tipo_conjunto +"\"}");
	xhr.send(JSON.stringify({ "name": nombre_conjunto, "description": descripcion_conjunto, "membership_id": "u0n0gp0o9z",  "type": tipo_conjunto}));
	// xhr.send(new Int8Array());
	// xhr.send(document);
}

function obtenerConjuntos(){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            //var data = xhr.responseText;
            var data = JSON.parse(xhr.responseText);
            append_json_conjunto(data);
            //alert(data);
        }
    }
    xhr.open('GET', 'ObtenerConjuntos', true);
    xhr.send(null);
    
}

function obtenerCompilados(id_conjunto){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            //var data = xhr.responseText;
            var data = JSON.parse(xhr.responseText);
            append_json_compilado(data);
            //alert(data);
        }
    }
    xhr.open('GET', 'ObtenerCompilados?id-conjunto=' + id_conjunto, true);
    xhr.send(null);
    
    
}

function crearCompilados(){
	
	var nombre_contrato = document.getElementsByName("nombre-contrato")[0].value;
	var descripcion_contrato = document.getElementsByName("descripcion-contrato")[0].value;
	var url_contrato = document.getElementsByName("url-contrato")[0].value;
	
	console.log(nombre_contrato);
	console.log(descripcion_contrato);
	console.log(url_contrato);
	console.log(contratoid[1]);
	
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            //var data = xhr.responseText;
            var data = JSON.parse(xhr.responseText);
            append_json_compilado(data);
            //alert(data);
        }
    }
    xhr.open('GET', 'CrearCompilados?id_contrato=' + contratoid[1] + "&nombre-contrato=" + nombre_contrato + "&descripcion-contrato=" + descripcion_contrato + "&url-contrato=" + url_contrato, true);
    xhr.send(null);
    return false;
}

function append_json_conjunto(data){
    var table = document.getElementById('conjuntos-table');
    var i = 1;
    data.forEach(function(object) {
    	
        var tr = document.createElement('tr');
        tr.innerHTML ='<td>' + i + '</td>' +  
        '<td>' + object.name + '</td>' +        
        '<td>' + object.description + '</td>' +
        '<td>' + object.type + '</td>' +
        '<td>' + '<button class="btn waves-effect waves-light btn-info btn-outline-info" onclick="verCompilados(\''+ object._id +'\')"><i class="icofont icofont-info-square"></i>Ver Conjunto</button>' + '</td>';
        table.appendChild(tr);
        i = i + 1;
        
    });
}

function append_json_compilado(data){
    var table = document.getElementById('conjuntos-table');
    var i = 1;
    data.forEach(function(object) {
    	
        var tr = document.createElement('tr');
        tr.innerHTML ='<td>' + i + '</td>' +  
        '<td>' + object.contract_name + '</td>' +        
        '<td>' + object.description + '</td>' +
        '<td>' + object.state + '</td>' +
        '<td>' + '<button class="btn waves-effect waves-light btn-info btn-outline-info" onclick="verCompilados(\''+ object._id +'\')"><i class="icofont icofont-info-square"></i>Promover</button>' + '</td>';
        table.appendChild(tr);
        i = i + 1;
        
    });
}

function verCompilados(x){
	window.location.href = "Compilados.html?conjunto=" + x;
}