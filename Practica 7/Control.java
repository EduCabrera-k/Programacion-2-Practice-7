import java.util.Scanner;
import java.io.*;

public class Control{
	public static void main(String[]args){
/*
	WebMaker generador=new WebMaker();
	try {
            PrintWriter escritor = new PrintWriter("index.html");
            Scanner lector = new Scanner(new FileReader("form.txt"));

		escritor.println(generador.imprimirEncabezado());

		escritor.println(generador.imprimirTexto("El mejor jugador!"));
		escritor.println(generador.insertarImagen("Messi.jpg"));

		while(lector.hasNext()){
			escritor.println(lector.nextLine());
		}
		escritor.println(generador.imprimirCierre());
		lector.close();
		escritor.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

	try {
		DataOutputStream escritor = new DataOutputStream(new FileOutputStream("hola.bin"));
		escritor.writeInt(33465);
		escritor.writeChar('a');
		escritor.writeChar('z');
		escritor.writeShort(10);
		
		escritor.close();

		DataInputStream lector=new DataInputStream(new FileInputStream("hola.bin"));
		System.out.println(lector.readInt());
		System.out.println(lector.readChar());
		System.out.println(lector.readChar());
		System.out.println(lector.readShort());

		escritor.close();
	} catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }

*/
	 try {	
		ObjectInputStream lector = new ObjectInputStream(new FileInputStream("web.obj"));
		PrintWriter escritor = new PrintWriter("index.html");
		WebMaker pagina=(WebMaker)(lector.readObject());
		escritor.print(pagina.printPage());

		lector.close();
		escritor.close();
	} catch (FileNotFoundException e) {

        } catch (IOException e) {
            
        } catch (ClassNotFoundException e) {
            
        }
		
    }
}