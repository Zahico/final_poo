Principios SOLID

Paquete y sus hijas solo saben calcular su costo y guardar sus datos.
Despacho solo se encarga de manejar los paquetes de la moto
Utilidades solo valida la guia y formatea numeros
Zona solo guarda las tarifas

La gerente dijo que el otro año van a haber servicios nuevos como refrigerado. Con el diseño que hicimos para agregar un servicio nuevo solo hay que crear una clase nueva que herede de Paquete y implemente calcularCosto(), getServicio() y getAjuste(). Si ademas necesita manejo especial, implementa ManejoEspecial, el Despacho ya la va a mostrar en las advertencias porque pregunta con instanceof ManejoEspecial y no por la clase concreta. No hay que modificar Despacho ni las otras clases de paquetes.

En Despacho todo se trabaja como Paquete, entonces da no importa si es estandar, express o fragil, cualquiera funciona igual cuando se suma el peso, el costo o se ordena.

