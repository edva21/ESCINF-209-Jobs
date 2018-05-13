/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

//import Entities.Puesto;
//import Entities.PuestoPK;
import BussinessLogic.Puesto;
import BussinessLogic.PuestoPK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaspa
 */
public class PuestoDAO extends DAO{
    private static PuestoDAO INSTANCE;
    private PuestoDAO() {
   
    }
    public static PuestoDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PuestoDAO();
        }
        return INSTANCE;
    }
    private Puesto puesto(ResultSet rs) throws Exception{
        try {
            Puesto a = new Puesto();
            PuestoPK puestoPK = new PuestoPK(rs.getInt("idPuesto"),rs.getString("Empresa_EmpresaEmail"));
            a.setPuestoPK(puestoPK);
            a.setPuestoNombre(rs.getString("PuestoNombre"));
            a.setEmpresa(EmpresaDAO.getInstance().empresaGet(rs.getString("Empresa_EmpresaEmail")));
            a.setPuestoActivo(rs.getBoolean("PuestoActivo"));
            a.setPuestoDescripcion(rs.getString("PuestoDescripcion"));
            a.setPuestoSalario(rs.getDouble("PuestoSalario"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public Puesto puestoGet(int idPuesto,String Empresa_EmpresaEmail)throws Exception{
         getConnection();
        String sql="select * from Puesto where idPuesto='%n',Empresa_EmpresaEmail='%s'";
        sql = String.format(sql,idPuesto,Empresa_EmpresaEmail);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Puesto a= puesto(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Puesto no Existe");
        }
    }
     public List<Puesto> PuestoBuscarNombre(Puesto filtro) throws Exception{
         getConnection();
        List<Puesto> resultado = new ArrayList<>();
        try {
            String sql="select * from Puesto  where PuestoNombre like '%%%s%%'";
            sql=String.format(sql,filtro.getPuestoNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
     
     public List<Puesto> PuestoCincoMayores() throws Exception{
         getConnection();
        List<Puesto> resultado = new ArrayList<>();
        try {
            String sql="select * from Puesto  order by idPuesto desc LIMIT 5";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
     
    public List<Puesto> puestoListar() throws Exception{
         getConnection();
        List<Puesto> resultado=new ArrayList<>();
        try {
            String sql="select * from Puesto";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
   
    public void puestoIngresar(Puesto a) throws Exception{
       getConnection();
        String sql="INSERT INTO Puesto (PuestoNombre,PuestoDescripcion,PuestoSalario,PuestoActivo,Empresa_EmpresaEmail) VALUES('%s','%s','%d','%b','%s')";
        sql=String.format(sql,a.getPuestoNombre(),a.getPuestoDescripcion(),a.getPuestoSalario(),a.getPuestoActivo(),a.getEmpresa().getEmpresaEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto no se pudo ingresar");
        }
        desconectar();
    }
    public void puestoBorrar(Puesto a) throws Exception{
         getConnection();
        String sql="delete from Puesto where idPuesto='%d' and Empresa_EmpresaEmail ='%s'" ;
        sql = String.format(sql,a.getPuestoPK().getIdPuesto(),a.getPuestoPK().getEmpresaEmpresaEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Puesto no existe");
        }
         desconectar();
    }
    
    
    
}
