package com.proyecto.practicas.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Empresa;
import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.OfertaServices;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class OfertasController {
	
	
	private final String urlOfertas="ofertas/Ofertas";
	
	@GetMapping(value = "/carrera/ofertas/{id}")
	public String getOfertasPorCarrera(@PathVariable(name = "id")Long id,Model model) {
		
	    List<OfertaPractica> listaOfertas = new ArrayList<>();

        // Crear y agregar 10 ofertas con empresas diferentes
        for (int i = 1; i <= 10; i++) {
            OfertaPractica oferta = new OfertaPractica();
            oferta.setNombre("Oferta " + i);
            oferta.setDescripcion("\r\n"
            		+ "<div class=\"mb40 pb40 bb1\" div-link=\"oferta\">\r\n"
            		+ "    <h3 class=\"fwB fs18 mb20\">Descripci&#243;n de la oferta</h3>\r\n"
            		+ "    <div class=\"mbB\">\r\n"
            		+ "            <span class=\"tag base mb10\">A convenir</span>\r\n"
            		+ "                    <span class=\"tag base mb10\">Contrato a t&#233;rmino indefinido</span>\r\n"
            		+ "                    <span class=\"tag base mb10\">Tiempo Completo</span>\r\n"
            		+ "            </div>\r\n"
            		+ "    <p class=\"mbB\">En Webhelp Bogotá te estamos buscando. Si te gusta ayudar a los usuarios a conocer otros horizontes, dar soluciones, y tienes excelente energía, este es el lugar indicado para explorar todo tu potencial. Ven y conoce un lugar mágico para trabajar como Asesor de Atención al Cliente. Solo necesitas 6 meses de experiencia en call center.<br /><br />¿Qué te ofrecemos?<br /><br />- -Salario mínimo + Bono por cumplimiento de indicadores o comisiones sin techo.<br /><br />- -Valor hora conexión:  $6.028,4 COP<br /><br />- -Contrato a término indefinido.<br /><br />--Domingo a Domingo con un día compensatorio a la semana.<br /><br />- -Trabajo a tiempo completo.<br /><br />- -Capacitación pagada en bonos Sodexo<br /><br />- -Todos los beneficios de ley.<br /><br />¡Y lo mejor! Contamos con maravillosos beneficios para ti.<br /><br />- -Descuentos en optometría<br /><br />- -Descuentos en restaurantes.<br /><br />- -Descuentos en tiendas de tecnología.<br /><br />- -Descuentos en academias de idiomas.<br /><br />- -Descuentos en gimnasios.<br /><br />- -Descuentos en entretenimiento.<br /><br />- -Servicio Mi Casa Increyble.<br /><br />Además, contamos con nuestro Plan Carrera, donde podrás crecer y hacer tus sueños realidad, participando de convocatorias internas luego de 6 meses de ser contratado(a)<br /><br />¿Cuáles serán tus tareas?<br /><br />- -Brindar atención al cliente<br /><br />- -Resolver preguntas e inquietudes<br /><br />- -Sugerir productos a los clientes<br /><br /><br /><br />¿Qué esperas para trabajar con nosotros?<br /><br />¡Postúlate ya!</p>\r\n"
            		+ "\r\n"
            		+ "        <p class=\"fwB fs18 mtB mb10\">Requerimientos</p>\r\n"
            		+ "        <ul class=\"disc mbB\">\r\n"
            		+ "            <li class='mb10'>Educación mínima: Bachillerato / Educación Media</li><li class='mb10'>Menos de 1 año de experiencia</li><li class='mb10'>Idiomas: Español </li><li class='mb10'>Edad: A partir de 18 años</li><li class='mb10'>Conocimientos: Habilidad comercial, networking, Servicio al cliente, Soporte al cliente, Ventas, Call Center</li>\r\n"
            		+ "        </ul>\r\n"
            		+ "            <p class=\"fc_aux fs13 mbB mtB\">Palabras clave: advisor, service, costumer</p>\r\n"
            		+ "\r\n"
            		+ "    <p class=\"fc_aux fs13\">Hace 1 hora </p>\r\n"
            		+ "    <div class=\"posSticky_m bottom0 bg_white pAllB_m mtB\">\r\n"
            		+ "        <div class=\"w40 dFlex tc_fx mAuto w100_m\">\r\n"
            		+ "                <a data-href-offer-apply=\"https://candidato.co.computrabajo.com/match/?oi=155A5867F8CD708F61373E686DCF3405&amp;p=47&amp;idb=1\" class=\"b_primary big w100\" data-js-t-d>Aplicar</a>\r\n"
            		+ "            <button class=\"b_heart ml10 js_click_btn_heart \" data-heart data-oi=\"155A5867F8CD708F61373E686DCF3405\" aria-label=\"Add favorite\">\r\n"
            		+ "    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 -28 512.001 512\" height=\"22\" width=\"22\"><path d=\"m256 455.515625c-7.289062 0-14.316406-2.640625-19.792969-7.4375-20.683593-18.085937-40.625-35.082031-58.21875-50.074219l-.089843-.078125c-51.582032-43.957031-96.125-81.917969-127.117188-119.3125-34.644531-41.804687-50.78125-81.441406-50.78125-124.742187 0-42.070313 14.425781-80.882813 40.617188-109.292969 26.503906-28.746094 62.871093-44.578125 102.414062-44.578125 29.554688 0 56.621094 9.34375 80.445312 27.769531 12.023438 9.300781 22.921876 20.683594 32.523438 33.960938 9.605469-13.277344 20.5-24.660157 32.527344-33.960938 23.824218-18.425781 50.890625-27.769531 80.445312-27.769531 39.539063 0 75.910156 15.832031 102.414063 44.578125 26.191406 28.410156 40.613281 67.222656 40.613281 109.292969 0 43.300781-16.132812 82.9375-50.777344 124.738281-30.992187 37.398437-75.53125 75.355469-127.105468 119.308594-17.625 15.015625-37.597657 32.039062-58.328126 50.167969-5.472656 4.789062-12.503906 7.429687-19.789062 7.429687zm-112.96875-425.523437c-31.066406 0-59.605469 12.398437-80.367188 34.914062-21.070312 22.855469-32.675781 54.449219-32.675781 88.964844 0 36.417968 13.535157 68.988281 43.882813 105.605468 29.332031 35.394532 72.960937 72.574219 123.476562 115.625l.09375.078126c17.660156 15.050781 37.679688 32.113281 58.515625 50.332031 20.960938-18.253907 41.011719-35.34375 58.707031-50.417969 50.511719-43.050781 94.136719-80.222656 123.46875-115.617188 30.34375-36.617187 43.878907-69.1875 43.878907-105.605468 0-34.515625-11.605469-66.109375-32.675781-88.964844-20.757813-22.515625-49.300782-34.914062-80.363282-34.914062-22.757812 0-43.652344 7.234374-62.101562 21.5-16.441406 12.71875-27.894532 28.796874-34.609375 40.046874-3.453125 5.785157-9.53125 9.238282-16.261719 9.238282s-12.808594-3.453125-16.261719-9.238282c-6.710937-11.25-18.164062-27.328124-34.609375-40.046874-18.449218-14.265626-39.34375-21.5-62.097656-21.5zm0 0\" fill=\"#0D3878\"></path></svg>\r\n"
            		+ "    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 -28 512.00002 512\" height=\"22\" width=\"22\"><path d=\"m471.382812 44.578125c-26.503906-28.746094-62.871093-44.578125-102.410156-44.578125-29.554687 0-56.621094 9.34375-80.449218 27.769531-12.023438 9.300781-22.917969 20.679688-32.523438 33.960938-9.601562-13.277344-20.5-24.660157-32.527344-33.960938-23.824218-18.425781-50.890625-27.769531-80.445312-27.769531-39.539063 0-75.910156 15.832031-102.414063 44.578125-26.1875 28.410156-40.613281 67.222656-40.613281 109.292969 0 43.300781 16.136719 82.9375 50.78125 124.742187 30.992188 37.394531 75.535156 75.355469 127.117188 119.3125 17.613281 15.011719 37.578124 32.027344 58.308593 50.152344 5.476563 4.796875 12.503907 7.4375 19.792969 7.4375 7.285156 0 14.316406-2.640625 19.785156-7.429687 20.730469-18.128907 40.707032-35.152344 58.328125-50.171876 51.574219-43.949218 96.117188-81.90625 127.109375-119.304687 34.644532-41.800781 50.777344-81.4375 50.777344-124.742187 0-42.066407-14.425781-80.878907-40.617188-109.289063zm0 0\" fill=\"#f5597c\"></path></svg>\r\n"
            		+ "</button>\r\n"
            		+ "\r\n"
            		+ "        </div>\r\n"
            		+ "    </div>\r\n"
            		+ "\r\n"
            		+ "    <div class=\"dFlex vm_fx tc_fx mt15 tc mt0_m\">\r\n"
            		+ "        <div class=\"mr15 ml15 posRel\">\r\n"
            		+ "            <a data-create-alert=\"downapplybutton\">\r\n"
            		+ "                <span class=\"icon i_alert mr5 \"></span>\r\n"
            		+ "                Av&#237;same con ofertas similares\r\n"
            		+ "            </a>\r\n"
            		+ "        </div>\r\n"
            		+ "            <div class=\"mr15 ml15\">\r\n"
            		+ "                <a title=\"Denunciar empleo\" data-complaint-offer-openpopup-button>\r\n"
            		+ "                    <span class=\"icon i_report mr5\"></span>\r\n"
            		+ "                    Denunciar empleo\r\n"
            		+ "                </a>\r\n"
            		+ "            </div>\r\n"
            		+ "            <div id=\"ok-complaint-response-container\" class=\"box_ok mtB hide\">\r\n"
            		+ "                <h3>Gracias por ayudarnos a mejorar Computrabajo</h3>\r\n"
            		+ "                <p>Nos tomamos muy en serio tus comentarios y lo revisaremos lo antes posible.</p>\r\n"
            		+ "            </div>\r\n"
            		+ "    </div>" + i);
            oferta.setFecha(new Timestamp(System.currentTimeMillis())); // Establecer la fecha actual

            // Crear y establecer empresa para la oferta
            Empresa empresa = new Empresa();
            empresa.setNit((long) (1000000000 + i)); // Ejemplo simple de NIT
            empresa.setTelefono("12345678");
            empresa.setNombre("aws");
            empresa.setDireccion("Dirección de la empresa " + i);
            empresa.setEmail("empresa" + i + "@ejemplo.com");

            // Agregar la oferta a la lista
            oferta.setEmpresa(empresa);
            listaOfertas.add(oferta);
        }
		
		List<OfertaPractica> ofertas=ofertaServices.getOfertasPorCarrera(id);
		
		model.addAttribute("ofertas", listaOfertas);
		model.addAttribute("carrera", carreraServices.getCarreraById(id));
		
		return urlOfertas;
	}
	
	
	
	
	
	@Autowired
	private OfertaServices ofertaServices;
	
	@Autowired
	private CarreraServices carreraServices;
}
