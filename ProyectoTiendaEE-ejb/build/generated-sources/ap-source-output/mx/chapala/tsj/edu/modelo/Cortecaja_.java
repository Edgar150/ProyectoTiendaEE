package mx.chapala.tsj.edu.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.chapala.tsj.edu.modelo.Tipodeventa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T02:14:10")
@StaticMetamodel(Cortecaja.class)
public class Cortecaja_ { 

    public static volatile SingularAttribute<Cortecaja, Float> total;
    public static volatile SingularAttribute<Cortecaja, Float> retirado;
    public static volatile SingularAttribute<Cortecaja, Integer> id;
    public static volatile SingularAttribute<Cortecaja, Float> ingresado;
    public static volatile ListAttribute<Cortecaja, Tipodeventa> tipodeventaList;

}