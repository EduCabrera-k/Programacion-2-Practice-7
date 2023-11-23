import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.Scanner;


public class WebMaker implements Serializable {
	
	private String webTitle;
	private String pageHeader;
	private StringBuilder pageBody;
	private String pageFooter;
	
	public WebMaker() {
		this.webTitle = "Mi p&aacute;gina web";
		this.pageHeader = null;
		this.pageBody = new StringBuilder();
		this.pageFooter = null;
	}
	
	
	public String imprimirEncabezado() {
		if(pageHeader == null) {
			StringBuilder sb = new StringBuilder();
			
			sb.append("<!DOCTYPE html>");
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>");
			sb.append(webTitle);
			sb.append("</title>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("<h1>");
			sb.append("Est&aacute; es mi p&aacute;gina web!");
			sb.append("</h1>");
			
			this.pageHeader = sb.toString();
		}
		
		return this.pageHeader;
	}
	

	public String imprimirTexto(String texto) {
		StringBuilder aux = new StringBuilder();
		
		aux.append("<p>");
		aux.append(texto);
		aux.append("</p>");

		this.pageBody.append(aux.toString());
		

		return aux.toString();
	}
	

	public String insertarImagen(String imagename) {
		StringBuilder aux = new StringBuilder();
		
		aux.append("<img src=\"");
		aux.append(imagename);
		aux.append("\">");
		

		this.pageBody.append(aux.toString());
		

		return aux.toString();
	}
	

	public String imprimirCierre() {
		if (this.pageFooter == null) {
			StringBuilder aux = new StringBuilder();
			
			aux.append("<footer>");
			aux.append("<p style=\"font-size=8px; font-family:sans-serif;\">");
			aux.append("Made with WebMaker&trade;. &copy; 2013 - 2014 Facultad de Ingenier&iacute;a. Algunos derechos reservados");
			aux.append("</p>");
			aux.append("</body>");
			aux.append("</html>");
			
			this.pageFooter = aux.toString();
		}
		

		this.savePage();
		
		return this.pageFooter;
	}

	public String printPage() {
		return this.imprimirEncabezado() + this.pageBody.toString() + this.getForm() + this.imprimirCierre();
	}
	

	private String getForm() {
		StringBuilder aux = new StringBuilder();
		
		try {
			Scanner in = new Scanner(new FileInputStream("form.txt"));
		
			while(in.hasNext())
			aux.append(in.nextLine());
		
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return aux.toString();
	}
	

	private void savePage() {
		try {

			FileOutputStream outputStream = new FileOutputStream("web.obj");
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			
		
			out.writeObject(this);
	
			out.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}