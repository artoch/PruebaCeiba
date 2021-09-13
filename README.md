# PruebaCeiba
testCeiba

Aplicación que consume servicio de API REST con la libreria Ktor
DB local con ROOM
uso de Flows y livedata
databinding y viewbinding
groupieAdapter
Uso de Barista para el apoyo de pruebas instrumentales

Pruebas de ViewModel ->
Verifica si hay elementos de el fake localdb 
Si no hay entonces toma data fake del repo remoto
guarda la lista de usaurio obtenida al fake local repo
y consulta los fake post de un usuario almacenado

Pruebas Instrumentales
MainTest 
Espera la carga de elementos, si tiene entonces filtra dos veces y verifica que el usuario filtrado es el correcto.

PostTest
Verifica con un usuario almacenado del local db los post que este tenga haciendo la consulta al servidor.
