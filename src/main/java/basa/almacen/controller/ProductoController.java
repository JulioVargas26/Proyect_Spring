package basa.almacen.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import basa.almacen.entity.Producto;
import basa.almacen.entity.Tipo;
import basa.almacen.service.ProductoService;
import basa.almacen.service.TipoService;

@Controller
@RequestMapping("")
public class ProductoController {

	@Autowired
	private TipoService serTipo;
	@Autowired
	private ProductoService serProd;

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("Tipo", serTipo.listarTipo());
		model.addAttribute("Producto", serProd.listarProductos());
		return "index";
	}
	
	@RequestMapping("/grabar")
	public String grabarModel(@RequestParam("Codigo") Integer cod, @RequestParam("Insumo") int ins,
			@RequestParam("Fecha") String fec, @RequestParam("CantSal") int cas, @RequestParam("GuiaSal") String gsa,
			@RequestParam("CantIng") int cai, @RequestParam("GuiaIng") String gin, RedirectAttributes redirect) {
		try {

			Producto sm = new Producto();

			sm.setCant_salida(cas);
			sm.setGuia_salida(gsa);
			sm.setCant_ingreso(cai);
			sm.setGuia_ingreso(gin);
			sm.setFecha(LocalDate.parse(fec));
			
			int mer= cai - cas;
			sm.setMerma(mer);

			Tipo tm = new Tipo();
			tm.setId_tipo(ins);
			sm.setTipo(tm);

			if (cod == 0) {
				serProd.grabar(sm);
				redirect.addFlashAttribute("MENSAJE", "PRODUCTO REGISTRADO");
			} else {
				sm.setId_producto(cod);
				serProd.actualizar(sm);
				redirect.addFlashAttribute("MENSAJE", "PRODUCTO ACTUALIZADO");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			redirect.addFlashAttribute("mensaje", "Error en el Registro");
			e.printStackTrace();
		}
		return "redirect:/";

	}
	
	

	@RequestMapping("/buscar")
	@ResponseBody
	public Producto buscar(@RequestParam("Codigo") int cod) {
		return serProd.buscar(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("Codigo") int cod,RedirectAttributes redirect) {
		try {
			serProd.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado correctamente");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	
	@RequestMapping("/insumo")
	public String grabarInsumo(@RequestParam("CodigoIns") Integer cod,@RequestParam("Descripcion") String des, RedirectAttributes redirect) {
		try {
			Tipo tm = new Tipo();
			tm.setDescripcion(des);

				
				if (cod == 0) {
					serTipo.grabar(tm);
					redirect.addFlashAttribute("MENSAJE", "INSUMO REGISTRADO");
				} else {
					tm.setId_tipo(cod);
					serTipo.actualizar(tm);
					redirect.addFlashAttribute("MENSAJE", "INSUMO ACTUALIZADO");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			redirect.addFlashAttribute("mensaje", "Error en el Registro");
			e.printStackTrace();
		}
		return "redirect:/";

	}
	
	@RequestMapping("/buscarIns")
	@ResponseBody
	public Tipo buscarIns(@RequestParam("CodigoIns") int cod) {
		return serTipo.buscar(cod);
	}

	@RequestMapping("/eliminarIns")
	public String eliminarIns(@RequestParam("CodigoIns") int cod,RedirectAttributes redirect) {
		try {
			serTipo.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado correctamente");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}
