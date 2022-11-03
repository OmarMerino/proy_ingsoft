CREATE TABLE Usuario
(
  rut VARCHAR(10) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  direccion VARCHAR(70) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  Correo VARCHAR(40) NOT NULL,
  Contraseña VARCHAR(15) NOT NULL,
  PRIMARY KEY (rut)
);

CREATE TABLE producto
(
  id_producto INT NOT NULL,
  precio INT NOT NULL,
  stock INT NOT NULL,
  nombre_prod VARCHAR(70) NOT NULL,
  descripcion VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_producto)
);

CREATE TABLE Categoria
(
  id_categoria INT NOT NULL,
  nombre_cat VARCHAR(25) NOT NULL,
  PRIMARY KEY (id_categoria)
);

CREATE TABLE bodega
(
  id_bodega INT NOT NULL,
  ubicacion VARCHAR(70) NOT NULL,
  nombre_bod VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_bodega)
);

CREATE TABLE Permiso
(
  nombre_permiso VARCHAR(15) NOT NULL,
  id_permiso INT NOT NULL,
  PRIMARY KEY (id_permiso)
);

CREATE TABLE Pertenece
(
  id_producto INT NOT NULL,
  id_categoria INT NOT NULL,
  PRIMARY KEY (id_producto, id_categoria),
  FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
  FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE existe_en
(
  stock_bod INT NOT NULL,
  id_producto INT NOT NULL,
  id_bodega INT NOT NULL,
  PRIMARY KEY (id_producto, id_bodega),
  FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
  FOREIGN KEY (id_bodega) REFERENCES bodega(id_bodega)
);

CREATE TABLE Tiene_permiso
(
  rut VARCHAR(10) NOT NULL,
  id_permiso INT NOT NULL,
  PRIMARY KEY (rut, id_permiso),
  FOREIGN KEY (rut) REFERENCES Usuario(rut),
  FOREIGN KEY (id_permiso) REFERENCES Permiso(id_permiso)
);

CREATE TABLE Metodo_pago
(
  id_pago INT NOT NULL,
  nombre VARCHAR(40) NOT NULL,
  tipo VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_pago)
);

CREATE TABLE Venta
(
  id_venta INT NOT NULL,
  fecha VARCHAR(25) NOT NULL,
  descuento INT NOT NULL,
  total INT NOT NULL,
  rut VARCHAR(10) NOT NULL,
  id_pago INT NOT NULL,
  PRIMARY KEY (id_venta),
  FOREIGN KEY (rut) REFERENCES Usuario(rut),
  FOREIGN KEY (id_pago) REFERENCES Metodo_pago(id_pago)
);

CREATE TABLE Vendido
(
  precio INT NOT NULL,
  cantidad INT NOT NULL,
  id_producto INT NOT NULL,
  id_venta INT NOT NULL,
  PRIMARY KEY (id_producto, id_venta),
  FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
  FOREIGN KEY (id_venta) REFERENCES Venta(id_venta)
);