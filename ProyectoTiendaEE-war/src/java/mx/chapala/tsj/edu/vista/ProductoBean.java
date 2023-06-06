/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.chapala.tsj.edu.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import mx.chapala.tsj.edu.bl.ProductoBLLocal;
import mx.chapala.tsj.edu.modelo.Producto;

/**
 *
 * @author edgar
 */
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {

    @EJB
    private ProductoBLLocal productoBL;

    private Producto producto = new Producto();
    private String titulo = "Nuevo Producto";

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String agregar() {
        System.out.println("se agrego con exito!!!");
        productoBL.agregar(producto);
        producto = new Producto();
        return "ProductoList.xhtml";
    }

    public String editar() {
        System.out.println("se edito con exito!!!");
        productoBL.editar(producto);
        producto = new Producto();
        return "ProductoList.xhtml";
    }

    public String eliminar() {
        System.out.println("se elimino con exito!!!");
        producto.setClave(0);
        producto.setNombre("xxxxx");
        producto.setPreciopublico(0);
        producto.setExistencia(0);
        producto.setProveedor("xxxxx");
        producto.setCategoria("xxxxx");
        producto.setPreciocompra(0);
        
        productoBL.eliminar(producto);
        producto = new Producto();
        return "ProductoList.xhtml";
    }

    public List<Producto> getProductoAll() {
        return productoBL.getTodo();
    }

    public String moduloProductos() {
        return "ProductoList.xhtml";
    }

    public void prepararEditar(Producto p) {
        titulo = "Editando un Producto";
        producto = p;
    }

    public void prepararNuevo() {
        titulo = "Agregar Producto";
        producto = new Producto();
    }

    public void prepararEliminar(Producto p) {
        producto = p;
    }

    public String getTitulo() {
        return titulo;
    }
}
