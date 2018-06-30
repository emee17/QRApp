package lesson_Basic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRcode {

	public static void main(String[] args) throws IOException 
	{
		String details ="Hello this is my first QR \n time i generate Qr by java";
		
		ByteArrayOutputStream out = QRCode.from(details).to(ImageType.JPG).stream();
		
		File f = new File("D:\\Downloads\\MyFirstQR.jpg");
		
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(out.toByteArray());
		
		fos.flush();
		
	}

}
