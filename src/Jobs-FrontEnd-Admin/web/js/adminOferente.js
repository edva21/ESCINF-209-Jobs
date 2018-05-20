function remove(x){
  $('#'+x.id).remove();
}

function removeRow(x){
    x.parentNode.parentNode.style.display = 'none';
}
function aproveOferente(boton){
    updateEstadoOferente(boton,"APROVADO");
}
function disaproveOferente(boton){
    updateEstadoOferente(boton,"DENEGADO");
}
function updateEstadoOferente(boton,estado){
    alert(boton.id+"  "+estado);
    data=new FormData();
    data.append("objeto",JSON.stringify(obj));
    $.ajax({type: "POST", 
                  url:"cambiarEstadoOferente", 
                  data:data,
                  datatype:"json",
                  processData: true,                  
                  success: 
                    function(object){
                        removeRow(boton);                       
                    },
                  error: function(status){
                         window.alert("Error al cambiar Estado");
                    }                    
                }); 
}
