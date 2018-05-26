/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function bringpdf(){
    $.ajax({type: "POST", 
        url:"sendJobReport", 
        data:JSON.stringify($('#datepicker').val()),
        datatype:"application/json",
        processData: false, 
        contentType: false,   
        async: true,
        success: 
        function(x){    
          createReport(x);                                                             
        },
        error: function(y){                        
            window.alert("Error al generar Reporte");
            }                    
        });
}
function createReport(jobArr){
    if(jobArr!=null){
        var doc = new jsPDF();
        for(var i=0;i<jobArr;i++){
            doc.text('Nombre:', 25*i, 10*i);
            doc.text('Nombre:', 10*i, 10*i);
            doc.text('Descripcion:', 10*i, 10*i);
            doc.text('Id:', 10*i, 10*i);
            doc.text('Salario:', 10*i, 10*i);
            doc.text('Activo:', 10*i, 10*i);
            doc.text('Empresa:', 10*i, 10*i);
            doc.text('Feccha:', 10*i, 10*i);
        }
        doc.save('reporte.pdf');
    }                                            
}
function createPDF(){    
    var doc = new jsPDF();
    doc.text('Reporte de Puestos de Trabajo', 50, 10);
    
    for(var i=0;i<28;i++){
            doc.text('Hello world!', 10, 10*(i+2));
        }    
    doc.save('reporte.pdf');
}

