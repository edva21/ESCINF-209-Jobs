/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Get the input field
// Execute a function when the user releases a key on the keyboard
var stack =[];
var checkedStack =[];
var mainStack =[];
var leaf=false;
var aux;
function changedNumber(nmbr){
    var currentHanility=nmbr.id.slice(0,-4);
    mainStack.filter(function (element) {
        return (element.nombre===currentHanility);
    }).forEach(function (element) {
        element.porcentaje=$('#'+nmbr.id).val();
    });    
}         
stack.push("Inicio");
$(function() {
        $('#spinner').spinner({
            min: 2,
            max: 20,
            step: 2
        });
    });
function checkleaf(chckBx){
    if($('#'+chckBx.id)[0].checked===true){
        $('#'+chckBx.id).prop('checked',true);
        $('#'+chckBx.id+"nmbr").show();        
        $('#'+chckBx.id+"nmbr").val(100);     
        var index = checkedStack.indexOf(chckBx.id);
        if (index < 0){
        mainStack.push({'nombre':chckBx.id,'porcentaje':100});
        checkedStack.push(chckBx.id);
        alert(checkedStack);
        }
       // for(var i=0;i<checkedStack.length;i++)
         //   alert(checkedStack[i]);
    }
    else{
        $('#'+chckBx.id).prop('checked',false);
        $('#'+chckBx.id+"nmbr").hide();
        mainStack.filter(function (element) {
        return (element.nombre===chckBx.id);
    }).forEach(function (element) {
        aux=element;
    });
    
        var index = checkedStack.indexOf(chckBx.id);
        if (index > -1) {
            checkedStack.splice(index, 1);
            mainStack.splice(index, 1);
        }        
        //for(var i=0;i<checkedStack.length;i++)
           // alert(checkedStack[i]);
    }
}
function getPorcentage(habilidadnombre)    {    
    for(var i=0;i<mainStack.length;i++){
        if(mainStack[i].nombre===habilidadnombre)
            return mainStack[i].porcentaje;                    
    }   
}
function checkleafData(habilidad){
    var index = checkedStack.indexOf(habilidad.habilidadNombre);
    if (index > -1){
        $('#'+habilidad.habilidadNombre+"nmbr").show();                        
        $('#'+habilidad.habilidadNombre).prop('checked',true);
        for(var i=0;i<mainStack.length;i++){
        if(mainStack[i].nombre===habilidad.habilidadNombre){            
            $('#'+habilidad.habilidadNombre+"nmbr").val(mainStack[i].porcentaje);
            i=mainStack.length;}
            }
        }    
}


function printpath(){
    $("#path").empty();
    for (i = 0; i < stack.length; i++) {
        $("#path").append("<li id="+stack[i]+" onclick=\"goto(this)\" class=\"pathItem\" >>>"+stack[i]+"</li>");
    }     
}
function printHabilidad(habilidad){        
    $("#path").append("<li id=\"item\" onclick=\"goto(this)\" class=\"item\" >"+habilidad.habilidadNombre+"</li>");    
}
function printHabilidadItem(habilidad){ 
    if(habilidad.habilidadEsHoja){
        $("#habilidadList").append("<li class=\"leafitem\" onclick=\"javascript:navHabilidad(this)\"  ><font color=\"red\">"+habilidad.habilidadNombre+"</font><input id="+habilidad.habilidadNombre+" onclick=\"javascrip:checkleaf(this)\" type=\"checkbox\"><input id=\""+habilidad.habilidadNombre+"nmbr\" type=\"number\" onchange=\"changedNumber(this)\" min=\"1\" max=\"100\" style=\"display:none\"></li>");    
        checkleafData(habilidad);
}   
    else
        $("#habilidadList").append("<li class=\"itemSearch\" onclick=\"javascript:navHabilidad(this)\"  >"+habilidad.habilidadNombre+"</li>");    
}
function printSons(data){
    $("#habilidadList").empty();
    var arr=JSON.parse(data);
    for(var i=0;i<arr.length;i++)                        
        printHabilidad(arr[i]); 
}
function goto(li){    
       for (i = stack.length-1; i >= 0; i--) {
        if(li.id===stack[i])
            i=0;        
        else        
            stack.pop();        
        } 
        $(".itemSearch").remove();
        $(".leafitem").remove();
        printpath();             
        printHabilidadSons(li.id);       
}
function navHabilidad(li){ //borraLista e Imprime hijos de la habilidad                              
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {"habilidadNombre":li.innerHTML,"habilidadHabilidadNombre":parent_hability,"habilidadEsHoja":false};                                       
                    $.ajax({type: "POST", 
                                url:"sendHabilidad", 
                                data:JSON.stringify(message),
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                                                                
                                     changeScreen(x,li);
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                            window.alert("Error al agregar Habilidad: "+xhr.status+" "+ajaxOptions+" "+xhr);                                            
                                    }                    
                            }); 
}

function printHabilidadSons(_habilidadNombre){ //borraLista e Imprime hijos de la habilidad                              
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {"habilidadNombre":_habilidadNombre,"habilidadHabilidadNombre":parent_hability,"habilidadEsHoja":false};                                       
                    $.ajax({type: "POST", 
                                url:"sonsHabilidad", 
                                data:JSON.stringify(message),
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                                                                
                                     for(var i=0;i<x.length;i++)
                                        printHabilidadItem(x[i]); 
                                        
                                        //$("#comboox").atrr('item').add(x[i]);
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                            window.alert("Error al agregar Habilidad: "+xhr.status+" "+ajaxOptions);
                                            return {habilidadNombre:habilidad,habilidadHabilidadNombre:parent_hability,habilidadEsHoja:true};                                       
                                    }                    
                            }); 
}
 function changeScreen(json,li){
     if(!json.habilidadEsHoja){
        stack.push(li.innerHTML);
        $(".itemSearch").remove();
        $(".leafitem").remove();
        printpath();             
        printHabilidadSons(li.innerHTML);
     }    
 }



