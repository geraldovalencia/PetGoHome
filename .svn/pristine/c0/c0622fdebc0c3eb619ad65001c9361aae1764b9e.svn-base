package br.com.petGoHome.QrCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

import com.google.zxing.WriterException;

public class MainQrCode {
	
	public static void main(String[] args) {
		
	List<Tag> tags = new ArrayList<Tag>();
	List<Tag> tagsLimitadas = new ArrayList<Tag>();
	
	tags = Fachada.listarTodasTAGS();
	
	for (int i = 0; i < 500;  i++) {
		
		tagsLimitadas.add(tags.get(i));
		System.out.println("Adicionando TAG: Nº - "+i );
	}
	
	final String filePathQRCode = "C:/TAGS/";
	String nomeArquivo = "";
	String qrCodeText = "";	
	
	if(tags.size() != 0){
		for (Tag tag : tagsLimitadas) {
			
			
			nomeArquivo = tag.getValorTag() + ".png";
			qrCodeText = "http://www.petgohome.com.br/Busca-Tag.pet?numeroTag="+tag.getValorTag();
			//qrCodeText = "http://168.235.149.72:8080/PetGoHome/Busca-Tag.pet?numeroTag="+tag.getValorTag();
			int size = 125;
			String fileType = "png";
			File qrFile = new File(filePathQRCode + File.separator + nomeArquivo);

			try {
				try {
					GerarQRCode.createQRImage(qrFile, qrCodeText, size, fileType);
					System.out.println("Gerou QRCODE: "+nomeArquivo );
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println("Erro na criação das tags");
				}
			} catch (WriterException e) {
			}
		}
	}
		
	//[gerar qualquer tipo de tag com link de qualquer coisa descomentar aqui]---------------------------------------------------------------------------------
	
	/*---------------------
	
	final String filePathQRCode = "C:/TAGS/";
	String nomeArquivo = "";
	String qrCodeText = "";	
	
			
			nomeArquivo = "Manual.png";
			qrCodeText = "https://www.dropbox.com/s/bfzl6s37357sq7l/Manual_SIAF_V.pdf?dl=0";
			//qrCodeText = "http://168.235.149.72:8080/PetGoHome/Busca-Tag.pet?numeroTag="+tag.getValorTag();
			int size = 125;
			String fileType = "png";
			File qrFile = new File(filePathQRCode + File.separator + nomeArquivo);

			try {
				try {
					GerarQRCode.createQRImage(qrFile, qrCodeText, size, fileType);
					System.out.println("Gerou QRCODE: "+nomeArquivo );
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println("Erro na criação das tags");
				}
			} catch (WriterException e) {
			}
		}
	
	*/
	
	//---------------------------------------------------------------------------------

	//final String filePathQRCode = this.getServletContext().getRealPath("/imagens/");
	//final String filePathQRCode = "C:/xampp/htdocs/imagens/";
	//final String nomeArquivo = "QrImagemTemporario.png";
	
	
//	String qrCodeText = ""+produto.getId();	

	

//	String urlDaImagem = "http://localhost/imagens//" + produto.getUrlDaImagem();

//	File fileDelete = new File(filePathQRCode + File.separator + nomeArquivo);	
//	try {
//		fileDelete.delete();
//		//			qrFile.delete();
//	} catch (Exception e1) {
//	}	

	

	}
}
