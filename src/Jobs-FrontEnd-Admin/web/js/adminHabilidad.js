/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Get the input field
// Execute a function when the user releases a key on the keyboard
var stack =[];
function addHabilidad(event){
    if (event.keyCode === 13) {   
        if ($("#newhabilidad").val().length>0) {
            $("#habilidadList").append("<li onclick=\"javascript:navHabilidad(this)\">"+$("#newhabilidad").val()+"</li>");
            $("#newhabilidad").val("");
        }
  }
} 
function navHabilidad(li){
    alert(li.innerText);
}
