package execucao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

public class MainTeste {
	
//	public static void main(String[] args) {
//		for (int i = 0; i < 38; i++) {
//		System.out.println("rg"+i + ".setNomeRacaGato(");
//		}
//	}
//	public static void main(String[] args) {
//		for (int i = 0; i < 38; i++) {
//		System.out.println("Fachada.salvarRacaGato(rg" + i + ");");
//		}
//	}
//	public static void main(String[] args) {
//		for (int i = 0; i < 31; i++) {
//		System.out.println("<option value='" + i +"' ${dia == '"+i+"' ? 'selected=@selected@' : ''}>"+i+"</option>");
//		}
//	}
//	public static void main(String[] args) {
//		for (int i = 2014; i > 1990; i--) {
//			System.out.println("<option value='" + i +"' ${ano == '"+i+"' ? 'selected=@selected@' : ''}>"+i+"</option>");
//		}
//	}
//	public static void main(String[] args) {
//		
//		Date dataInicioCadastro = new Date( System.currentTimeMillis());
//		//arqui vamos configurar o simple date formate
//        // d = dia, M (maiusculo) = mes e y = ano (obs: m = minutos)
//        SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy"); 
//	    String resultData = null;  
//        
//        //Convertendo a data para string
//	    resultData = formatar.format(dataInicioCadastro);
//	    
//		for (int i = 0; i < 100; i++) {
//			System.out.println("INSERT INTO `tag`(`dataAtivacao`, `dataCriacao`, `valorTag`, `pet_id`, `petshop_id`) VALUES ('null', '"+
//					resultData+"' ,'A1A0"+i+"','null','null'");
//		}
//	}
	public static void main(String[] args) {
		
		//Date dataInicioCadastro = new Date( System.currentTimeMillis());
		
		//CRIANDO VALORES PARA AS TAGS-----------------------	    
	    
//			try {
//				
//				for (int i = 4; i <= 9; i++) {
//				Tag tag = new Tag();
//				tag.setValorTag("A1A000"+ i);
//				tag.setDataCriacao(dataInicioCadastro);
//				Fachada.salvarTAG(tag);
//				System.out.println("Salvou: "+ tag.getValorTag());
//			}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//		}
//			try {
//				
//				for (int i = 10; i <= 99; i++) {
//					Tag tag = new Tag();
//					tag.setValorTag("A1A00"+ i);
//					tag.setDataCriacao(dataInicioCadastro);
//					Fachada.salvarTAG(tag);
//					System.out.println("Salvou: "+ tag.getValorTag());
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			try {
//				
//				for (int i = 100; i <= 999; i++) {
//					Tag tag = new Tag();
//					tag.setValorTag("A1A0"+ i);
//					tag.setDataCriacao(dataInicioCadastro);
//					Fachada.salvarTAG(tag);
//					System.out.println("Salvou: "+ tag.getValorTag());
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		
		
		//Exemplo de THUMBnail  
		
/*
		long startTime = System.currentTimeMillis();
		  File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
		  BufferedImage img = ImageIO.read(f); // load image

		  //Quality indicate that the scaling implementation should do everything
		   // create as nice of a result as possible , other options like speed
		   // will return result as fast as possible
		//Automatic mode will calculate the resultant dimensions according
		//to image orientation .so resultant image may be size of 50*36.if you want
		//fixed size like 50*50 then use FIT_EXACT
		//other modes like FIT_TO_WIDTH..etc also available.

		  BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY,Mode.AUTOMATIC, 
		             50,
		                   50, Scalr.OP_ANTIALIAS);
		   //convert bufferedImage to outpurstream 
		  ByteArrayOutputStream os = new ByteArrayOutputStream();
		  ImageIO.write(thumbImg,"jpg",os);
		  
		  
		  //or wrtite to a file
		  
		  File f2 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum_thumb.jpg");
		  
		  
		  ImageIO.write(thumbImg, "jpg", f2);
		  
		  System.out.println("time is : " +(System.currentTimeMillis()-startTime));
		
		
		*/
		
		
		//CRIA HASH's - SIMPLES 
		//Determia as letras que poderão estar presente nas chaves  
		
		
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ1234567890#$@";  
		  
		Random random = new Random();  
		  
		String armazenaChaves = "";  
		int index = -1;  
		
		for( int i = 0; i < 8; i++ ) {  
		   index = random.nextInt( letras.length() );  
		   armazenaChaves += letras.substring( index, index + 1 );  
		}  
		System.out.println( armazenaChaves ); 
			
		
		
		
		
				//CRIA HASH's - COMPLEXO - CRIA TAGS
				//Determia as letras que poderão estar presente nas chaves  
		
				/*
				String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ1234567890";  
				  
				Random random = new Random();  
				  
				int numeroDeVezes = 500;
				List<String> listaDeHashs = new ArrayList<String>();
				
				for (int x = 0; x < numeroDeVezes; x++) {
					String armazenaChaves = "";  
					int index = -1;  
					
					for( int i = 0; i < 7; i++ ) {  
					   index = random.nextInt( letras.length() );  
					   armazenaChaves += letras.substring( index, index + 1 );  
					}  
					//System.out.println( armazenaChaves ); 
					
					listaDeHashs.add(armazenaChaves);
					System.out.println("Posição: " + x + " / Codigo: "+ listaDeHashs.get(x));
					
					
				}               */
				
		
		
		/*
				
				//SALVANDO TAGS NO BANCO --------------------------------------------
				
				String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ1234567890";  
				
				Random random = new Random();
				
				EntityManagerFactory factory = Persistence
						 .createEntityManagerFactory("petgohome");
						 EntityManager manager = factory.createEntityManager();
				
				int numeroDeVezes = 500;
				List<String> listaDeHashs = new ArrayList<String>();
				
				for (int x = 0; x < numeroDeVezes; x++) {
					String armazenaChaves = "";  
					int index = -1;  
					Tag tag = new Tag();
					
					for( int i = 0; i < 7; i++ ) {  
						index = random.nextInt( letras.length() );  
						armazenaChaves += letras.substring( index, index + 1 );  
					}  
					//System.out.println( armazenaChaves ); 
					
					listaDeHashs.add(armazenaChaves);
					System.out.println("Posição: " + x + " / Codigo: "+ listaDeHashs.get(x));
					
						tag.setDataCriacao(new Date (System.currentTimeMillis()));
						tag.setValorTag(armazenaChaves);
						Fachada.salvarTAG(tag);
						
					
				}
		 */
	}

}
