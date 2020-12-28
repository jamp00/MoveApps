

1.- Edit file: MoveApps\src\main\resources\application.properties
    Modificar lineas 3; 4 y 5 Con las credenciales de base de datos correspondientes
	
2.- Desplegar aplicación en un ambiente a elección

3.- AUTENTICACIÓN: GET
	Endpoint: http://localhost:8082/token/

4.- REGISTRO:	POST
	Endpoint: http://localhost:8082/usuarios/registro
	4.1 Agregar header 'Authorization', con el token obtenido en paso3
	4.2 Agregar header 'Content-Type: application/json', si fuese necesario

5.- LISTAR USUARIOS:	GET
	EndPoint: http://localhost:8082/usuarios/usuariosActivos
	5.1 Agregar header 'Authorization', con el token obtenido en paso3
	5.2 Agregar header 'Content-Type: application/json', si fuese necesario


NOTA: La aplicación está 'escuchando' por el puerto 8082, si se desea modificar el puerto 
	editar linea 1 del archivo MoveApps\src\main\resources\application.properties

 
Quedo atento a cualquier duda: Javier Muñoz; cel 09-76096954


