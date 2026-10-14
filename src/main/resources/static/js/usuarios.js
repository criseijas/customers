// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();

  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
// Source - https://stackoverflow.com/a/29823632
// Posted by Razor, modified by community. See post 'Timeline' for change history
// Retrieved 2026-10-03, License - CC BY-SA 4.0


  const request = await fetch('/usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }

  });
  const usuarios = await request.json();

  let listadoHtml = '';

  for(let usuario of usuarios){
  let usuarioHtml = '<tr> <td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido +'</td><td>'+usuario.email + '</td><td>' + usuario.telefono + '</td><td><a href="#" onclick="elimiar(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
  listadoHtml += usuarioHtml;
  }

  console.log(usuarios);


  document.querySelector('#usuarios').innerHTML = listadoHtml;
 }


 async function elimiar(id) {

    if(!confirm('Desea eliminar este usuario?')){
        return;
    }
    const request = await fetch('/usuario/' + id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }

      });

        location.reload();
 }