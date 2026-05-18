/*
  Archivo: Main.java
  Autores: Brayan Fernando Cruz Puerta, Jaiver Quitumbo Escué, Juan Camilo Agrace Landazury, Juan Camilo Puentes Ceballos y Manuel Alejandro Medina Gonzalez.
  Correos: cruz.brayan@correounivalle.edu.co, jaiver.quitumbo@correounivalle.edu.co, juan.agrace@correounivalle.edu.co, puentes.juan@correounivalle.edu.co y medina.manuel@correounivalle.edu.co
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

class InterfazVehiculo extends JFrame implements ActionListener
{
  // Atributos.
  // Lista donde almacenaremos nuestros vehículos.
  
  private ArrayList <Vehiculo> unaListaDeVehiculos = new ArrayList<Vehiculo>();
  
  // Paneles.
  private JPanel panelGrande;
  private JPanel informacionVehiculos = new JPanel();
  private JPanel busquedaDeModelo = new JPanel();
  private JPanel busquedaPorPrecio = new JPanel();
  private JPanel seccionImagen = new JPanel();
  private JPanel seccionTabla = new JPanel();
  
  // Imagen.
  Image sacarImagen = new ImageIcon("carro.png").getImage();
  ImageIcon icono = new ImageIcon(sacarImagen.getScaledInstance(200,200, Image.SCALE_SMOOTH));
  
  // Labels con la información de los vehículos.
  private JLabel codigo = new JLabel("Código: ");
  private JLabel placa = new JLabel("Placa: ");
  private JLabel modelo = new JLabel("Modelo: ");
  private JLabel precio = new JLabel("Precio: ");
  private JLabel marca = new JLabel("Marca: ");
  private JLabel color = new JLabel("Color: ");
  private JLabel imagen = new JLabel(icono);
  
  // Cajas de texto con la información de los vehículos.
  private JTextField digitarCodigo = new JTextField(10);
  private JTextField digitarPlaca = new JTextField(10);
  private JTextField digitarModelo = new JTextField(10);
  private JTextField digitarPrecio = new JTextField(10);
  private JTextField digitarMarca = new JTextField(10);
  private JTextField digitarColor = new JTextField(10);
  
  // Botón que guarda la información de los vehículos.
  private JButton guardarInfVehiculo = new JButton("Guardar");
  
  // Label sobre búsqueda por modelo.
  private JLabel busquedaModelo = new JLabel("Modelo: ");
  
  // Caja de texto sobre búsqueda por modelo.
  private JTextField buscardorXModelo = new JTextField(10);
  
  // Botón de búsqueda por modelo.
  private JButton botonBusquedaModelo = new JButton("Buscar");
  
  // Labels sobre búsqueda por precio.
  private JLabel precioDesde = new JLabel("Desde: ");
  private JLabel precioHasta = new JLabel("Hasta: ");
  
  // Caja de texto sobre búsqueda por precio.
  private JTextField buscarDesde = new JTextField(10);
  private JTextField buscarHasta = new JTextField(10);
  
  // Botón de búsqueda de precio.
  private JButton botonBusquedaPrecio = new JButton("Buscar");
  
  // Barra de menú.
  private JMenuBar autoMenu = new JMenuBar();
  
  // Menú.
  private JMenu archivo = new JMenu("Archivo");
  private JMenu acciones = new JMenu("Acciones");
  private JMenu acercaDe = new JMenu("Acerca de");
  
  // Sub. Menú o botones.
  private JMenuItem cerrar = new JMenuItem("Cerrar");
  private JMenuItem guardar = new JMenuItem("Guardar");
  private JMenuItem buscarXModelo = new JMenuItem("Buscar Por Modelo");
  private JMenuItem buscarXPrecio = new JMenuItem("Buscar Por Precio");
  private JMenuItem integrantes = new JMenuItem("Integrantes");

  // Tabla de vehículos.
  private JTable listaDeVehiculos = new JTable();
  private DefaultTableModel estructura;
  private Object informacion[][] = {{"100", "2000", "Ford", "abc-123", "Negro", 12222}, {"101", "2000", "Ford", "ahk-298", "Azul", 50000}, {"102", "2019", "Kia", "ayt-983", "Verde", 25000}, {"103", "2020", "Kia", "apu-765", "Gris", 30000}};
  private String nombreColumnas[]={"Código", "Modelo","Marca", "Placa","Color", "Precio"};
  private JScrollPane rueda = new JScrollPane();
  
  // Métodos.
  public InterfazVehiculo()
  { 
    // Panel de información de vehículos.
    informacionVehiculos.setLayout(null);        
    informacionVehiculos.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Vehículos"));
    informacionVehiculos.add(codigo);
    informacionVehiculos.add(digitarCodigo);
    informacionVehiculos.add(placa);
    informacionVehiculos.add(digitarPlaca);
    informacionVehiculos.add(modelo);
    informacionVehiculos.add(digitarModelo);
    informacionVehiculos.add(precio);
    informacionVehiculos.add(digitarPrecio);
    informacionVehiculos.add(marca);
    informacionVehiculos.add(digitarMarca);
    informacionVehiculos.add(color);
    informacionVehiculos.add(digitarColor);
    informacionVehiculos.add(guardarInfVehiculo);
    
    // Posiciones de información de vehículos.
    informacionVehiculos.setBounds(5,20,640,80);
    codigo.setBounds(5,18,60,20);
    digitarCodigo.setBounds(65,18,110,25);
    placa.setBounds(5,45,50,20);
    digitarPlaca.setBounds(65,45,110,25);
    modelo.setBounds(180,18,65,20);
    digitarModelo.setBounds(242,18,110,25);
    precio.setBounds(180,45,60,20);
    digitarPrecio.setBounds(242,45,110,25);
    marca.setBounds(355,18,60,20);
    digitarMarca.setBounds(408,18,110,25);
    color.setBounds(355,45,60,20);
    digitarColor.setBounds(408,45,110,25);
    guardarInfVehiculo.setBounds(522,30,110,25);
    // Acción del botón de guardar.
    guardarInfVehiculo.addActionListener(this);
    
    // Panel de búsqueda por modelo.
    busquedaDeModelo.setLayout(null); 
    busquedaDeModelo.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda por modelo"));
    busquedaDeModelo.add(busquedaModelo);
    busquedaDeModelo.add(buscardorXModelo);
    busquedaDeModelo.add(botonBusquedaModelo);
    // Posiciones de búsqueda por modelo.
    busquedaDeModelo.setBounds(5,105,200,80);
    busquedaModelo.setBounds(5,18,65,25);
    buscardorXModelo.setBounds(70,18,110,25);
    botonBusquedaModelo.setBounds(70,45,110,25);
    // Acción del botón de búsqueda por modelo.
    botonBusquedaModelo.addActionListener(this);
    
    // Panel de búsqueda por precio.
    busquedaPorPrecio.setLayout(null); 
    busquedaPorPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda por precio"));
    busquedaPorPrecio.add(precioDesde);
    busquedaPorPrecio.add(buscarDesde);
    busquedaPorPrecio.add(precioHasta);
    busquedaPorPrecio.add(buscarHasta);
    busquedaPorPrecio.add(botonBusquedaPrecio);
    // Posiciones de búsqueda por precio.
    busquedaPorPrecio.setBounds(205,105,440,80); 
    precioDesde.setBounds(5,18,65,25);
    buscarDesde.setBounds(63,18,150,25);
    precioHasta.setBounds(5,45,110,25);
    buscarHasta.setBounds(63,45,150,25);
    botonBusquedaPrecio.setBounds(250,22,150,40);
    //Acción del botón de búsqueda por precio.
    botonBusquedaPrecio.addActionListener(this);
    
    // Panel de tabla.
    seccionTabla.setLayout(null); 
    seccionTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de carros"));
    estructura = new DefaultTableModel(informacion, nombreColumnas);
    rueda.setViewportView(listaDeVehiculos);
    listaDeVehiculos.setModel(estructura);
    seccionTabla.add(rueda);
    seccionTabla.setBounds(240,190,405,212);
    rueda.setBounds(6,15,394,189);
    
    // Panel de imagen.
    seccionImagen.setLayout(null);
    seccionImagen.add(imagen);
    seccionImagen.setBounds(10,190,225,212);
    imagen.setBounds(5,15,215,188);
    
    // Barra de menú.
    autoMenu.add(archivo);
    autoMenu.add(acciones);
    autoMenu.add(acercaDe);
    
    // Archivo - Cerrar el programa.
    archivo.add(cerrar);
    cerrar.addActionListener(this);
    
    // Acciones - guardar, buscar por modelo, buscar por precio.
    acciones.add(guardar);
    guardar.addActionListener(this);
    acciones.add(buscarXModelo);
    buscarXModelo.addActionListener(this);
    acciones.add(buscarXPrecio);
    buscarXPrecio.addActionListener(this);
    
    // Ventana modal con el nombre.
    acercaDe.add(integrantes);
    integrantes.addActionListener(this);
    
    // Agrega la barra de menú.
    this.setJMenuBar(autoMenu);
    
    // ********Introduzco al array algunos vehículos inciales*******
    Vehiculo vehiculo1 = new Vehiculo("100", "2000", "Ford", "abc-123", "Negro", 12222);
    Vehiculo vehiculo2 = new Vehiculo("101", "2000", "Ford", "ahk-298", "Azul", 50000);
    Vehiculo vehiculo3 = new Vehiculo("102", "2019", "Kia", "ayt-983", "Verde", 25000);
    Vehiculo vehiculo4 = new Vehiculo("103", "2020", "Kia", "apu-765", "Gris", 30000);

    unaListaDeVehiculos.add(vehiculo1);
    unaListaDeVehiculos.add(vehiculo2);
    unaListaDeVehiculos.add(vehiculo3);
    unaListaDeVehiculos.add(vehiculo4);
    
    //**************************************************************
    
    // Agregar a los paneles.
    this.panelGrande = new JPanel();
    panelGrande.setLayout(null);
    panelGrande.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    panelGrande.add(informacionVehiculos);
    panelGrande.add(busquedaDeModelo);
    panelGrande.add(busquedaPorPrecio);
    panelGrande.add(seccionTabla);
    panelGrande.add(seccionImagen);
    add(panelGrande);

    // Parámetros.
    this.setTitle("Concesionario A&P");
    this.setSize(650,450);
    this.setMinimumSize(new Dimension(640,440));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public void refrescarTabla()
  {
    // Despejamos la tabla.
    DefaultTableModel modeloDeLaTabla = (DefaultTableModel)listaDeVehiculos.getModel(); modeloDeLaTabla.setRowCount(0);
      
    // Registrar vehículo.
    for(int cual = 0; cual < unaListaDeVehiculos.size(); cual++)
    {
      Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};
    
    estructura.addRow(elVehiculo);
    }
  }

  // Método para limpiar los JLabels cada que se registra un vehículo.
  public void limpiarTextFields()
  {
    digitarCodigo.setText("");
    digitarPlaca.setText("");
    digitarModelo.setText("");
    digitarPrecio.setText("");
    digitarMarca.setText("");
    digitarColor.setText("");
  }
  
  //**************Eventos***********
  public void actionPerformed(ActionEvent evento)
  {
    //***********Botón Guardar*************
    if(evento.getSource()==guardarInfVehiculo || evento.getSource()==guardar)
    {
      String elCodigo = digitarCodigo.getText().trim();
      String elModelo = digitarModelo.getText().trim();
      String laMarca = digitarMarca.getText().trim();
      String laPlaca = digitarPlaca.getText().trim();
      String elColor = digitarColor.getText().trim();
      String elPrecio = digitarPrecio.getText().trim();

      // Validar que ningún campo esté vacío.
      if(elCodigo.isEmpty() || elModelo.isEmpty() || laMarca.isEmpty() || laPlaca.isEmpty() || elColor.isEmpty() || elPrecio.isEmpty())
      {
        JOptionPane.showMessageDialog(this, "¡¡Por favor complete todos los campos antes de guardar!!");
        return;
      }

      int elPrecioInt;
      try {
        elPrecioInt = Integer.parseInt(elPrecio);
      } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "¡¡El precio debe ser un número entero válido!!");
        return;
      }
      
      // Creamos un vehículo con los datos registrados por el usuario y lo registramos en la lista de vehiculos.
      Vehiculo unVehiculo = new Vehiculo(elCodigo, elModelo, laMarca, laPlaca, elColor, elPrecioInt);
      unaListaDeVehiculos.add(unVehiculo);

      // Limpiar la tabla cada que se introduce una nueva fila para volver a imprimirla.
      DefaultTableModel modeloDeLaTabla = (DefaultTableModel)listaDeVehiculos.getModel(); 
      modeloDeLaTabla.setRowCount(0);
      
      // Bucle que se encarga de registrar vehículos.
      for(int cual = 0; cual < unaListaDeVehiculos.size(); cual++)
      {
        Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};
      
      estructura.addRow(elVehiculo);
      }
      
      limpiarTextFields();
    }
    
    //***********Botón Buscar por modelo*************
    if(evento.getSource()==botonBusquedaModelo)
    {
      // Limpiamos la tabla para volver a registrar nuestros datos.
      DefaultTableModel modeloDeLaTabla = (DefaultTableModel)listaDeVehiculos.getModel(); 
      modeloDeLaTabla.setRowCount(0);

      // Leemos el dato del usuario.
      String modeloABuscar = buscardorXModelo.getText();

      // Recorremos el ArrayList en busca de los vehículos que coinciden con el modelo que indicó el usuario.
      int vehiculosHallados = 0; // Contador.
      for(int cual = 0; cual < unaListaDeVehiculos.size(); cual ++)
      {
        if((unaListaDeVehiculos.get(cual)).getModelo().equalsIgnoreCase(modeloABuscar))
        {
          Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};

          estructura.addRow(elVehiculo);
          vehiculosHallados++;
        }
        // Si se ha recorrido hasta el último elemento del ArrayList y no se encontró ningún vehículo, muestra una ventana emergente, después imprime la tabla inicial.
        if(cual == (unaListaDeVehiculos.size()-1) && vehiculosHallados == 0)
        {
          JOptionPane.showMessageDialog(this, "¡¡No se han encontrado automóviles del modelo indicado!!");
          refrescarTabla();
        }
      }
    }

    //***********Botón Búsqueda por precio*************
    if(evento.getSource()==botonBusquedaPrecio)
    {
      String desde = buscarDesde.getText().trim();
      int desdeValor=0;

      String hasta = buscarHasta.getText().trim();
      int hastaValor=Integer.MAX_VALUE;

      // Validamos que los datos recibidos sean datos operables.
      if(!desde.equals("") && desde.matches("\\d+"))
      {
        desdeValor = Integer.parseInt(desde);
      }

      if(!hasta.equals("") && hasta.matches("\\d+")) {
        hastaValor = Integer.parseInt(hasta);
      }

      // Limpiamos la tabla para volver a registrar nuestros datos en cada ciclo.
      DefaultTableModel modeloDeLaTabla = (DefaultTableModel)listaDeVehiculos.getModel(); 
      modeloDeLaTabla.setRowCount(0);

      // Recorremos el ArrayList en busqueda  del auto cuyo precio se encuentra dentro del rango indicado por el usuario.
      int vehiculosHallados = 0; // Contador.
      for(int cual = 0; cual < unaListaDeVehiculos.size(); cual++)
      {
        if((unaListaDeVehiculos.get(cual).getPrecio() >= desdeValor) && (unaListaDeVehiculos.get(cual).getPrecio() <= hastaValor))
        {
          Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};
  
          estructura.addRow(elVehiculo);
          vehiculosHallados++;
        }
        if(cual == unaListaDeVehiculos.size()-1 && vehiculosHallados == 0)
        {
          JOptionPane.showMessageDialog(this, "¡¡No se han encontrado automóviles con un precio\n dentro del rango establecido!!");
          refrescarTabla();
          break;
        }
        
      }
    }
    
    //***********Botón Cerrar*************
    if(evento.getSource()==cerrar)
    {
      this.dispose();
    }

    //***********Menú "Acerca de", Opción de SubMenú "Integrantes"*************
    if(evento.getSource()==integrantes)
    {
      JOptionPane.showMessageDialog(this, "Integrantes:"+ "\nJuan Camilo Puentes Ceballos - 1842846" + "\nJaiver Quitumbo Escué - 1825333" + "\nBrayan Fernando Cruz Puerta - 2041217" + "\nManuel Alejandro Medina Gonzalez - 1943270" + "\nJuan Camilo Agrace Landazury - 1942667");
    }

    //************Menú "Acciones", opción de SubMenú "Búsqueda por modelo"*************
    if(evento.getSource()==buscarXModelo)
    {
      String modeloABuscar = buscardorXModelo.getText();
      TablaEmergente tablaEmergenteBusquedaModelo = new TablaEmergente();
      
      // Recorremos el ArrayList en busca de los vehículos que coinciden con el modelo que indicó el usuario.  
      int vehiculosHallados = 0;
      for(int cual = 0; cual < unaListaDeVehiculos.size(); cual ++)
      {
        if((unaListaDeVehiculos.get(cual)).getModelo().equalsIgnoreCase(modeloABuscar))
        {
          Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};

          tablaEmergenteBusquedaModelo.anadirFila(elVehiculo);
          vehiculosHallados++;
        }
        // Si se ha recorrido hasta el último elemento del ArrayList y no se encontró ningún vehículo, muestra una ventana emergente, después imprime la tabla inicial.
        if(cual == (unaListaDeVehiculos.size()-1) && vehiculosHallados == 0)
        {
          tablaEmergenteBusquedaModelo.dispose();
          JOptionPane.showMessageDialog(this, "¡¡No se han encontrado automóviles del modelo indicado!!");
          refrescarTabla();
          break;
        }
      }
    }

    //***********Menú "Acciones", Opción de SubMenú "Búsqueda por precio"*************
    if(evento.getSource() == buscarXPrecio)
    {
      String desde = buscarDesde.getText().trim();
      int desdeValor=0;

      String hasta = buscarHasta.getText().trim();
      int hastaValor=Integer.MAX_VALUE;

      if(!desde.equals("") && desde.matches("\\d+"))
      {
        desdeValor = Integer.parseInt(desde);
      }

      if(!hasta.equals("") && hasta.matches("\\d+"))
      {
        hastaValor = Integer.parseInt(hasta);
      }

      // Creamos una ventana emergente que mostrará los datos al usuario.
      TablaEmergente tablaEmergenteBusquedaPrecio = new TablaEmergente();

      // Recorremos el ArrayList en busqueda  del auto cuyo precio se encuentra dentro del rango indicado por el usuario.
      int vehiculosHallados = 0;
      for(int cual = 0; cual < unaListaDeVehiculos.size(); cual++)
      {
        if((unaListaDeVehiculos.get(cual).getPrecio() >= desdeValor) && (unaListaDeVehiculos.get(cual).getPrecio() <= hastaValor))
        {
          Object[] elVehiculo = {(unaListaDeVehiculos.get(cual)).getCodigo(), (unaListaDeVehiculos.get(cual)).getModelo(), (unaListaDeVehiculos.get(cual)).getMarca(), (unaListaDeVehiculos.get(cual)).getPlaca(), (unaListaDeVehiculos.get(cual)).getColor(), (unaListaDeVehiculos.get(cual)).getPrecio()};

          tablaEmergenteBusquedaPrecio.anadirFila(elVehiculo);
          vehiculosHallados++;
        }
        if(cual == unaListaDeVehiculos.size()-1 && vehiculosHallados == 0)
        {
          tablaEmergenteBusquedaPrecio.dispose();
          JOptionPane.showMessageDialog(this, "¡¡No se han encontrado automóviles con un precio\n dentro del rango establecido!!");
          refrescarTabla();
          break;
        }        
      }
    }  
  }
}

class TablaEmergente extends JFrame
{
  private JPanel panel1;
  private JTable tabla1;
  private DefaultTableModel concesionario;
  private Object datos[][];
  private String nombresColumnas[]={"Codigo", "Modelo","Marca", "Placa","Color", "Precio"};
  private JScrollPane js;
  
  // Métodos.
  public TablaEmergente()
  {
    panel1 = new JPanel();
    panel1.setLayout(null);
    tabla1 = new JTable();
    concesionario = new DefaultTableModel(datos, nombresColumnas);
    tabla1.setModel(concesionario);
    js = new JScrollPane();
    js.setViewportView(tabla1);
    
    this.add(panel1);
    
    this.setTitle("Resultados hallados");
    this.add(js);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setSize(400,200);
    this.setMinimumSize(new Dimension(390,190));
    this.setVisible(true);
  }

  // Método que permite añadir un auto a la tabla.
  public void anadirFila(Object[] unObjeto)
  {
    concesionario.addRow(unObjeto);
  }
}

class Vehiculo {
  // Atributos.
  private String codigo;
  private String modelo;
  private String marca;
  private String placa;
  private String color;
  private int precio;
  
  // Métodos.
  public Vehiculo(){}
  public Vehiculo(String _codigo, String _modelo, String _marca, String _placa, String _color, int _precio){
    this.codigo = _codigo;
    this.modelo = _modelo;
    this.marca = _marca;
    this.placa = _placa;
    this.color = _color;
    this.precio = _precio;
  }
  
  // Código.
  public void setCodigo(String _codigo)
  {
    this.codigo=_codigo;
  }
  
  public String getCodigo()
  {
    return codigo;
  }
  
  // Modelo.
  public void setModelo(String _modelo)
  {
    this.modelo=_modelo;
  }
  
  public String getModelo()
  {
    return modelo;
  }
  
  // Marca.
  public void setMarca(String _marca)
  {
    this.marca=_marca;
  }
  
  public String getMarca(){
    return marca;
  }
  
  //Placa
  public void setPlaca(String _placa)
  {
    this.placa=_placa;
  }
  
  public String getPlaca()
  {
    return placa;
  }
  // Color.
  public void setColor(String _color)
  {
    this.color=_color;
  }
  
  public String getColor()
  {
    return color;
  }
  
  // Precio.
  public void setPrecio(int _precio)
  {
    this.precio=_precio;
  }
  
  public int getPrecio()
  {
    return precio;
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    // Creamos un concesionario.
    // El concesionario ya incluye 4 vehículos registrados por defecto con el fin de facilitar la prueba de funcionalidad.
    SwingUtilities.invokeLater(() -> new InterfazVehiculo());
  }
}