package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequestMapping("/Empleado")
//@RestController

@Controller
public class ControladorEmpleado {


    @Autowired
    private ServicioEmpleado empl;

//   @GetMapping
//  public List<Empleado> listar()  {
//        return empl.listarEmpleados();
//    }
//    @GetMapping("/{id}")
//   public Empleado consultarPorcedula(@PathVariable("documentoEmpleado") Integer documentoEmpleado){
//       return empl.consultarEmpleadosid(documentoEmpleado);
//  }

//    @PostMapping
//    public Empleado insertar(@RequestBody Empleado empleado ){
//        return  empl.guardarEmpleados(empleado);
//    }


//    @PutMapping
//    public Empleado actualizar(@RequestBody Empleado empleado) {
//        return empl.actualizarEmpleados(empleado);
//    }

//    @DeleteMapping("/{id}")
 //   public String eliminarporId(@PathVariable("documentoEmpleado") Integer documentoEmpleado){
//        boolean respuesta= empl.eliminarEmpleados(documentoEmpleado);

//        if (respuesta){
//            return "Se eliminó el empleado"+documentoEmpleado+"con éxito";
//        }else{
//            return "No se pudo eliminar correctamente el empleado"+documentoEmpleado;
//        }

//    }



//    @PatchMapping("/Empleado/{id}")
//    public Empleado actualizarpor(@PathVariable("documentoempleado") Integer documentoEmpleado, @RequestBody Map<Object,Object> objectMap){
//        return empl.actualizarPorId(documentoEmpleado,objectMap);
//    }

    // controlador para obtener la tabla Empleado en la interfaz

   @GetMapping("/Empleado")
       public String listarEmpleados(Model modelo){
       modelo.addAttribute("Empleado",empl.listarEmpleados());
        return("tablaempleado");
    }

    // controlador para registrar un nuevo Empleado de dinero con el formulario

    @GetMapping("Empleado/nuevo")
        public String formualrioregistroempleado(Model modelo){
        modelo.addAttribute("empleadoinsertar",new Empleado());
        return "frmnuevoempleado";
    }
    // controlador para actualizar la tabla con el empleado creado
    @PostMapping("Empleado/guardar")
        public String insertar(Empleado empleado){
        empl.guardarEmpleados(empleado);
        return "redirect:/Empleado";
    }




}
