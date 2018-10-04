import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Main {
	public static void main(String[] args) {	
		try {
			String ruta = "C:\\camara\\camaras.xml";
			SAXBuilder sax = new SAXBuilder();
			Document document = sax.build(new File(ruta));
			parsearXML(document);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void parsearXML(Document document) {
		Element raiz = document.getRootElement();
		List<Element> lista_elementos = raiz.getChildren("Camara");
		for (int i = 0; i < lista_elementos.size(); i++) {
			Element elemento_alumno = lista_elementos.get(i);
			List<Element> lista_elementos2 = raiz.getChildren("Posicion");
			for (int j = 0; j < lista_elementos2.size(); j++) {
				Element elemento_posicion = lista_elementos2.get(j);
				Element elemento_nombre = elemento_alumno.getChild("Latitud");
				Element elemento_edad = elemento_alumno.getChild("Longitud");
			}
			Element elemento_nombre = elemento_alumno.getChild("Latitud");
			Element elemento_edad = elemento_alumno.getChild("Longitud");
			//Element elemento_numero = elemento_alumno.getChild("URL");
			System.out.println("Nombre: " + elemento_nombre.getText() + " Edad: " + elemento_edad.getText());
		}
	}
}
