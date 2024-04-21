package ar.edu.unju.fi.ejercicio17.model;
import java.util.*;

public class Jugador {
 private String nombre;
 private String apellido;
 private Date fechaNacimiento;
 private String nacionalidad;
 private double estatura;
 private double peso;
 private String posicion;

 public Jugador(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double estatura, double peso, String posicion) {
     this.nombre = nombre;
     this.apellido = apellido;
     this.fechaNacimiento = fechaNacimiento;
     this.nacionalidad = nacionalidad;
     this.estatura = estatura;
     this.peso = peso;
     this.posicion = posicion;
 }
 
 public String getNombre() {
     return nombre;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public String getApellido() {
     return apellido;
 }

 public void setApellido(String apellido) {
     this.apellido = apellido;
 }

 public Date getFechaNacimiento() {
     return fechaNacimiento;
 }

 public void setFechaNacimiento(Date fechaNacimiento) {
     this.fechaNacimiento = fechaNacimiento;
 }

 public String getNacionalidad() {
     return nacionalidad;
 }

 public void setNacionalidad(String nacionalidad) {
     this.nacionalidad = nacionalidad;
 }

 public double getEstatura() {
     return estatura;
 }

 public void setEstatura(double estatura) {
     this.estatura = estatura;
 }

 public double getPeso() {
     return peso;
 }

 public void setPeso(double peso) {
     this.peso = peso;
 }

 public String getPosicion() {
     return posicion;
 }

 public void setPosicion(String posicion) {
     this.posicion = posicion;
 }

 public int calcularEdad() {
     Calendar cal = Calendar.getInstance();
     cal.setTime(fechaNacimiento);
     int year = cal.get(Calendar.YEAR);
     int month = cal.get(Calendar.MONTH);
     int day = cal.get(Calendar.DAY_OF_MONTH);

     Calendar now = Calendar.getInstance();
     int currentYear = now.get(Calendar.YEAR);
     int currentMonth = now.get(Calendar.MONTH);
     int currentDay = now.get(Calendar.DAY_OF_MONTH);

     int edad = currentYear - year;
     if (currentMonth < month || (currentMonth == month && currentDay < day)) {
         edad--;
     }
     return edad;
 }

}

