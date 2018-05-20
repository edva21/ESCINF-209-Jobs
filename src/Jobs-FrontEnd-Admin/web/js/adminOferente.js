function remove(x){
  $('tr#'+x.class).remove();
}

function removeRow(x){    
    window.alert("Remove Row");
    $('tr#'+x.className).remove();
}
function aproveOferente(boton){
    updateEstadoOferente(boton,"APROVADO");
}
function disaproveOferente(boton){
    updateEstadoOferente(boton,"DENEGADO");
}
function updateEstadoOferente(boton,estado){    
    var message = {oferenteid:boton.className,estado:estado};
    var data=new FormData();
    data.append("objeto",JSON.stringify(message));
    $.ajax({type: "POST", 
                  url:"cambiarEstadoOferente", 
                  data:data,
                  datatype:"json",
                  processData: false, 
                  contentType: false,   
                  async: true,
                  success: 
                    function(x){                        
                        window.alert(boton.className+" "+estado);
                        removeRow(boton);                       
                    },
                  error: function(y){                        
                         window.alert("Error al cambiar Estado de ");
                    }                    
                }); 
}
