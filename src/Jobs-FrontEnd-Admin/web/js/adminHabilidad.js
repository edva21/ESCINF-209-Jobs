/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Get the input field
// Execute a function when the user releases a key on the keyboard
var stack =[];
stack.push("Inicio");
function addHabilidad(event){
    if (event.keyCode === 13) {   
        if ($("#newhabilidad").val().length>0)
            add($("#newhabilidad").val());        
  }
}
function addToList(){
    $("#habilidadList").append("<li class=\"item\" onclick=\"javascript:navHabilidad(this)\">"+$("#newhabilidad").val()+"</li>");
            $("#newhabilidad").val("");
}
function navHabilidad(li){
    stack.push(li.innerHTML);
    $(".item").remove();
    printpath();
}
function printpath(){
    $("#path").empty();
    for (i = 0; i < stack.length; i++) {
        $("#path").append("<li id="+stack[i]+" onclick=\"goto(this)\" class=\"pathItem\" >>>"+stack[i]+"</li>");
    } 
}
function goto(li){
    for (i = stack.length-1; i > 0; i--) {
        if(li.id===stack[i]){
            i=0;
        }
        else
        {
            stack.pop();
        }
    } 
    printpath();    
}
function add(habilidad){    
    var answer = confirm("Desea poner estado de la cuenta"+$("#"+boton.className+" .email").text()+" como "+estado);
    if(answer!==false){
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {habilidadNombre:habilidad,habilidadHabilidadNombre:parent_hability};
                    var data=new FormData();
                    data.append("objeto",JSON.stringify(message));
                    $.ajax({type: "POST", 
                                url:"addHabilidad", 
                                data:data,
                                datatype:"json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                        
                                        addToList();                                                               
                                    },
                                    error: function(y){                        
                                            window.alert("Error al agregar Habilidad");
                                    }                    
                            }); 
                }
}
