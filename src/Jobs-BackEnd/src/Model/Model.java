/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BussinessLogic.Administrador;
import BussinessLogic.Empresa;
import BussinessLogic.Habilidad;
import BussinessLogic.Nacionalidad;
import BussinessLogic.Oferente;
import BussinessLogic.OferenteHasHabilidad;
import BussinessLogic.Puesto;
import BussinessLogic.PuestoHabilidad;
import DataAccess.AdministradorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edva5
 */
public class Model {
    private static Model INSTANCE;    
    private Model() {
        
    }
    public static Model getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Model();
        }
        return INSTANCE;
    }
    public boolean create(Administrador obj){
        try {
            DataAccess.AdministradorDAO.getInstance().administradorIngresar(obj);            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Empresa obj){
        try {
            DataAccess.EmpresaDAO.getInstance().empresaIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Habilidad obj){
        try {
            DataAccess.HabilidadDAO.getInstance().habilidadIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Nacionalidad obj){
        try {
            DataAccess.NacionalidadDAO.getInstance().nacionalidadIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Oferente obj){
        try {
            DataAccess.OferenteDAO.getInstance().oferenteIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Puesto obj){
        try {
            DataAccess.PuestoDAO.getInstance().puestoIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public Administrador readAdministrador(String userName){
        try {
            return DataAccess.AdministradorDAO.getInstance().AdministradorGet(userName);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Empresa readEmpresa(String email){
        try {
            return DataAccess.EmpresaDAO.getInstance().empresaGet(email);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Habilidad readHabilidad(String nombre){
        try {
            return DataAccess.HabilidadDAO.getInstance().habilidadGet(nombre);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Nacionalidad readNacionalidad(String nacionalidad){
        try {
            return DataAccess.NacionalidadDAO.getInstance().nacionalidadGet(nacionalidad);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Oferente readOferente(String email){
        try {
            return DataAccess.OferenteDAO.getInstance().oferenteGet(email);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*public OferenteHasHabilidad readOferenteHasHabilidad(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidad(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public Puesto readPuesto(int idPuesto,String empresaEmail){
        try {
            return DataAccess.PuestoDAO.getInstance().puestoGet(idPuesto,empresaEmail);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*public PuestoHabilidad readPuestoHabilidad(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public List<Administrador> readAllAdministrador(){
        try {
            return DataAccess.AdministradorDAO.getInstance().administradorListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Empresa> readAllEmpresa(){
        try {
            return DataAccess.EmpresaDAO.getInstance().empresaListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Habilidad> readAllHabilidad(){
        try {
            return DataAccess.HabilidadDAO.getInstance().HabilidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Nacionalidad> readAllNacionalidad(){
        try {
            return DataAccess.NacionalidadDAO.getInstance().nacionalidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Oferente> readAllOferente(){
        try {
            return DataAccess.OferenteDAO.getInstance().oferenteListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<OferenteHasHabilidad> readAllOferenteHasHabilidad(){
        try {
            return DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Puesto> readAllPuesto(){
        try {
            return DataAccess.PuestoDAO.getInstance().puestoListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    /*public List<PuestoHabilidad> readAllPuestoHabilidad(){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administrador();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public boolean delete(Administrador obj){
        try {
            DataAccess.AdministradorDAO.getInstance().administradorBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Empresa obj){
        try {
            DataAccess.EmpresaDAO.getInstance().empresaBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Habilidad obj){
        try {
            DataAccess.HabilidadDAO.getInstance().habilidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Nacionalidad obj){
        try {
            DataAccess.NacionalidadDAO.getInstance().nacionalidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Oferente obj){
        try {
            DataAccess.OferenteDAO.getInstance().oferenteBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Puesto obj){
        try {
            DataAccess.PuestoDAO.getInstance().puestoBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean login(Empresa obj){
        try{
             Empresa empresa = DataAccess.EmpresaDAO.getInstance().empresaGet(obj.getEmpresaEmail()); 
            return empresa!= null && obj.getEmpresaClave().equals(empresa.getEmpresaClave());
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;}         
    }
}
