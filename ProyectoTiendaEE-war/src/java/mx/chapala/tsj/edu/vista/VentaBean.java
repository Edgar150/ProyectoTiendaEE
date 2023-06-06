/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import mx.chapala.tsj.edu.bl.DetalleVentaBLLocal;
import mx.chapala.tsj.edu.bl.ProductoBLLocal;
import mx.chapala.tsj.edu.bl.UsuarioBLLocal;
import mx.chapala.tsj.edu.bl.VentasBLLocal;
import mx.chapala.tsj.edu.modelo.Detalleventa;
import mx.chapala.tsj.edu.modelo.Producto;
import mx.chapala.tsj.edu.modelo.Ventas;

/**
 *
 * @author edgar
 */
@Named(value = "ventaBean")
@SessionScoped
public class VentaBean implements Serializable {

    @EJB
    private UsuarioBLLocal usuarioBL;

    @EJB
    private VentasBLLocal ventasBL;

    @EJB
    private ProductoBLLocal productoBL;

    @EJB
    private DetalleVentaBLLocal detalleVentaBL;
    private String titulo = "Nueva Venta";
    private Ventas v;
    private String producto;
    private int cantidad;
    private float total;
    private float sumaTotalok;
    private int codigo;
    private int bandera = 0;
    private int bandera2 = 0;
    private String suma;
    private int pvendidos;
    private String mascaro;
    private String barato;

    public String getBarato() {
        return barato;
    }

    public String getMascaro() {
        return mascaro;
    }

    public int getPvendidos() {
        return pvendidos;
    }

    public void setPvendidos(int pvendidos) {
        this.pvendidos = pvendidos;
    }
    private int sumaDeTodo;

    public int getSumaDeTodo() {
        return sumaDeTodo;
    }

    public void setSumaDeTodo(int sumaDeTodo) {
        this.sumaDeTodo = sumaDeTodo;
    }

    public String getSuma() {
        return suma;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getSumaTotalok() {
        return sumaTotalok;
    }

    public void setSumaTotalok(int sumaTotalok) {
        this.sumaTotalok = sumaTotalok;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTitulo() {
        return titulo;
    }
    private String productoMasVendido = "";

    public String getProductoMasVendido() {
        return productoMasVendido;
    }

    public void setProductoMasVendido(String productoMasVendido) {
        this.productoMasVendido = productoMasVendido;
    }
    List<Detalleventa> lista;
    List<Detalleventa> lista2;
    List<Producto> listaProducto;

    public List<Detalleventa> getLista2() {
        return lista2;
    }

    public void setLista2(List<Detalleventa> lista2) {
        this.lista2 = lista2;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    private int usuario;

    private int cliente;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void grafica() {
        int masProducto = 0;
        int menosProducto = 0;
        listaProducto = new ArrayList<>();
        List<Producto> produc = productoBL.getTodo(); // Le digo que se traiga a todos
        listaProducto.addAll(produc);

        for (Producto producto1 : listaProducto) { // Recorro la lista2 de detalle de venta
            if (producto1.getPreciopublico() > masProducto) {

                mascaro = producto1.getNombre();

                //System.out.println(mascaro);
            }

        }

        sumaDeTodo = 0;
        pvendidos = 0;
        lista2 = new ArrayList<>(); // Inicializo la lista
        List<Detalleventa> listaVentas = detalleVentaBL.getTodos(); // Le digo que se traiga a todos
        lista2.addAll(listaVentas); // Agrego todo

        int maxVentas = 0;

        for (Detalleventa detalleVenta : lista2) { // Recorro la lista2 de detalle de venta

            sumaDeTodo += detalleVenta.getTotal();
            pvendidos += detalleVenta.getCantidad();

            if (pvendidos > maxVentas) {
                maxVentas = detalleVenta.getCantidad();
                productoMasVendido = detalleVenta.getNombre();
            }
        }
    }

    public void prepararEditar(Ventas vn, int indice) {

        lista2 = new ArrayList<>(); // Inicializo la lista
        List<Detalleventa> listaVentas = detalleVentaBL.getTodos(); //Le digo que se traiga a todos
        lista2.addAll(listaVentas);//Agrego todo
        List<Detalleventa> listaAuxiliar = new ArrayList<>();// creo mi lista axiliar
        for (Detalleventa detalleVenta : lista2) { //recorro la lista2 de detalle de venta

            if (detalleVenta.getId()== indice) { //le digo que si ventaid es iguañ añ indice que le envio
                listaAuxiliar.add(detalleVenta);//lo agrege a la lista

            }
        }

        lista2 = listaAuxiliar;//aqui le digo que lista dos es igual a mi lista 2

        v = vn;
        titulo = "Editando Venta";

    }

    public void prepararEliminar(Ventas vn) {
        v = vn;
    }

    public void prepararNuevo() {
        titulo = "Nueva Venta";
        v = new Ventas();
        lista = new ArrayList<>();

    }

    public Ventas getV() {
        return v;
    }

    public void setV(Ventas v) {
        this.v = v;
    }

    public int getBandera2() {
        return bandera2;
    }

    public void setBandera2(int bandera2) {
        this.bandera2 = bandera2;
    }

    /**
     * Creates a new instance of VentaBean
     */
    public VentaBean() {

    }

    public String agregar() {

        Date fecha = new Date();
        v.setFecha(fecha);
        v.setTotal(sumaTotalok);
        ventasBL.agregar(v);

        for (Detalleventa dv : lista) {
            dv.setVentasid(v.getId());
            detalleVentaBL.agregar(dv);
        }
        v = new Ventas();
        sumaTotalok = 0;

        return "VentaLista.xhtml";
    }

    public String editar() {
        Date fecha = new Date();
        v.setFecha(fecha);

        ventasBL.modificar(v);

        v = new Ventas();
        return "VentaLista.xhtml";
    }

    public List<Ventas> getVentaAll() {

        return ventasBL.getTodos();
    }

    public void agregarProducto() {
        Producto p = productoBL.buscarporClave(codigo);
        if (p != null && cantidad <= p.getExistencia()) {
            Detalleventa dv = new Detalleventa();
            dv.setNombre(p.getNombre());

            dv.setCantidad(cantidad);
            p.setExistencia(p.getExistencia() - cantidad);
            productoBL.editar(p);
            dv.setPrecio(p.getPreciopublico());
            total = (int) (cantidad * p.getPreciopublico());
            dv.setTotal(total);
            sumaTotalok = sumaTotalok + total;
            bandera = 0;
            bandera2 = 0;
            lista.add(dv);
        } else {
            bandera2 = 0;
            bandera = 1;
        }
        if (p == null) {
            bandera = 0;
            bandera2 = 1;
        }

    }

    public void eliminarproductoventa(Detalleventa dv) {
        sumaTotalok = sumaTotalok - dv.getTotal();

        lista.remove(dv);

    }

    public void enceros() {
        sumaTotalok = 0;
        cantidad = 1;
    }

    public List<Detalleventa> getLista() {
        return lista;
    }

    public List<Detalleventa> getDetallesAll() {

        return detalleVentaBL.getTodos();
    }

    public String cancelarventa() {
        sumaTotalok = 0;
        bandera = 0;
        cantidad = 1;

        return "VentaLista.xhtml";
    }
}
