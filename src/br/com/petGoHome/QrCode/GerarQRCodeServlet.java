package br.com.petGoHome.QrCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.entidades.Tag;

import com.google.zxing.WriterException;

    public class GerarQRCodeServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;

    	public GerarQRCodeServlet() {
    		super();
    		// TODO Auto-generated constructor stub
    	}

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		String idProduto = request.getParameter("idProduto");	

    		//Produto produto = QRComprasFachada.buscaProdutoPorId(new Long(idProduto));
    		List<Tag> tags = new ArrayList<>();
    		
    		
    		PrintWriter out = response.getWriter();		

    		//final String filePathQRCode = this.getServletContext().getRealPath("/imagens/");
    		//final String filePathQRCode = "C:/xampp/htdocs/imagens/";
    		final String filePathQRCode = "C:/xampp/htdocs/imagens/";
    		final String nomeArquivo = "QrImagemTemporario.png";
    		
    		
    		//String qrCodeText = ""+produto.getId();	
    		String qrCodeText = "";	

    		

    	//	String urlDaImagem = "http://localhost/imagens//" + produto.getUrlDaImagem();

    		File fileDelete = new File(filePathQRCode + File.separator + nomeArquivo);	

    		try {
    			fileDelete.delete();
    			//			qrFile.delete();
    		} catch (Exception e) {
    			// TODO: handle exception
    		}	

    		int size = 125;
    		String fileType = "png";
    		File qrFile = new File(filePathQRCode + File.separator + nomeArquivo);

    		try {
    			GerarQRCode.createQRImage(qrFile, qrCodeText, size, fileType);
    		} catch (WriterException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	

    		

//    		out.println("<html>");
//    		out.println("<head>");
//    		out.println("<title>");
//    		out.println("Imagem QR Code");
//    		out.println("</title>");		
//    		out.println("<link rel='stylesheet' type='text/css' href='css/estilo.css' media='screen' />");			
//    		out.println("</head>");
//    		out.println("<body>");
//
//    		out.println("<div id='general'>");
//
//
//    		out.println("<h1><center>QR Compras</center></h1>");
//
//    		out.println("<div class='colleft'>");
//
//    		out.println("<img id='imag' src='"+urlDaImagem+"' alt='imagem' width='502' height='488'  />");
//
//
//    		out.println("</div>");
//
//    		out.println("<div class='content'>");
//    		out.println("<br />");
//    		out.println("<br />");	
//    		out.println("<br />");	
//    		
//    		out.println("<h2>"+produto.getNome()+"</h2>");
//    		out.println("<span><strong>"+produto.getDescricao()+"</strong> </span>");
//    		out.println("<p><strong>"+NumberFormat.getCurrencyInstance().format(produto.getPreco())+"</strong></p>");
//
//    		out.println("<img src='http://localhost/imagens//QrImagemTemporario.png' alt='QR Code' width='200' height='200'  />");
//    		out.println("</div>");
//
//    		out.println("</div>");


    		//		out.println("<div>");
    		//		
    		//				out.println("<img src='http://localhost/imagens//QrImagemTemporario.png' alt='QR Code' height='200' width='200'>"); 
    		//		out.println("<br />");

    		//		out.println("<input type='button' value='Voltar' onclick=\"location.href='listarProduto.do' \"></td>");
    		//		

    		out.println("</div>");
    		out.println("</body>");					
    		out.println("</html>");



    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    	}

}
