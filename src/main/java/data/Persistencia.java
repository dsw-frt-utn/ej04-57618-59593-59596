package data;

import domain.*;
import java.util.ArrayList;
import java.util.Optional;

public class Persistencia {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Responsable> responsables = new ArrayList<>();
    private static ArrayList<Sucursal> sucursales = new ArrayList<>();
    private static ArrayList<Marca> marcas = new ArrayList<>();
    
    private static void inicializarMarcas() {
        Marca m1 = new Marca("Ford","Estados Unidos");
        Marca m2 = new Marca("Renault","Francia");
        Marca m3 = new Marca("Iveco","Italia");
        Marca m4 = new Marca("Mercedes-Benz","Alemania");
        marcas.add(m1);
        marcas.add(m2);
        marcas.add(m3);
        marcas.add(m4);
    }
    
    private static void inicializarResponsables(){
        Responsable r1 = new Responsable("Carlos Gómez", "25444111", "3815551111");
        Responsable r2 = new Responsable("Laura Pérez", "30111222", "3815552222");
        responsables.add(r1);
        responsables.add(r2);
    }
    
    private static void inicializarSucursales(){
        Sucursal s1 = new Sucursal("SUC01", "Av. Belgrano 1200", "Tucumán", responsables.get(0));
        Sucursal s2 = new Sucursal("SUC02", "San Martín 450", "Yerba Buena", responsables.get(1));
        sucursales.add(s1);
        sucursales.add(s2);
    }
    
    public static void inicializarVehiculos(String patente, String marcaNombre, String modelo, int anio, double carga, String suc, VehiculoTipo tipo, double kmLitro, double litrosExtra){ 
        Sucursal sucursal = null;
        Marca marca = null;
        
        for(Sucursal s : sucursales) {
            if(s.getCodigo().equals(suc)) {
                sucursal = s;
                break;
            }    
        }
        for(Marca m : marcas) {
            if(m.getNombre().equals(marcaNombre)) {
                marca = m;
                break;
            }
        }
        if(tipo == VehiculoTipo.ELECTRICO){
           VehiculoElectrico v = new VehiculoElectrico(patente, marca, modelo, anio, carga, sucursal, 16); 
           vehiculos.add(v);
        }
        if(tipo == VehiculoTipo.COMBUSTIBLE) {
            VehiculoCombustible v = new VehiculoCombustible(patente, marca, modelo, anio, carga, sucursal, kmLitro, litrosExtra);
            vehiculos.add(v);
        }   
    }
    
    public static ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    public static ArrayList<Marca> getMarcas(){
        return marcas;
    }
    public static ArrayList<Sucursal> getSucursales(){
        return sucursales;
    }
    
    public static Optional<Vehiculo> getVehiculo(String patente){
        return vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();
    }
    
    public static void inicializar(){
        inicializarMarcas();
        inicializarResponsables();
        inicializarSucursales();
        //inicializarVehiculos();
        
    }
}
